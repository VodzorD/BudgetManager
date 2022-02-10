import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import java.text.NumberFormat;

public class BudgetManager 
{
    public static void main(String[] args)
    {
        System.out.println("");
        System.out.println("Программа Бюджет Менеджер запущена.");
        System.out.println("");
        String inString = null;

        BudgetSalary salary = new BudgetSalary();
        var listOfPunchase = new LinkedList<BudgetPurchase>();


        while (!("exit".equalsIgnoreCase(inString)))
        {
            printMenu();

            BudgetPurchase purchase = new BudgetPurchase();

            Scanner in = new Scanner(System.in);
            inString = in.nextLine();
            executingMenuItem(inString, salary, purchase, listOfPunchase);
        }

        System.out.println("");
        System.out.println("Программа Бюджет Менеджер завершена.");
        System.out.println("");
        
        System.out.println("");
    }
    
    public static void printMenu()
    {
        System.out.println("Выберете один изи пунктов для работы: ");
        System.out.println("1. Добавить зарплату в табллицу.");
        System.out.println("2. Добавить покупку в таблицу.");
        System.out.println("3. Вывести на экран список покупок.");
        System.out.println("4. Вывести на экран текущий баланс.");
        System.out.println("5. Вывести отсортированный список покупок по параметру.");
        System.out.println("");
        System.out.println("Exit - Выход из программы.");
        System.out.println("");
    }

    public static void printSecondMenu()
    {
        System.out.println("Выберете один изи пунктов для работы: ");
        System.out.println("1. Отсортировать по возрастанию затрат на покупку.");
        System.out.println("2. Отсортировать по убыванию затрат на покупку.");
        System.out.println("3. Отсортировать по алфавиту.");
        System.out.println("");
        System.out.println("Exit - Выход из меню выбора сотировки.");
        System.out.println("");
    }

    public static void executingMenuItem(String inString, BudgetSalary salary, BudgetPurchase purchase, LinkedList<BudgetPurchase> listOfPunchares)
    {

        if (!("exit".equalsIgnoreCase(inString)))
            switch (inString)
            {
                case "1":
                    BudgetSalary.mainSalary(salary);
                    break;
                case "2":
                    BudgetPurchase.mainPurchase(purchase);
                    ListMaker(listOfPunchares, purchase);
                    break;
                case "3":
                    printList(listOfPunchares);
                    break;
                case "4":
                    printSumOfPunchaseAndSalary();
                    break;
                case "5":
                    String str = null;

                    printSecondMenu();
                    Scanner in = new Scanner(System.in);
                    inString = in.nextLine();
                    switch (inString)
                    {
                        case "1":
                            printSortListCheap(listOfPunchares);
                            break;
                        case "2":
                            printSortListExpensive(listOfPunchares);
                            break;
                        case "3":
                            printSortListName(listOfPunchares);
                            break;
                        default:
                            break;
                    }
            
                    break;
                default:
                    System.out.println("");
                    System.out.println("Повторите попытку ввода пункта меню. Был выбран не верный пункт.");
                    System.out.println("Вы можете вводить только цифры, номирующие пукт меню (1, 2, 3, 4) или exit.");
                    System.out.println("");
                    break;
            }
    }
    public static void printSumOfPunchaseAndSalary()
    {
        System.out.println("");
        System.out.println("Производится вывод баланса (ссуммы трат и зарплаты:)");
        System.out.println("");

        NumberFormat cur = NumberFormat.getCurrencyInstance();
        System.out.println(cur.format(-BudgetPurchase.returnPurchaseSum() + BudgetSalary.returnSumSalary()));
    
        System.out.println("");
    }
    public static void ListMaker(LinkedList<BudgetPurchase> List, BudgetPurchase elem)
    {
        List.add(elem);
    }
    public static void printList(LinkedList<BudgetPurchase> list)
    {
        int i = 1;
        System.out.println("");
        System.out.println("Производится вывод списка покупок:");
        System.out.println("");
        for (BudgetPurchase elem : list)
        {
            System.out.printf("%d)Что куплено - ", i++);
            elem.printPunchaseName();
            System.out.println("");
            System.out.printf("Сколько денег потрачено на данную покупку - ");
            elem.printPunchasePrise();
            System.out.println("");
        }
        if (BudgetPurchase.returnPurchaseSum() != 0)
        {
            System.out.println("");
            System.out.printf("Общая стоимость покупок:");
            NumberFormat cur = NumberFormat.getCurrencyInstance();
            System.out.println(cur.format(BudgetPurchase.returnPurchaseSum()));
            System.out.println("");
        }
        else
        {
            System.out.println("");
            System.out.printf("список покупок пуст!");
            System.out.println("");
        }
    }
    public static void printSortListCheap(LinkedList<BudgetPurchase> list)
    {
        Collections.sort(list, (a, b) -> a.returnPurchasePrise() < b.returnPurchasePrise() ? -1 : a.returnPurchasePrise() == b.returnPurchasePrise() ? 0 : 1);
        printList(list);
    }
    public static void printSortListExpensive(LinkedList<BudgetPurchase> list)
    {
        Collections.sort(list, (a, b) -> a.returnPurchasePrise() > b.returnPurchasePrise() ? -1 : a.returnPurchasePrise() == b.returnPurchasePrise() ? 0 : 1);
        printList(list);
    }
    public static void printSortListName(LinkedList<BudgetPurchase> list)
    {
        Collections.sort(list, (a, b) -> a.returnPurchaseName().compareToIgnoreCase(b.returnPurchaseName()));
        printList(list);
    }    
}
