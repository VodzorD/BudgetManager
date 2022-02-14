import java.util.LinkedList;


public class BudgetManager 
{
    BudgetPrint prt;
    BudgetSalary salary;
    LinkedList<BudgetPurchase> listOfPurchase;
    BudgetPurchase purchase;
    String string;

    public BudgetManager()
    {
        prt = new BudgetPrint();
        salary = new BudgetSalary();
        listOfPurchase = new LinkedList<BudgetPurchase>();
        purchase = new BudgetPurchase();
        string = "";
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
                    BudgetPurchase.mainPurchase(purchase);
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
                default:
                    System.out.println("\nПовторите попытку ввода пункта меню. Был выбран не верный пункт.");
                    System.out.println("Вы можете вводить только цифры, номирующие пукт меню (1, 2, 3, 4) или exit.\n");
                    break;
            }
    }    
}
