import java.util.Scanner;

public class BudgetSalary
{
    private static double sumSalary;

    public static void mainSalary(BudgetSalary salary)
    {
        
        byte i = 0;
        Scanner in = new Scanner(System.in);
        String inSalary;

        while (i != 1)
        {
            System.out.println();
            System.out.println("Введите зарплату, которую хотите внести:");
            System.out.println();
            inSalary = in.nextLine();
            try
            {
                salary.sumSalary += Double.parseDouble(inSalary);
                i++;
            }
            catch (NumberFormatException e)
            {
                System.out.printf("\n%s\nНе верный формат ввода зарплаты.\nВ зарплате не можут встречаться буквы.\nПовторите попытку ввода или выйдите из программы ввода зарплаты при помощи exit:\n\n", e.getMessage());
            }
        }
        System.out.printf("Зарплата добавлена к бюджету!\n");
        System.out.println("");
    }

    public BudgetSalary()
    {
        sumSalary = 0;
    }
    public static double returnSumSalary()
    {
        return (sumSalary);
    }
}
