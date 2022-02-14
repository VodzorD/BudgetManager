import java.text.NumberFormat;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Comparator;
import java.util.Collections;

public final class BudgetPrint
{

    private Scanner in;
    private NumberFormat cur;


    public BudgetPrint()
    {
        in = new Scanner(System.in);
        cur = NumberFormat.getCurrencyInstance();
    }

    public String getIn()
    {
        return this.in.nextLine();
    }


    public static void printMenu()
    {
        System.out.println("Выберете один изи пунктов для работы: ");
        System.out.println("1. Добавить зарплату в табллицу.");
        System.out.println("2. Добавить покупку в таблицу.");
        System.out.println("3. Вывести на экран список покупок.");
        System.out.println("4. Вывести на экран текущий баланс.");
        System.out.println("5. Вывести отсортированный список покупок по параметру.\n");
        System.out.println("Exit - Выход из программы.\n");
    }
    
    
    public void printSortingMenu()
    {
        System.out.println("Выберете один изи пунктов для работы: ");
        System.out.println("1. Отсортировать по возрастанию затрат на покупку.");
        System.out.println("2. Отсортировать по убыванию затрат на покупку.");
        System.out.println("3. Отсортировать по алфавиту.\n");
        System.out.println("Exit - Выход из меню выбора сотировки.");
    }

    public void printSumOfPunchaseAndSalary(BudgetSalary salary)
    {
        System.out.println("\nПроизводится вывод баланса (ссуммы трат и зарплаты:)\n");
        System.out.println(this.cur.format(-BudgetPurchase.getSumPurchase() + salary.getSumSalary()));    
    }

    public void printList(LinkedList<BudgetPurchase> list)
    {
        int i = 1;
        System.out.println("Производится вывод списка покупок:\n");
        for (BudgetPurchase elem : list)
        {
            if (BudgetPurchase.getSumPurchase() == 0)
            {
                System.out.printf("список покупок пуст!\n");
                break;
            }
            System.out.printf("%d)Что куплено - ", i++);
            System.out.println(elem.getName());
            System.out.printf("Сколько денег потрачено на данную покупку - \n");
            System.out.println(elem.getPrice());

        }
        System.out.printf("Общая стоимость покупок:\n");
        System.out.println(this.cur.format(BudgetPurchase.getSumPurchase()));
    }

    public void printSortListCheap(LinkedList<BudgetPurchase> list)
    {
        Comparator.comparingDouble(BudgetPurchase::getPrice);
        this.printList(list);
    }
    public void printSortListExpensive(LinkedList<BudgetPurchase> list)
    {
        Comparator.comparingDouble(BudgetPurchase::getPrice).reversed();
        this.printList(list);
    }   
    public void printSortListName(LinkedList<BudgetPurchase> list)
    {
        Collections.sort(list, (a, b) -> a.getName().compareToIgnoreCase(b.getName()));
        this.printList(list);
    }
}
