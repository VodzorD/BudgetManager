import java.util.ArrayList;

public class BudgetManager 
{
    BudgetPrint prt;
    BudgetSalary salary;
    ArrayList<BudgetPurchase> listOfPurchase;
    BudgetPurchase purchase;
    String string;
    BudgetFileParse file;


    public BudgetManager()
    {
        prt = new BudgetPrint();
        salary = new BudgetSalary();
        listOfPurchase = new ArrayList<BudgetPurchase>();
        string = "";
        file = new BudgetFileParse();
    }

    public static void main(String[] args)
    {
        BudgetManager manager = new BudgetManager();

        System.out.println("Программа Бюджет Менеджер запущена.\n");
     
        while (!("exit".equalsIgnoreCase(manager.string)))
        {
            BudgetPrint.printMenu();
            manager.string = manager.prt.getIn();
            manager.executingMenuItem();
        }
        System.out.println("Программа Бюджет Менеджер завершена.\n");
    }
    


    public void executingMenuItem()
    {
        if (!("exit".equalsIgnoreCase(string)))
            switch (string)
            {
                case "1":
                    salary.mainSalary();
                    break;
                case "2":
                    purchase = new BudgetPurchase();
                    purchase.mainPurchase();
                    listOfPurchase.add(purchase);
                    break;
                case "3":
                    prt.printList(listOfPurchase);
                    break;
                case "4":
                    prt.printSumOfPunchaseAndSalary(salary);
                    break;
                case "5":

                    prt.printSortingMenu();
                    string = prt.getIn();
                    switch (string)
                    {
                        case "1":
                            prt.printSortListCheap(listOfPurchase);
                            break;
                        case "2":
                            prt.printSortListExpensive(listOfPurchase);
                            break;
                        case "3":
                            prt.printSortListName(listOfPurchase);
                            break;
                        default:
                            break;
                    }            
                    break;
                case "6":
                    prt.printFileLines(file.getFileLines());
                    break;
                case "7":
                    copyList(file.parseFileToPurchase());;
                    prt.printList(listOfPurchase);
                    break;
                case "8":
                    break;
                default:
                    System.out.println("\nПовторите попытку ввода пункта меню. Был выбран не верный пункт.");
                    System.out.println("Вы можете вводить только цифры, номирующие пукт меню (1, 2, 3, 4) или exit.\n");
                    break;
            }
    }
    
    public void copyList(ArrayList<BudgetPurchase> list)
    {

        this.listOfPurchase.clear();
        for (BudgetPurchase elem : list)
        {
            this.listOfPurchase.add(elem);
        }
    }
}
