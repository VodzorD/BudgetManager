public class BudgetSalary
{
    private double sumSalary;

    public void mainSalary()
    {
        
        byte i = 0;
        BudgetPrint prt = new BudgetPrint();
        String inSalary;

        while (i != 1)
        {
            System.out.println("\nВведите зарплату, которую хотите внести:\n");
            inSalary = prt.getIn();
            try
            {
                this.sumSalary += Double.parseDouble(inSalary);
                i++;
            }
            catch (NumberFormatException e)
            {
                System.out.printf("\n%s\nНе верный формат ввода зарплаты.\nВ зарплате не можут встречаться буквы.\nПовторите попытку ввода или выйдите из программы ввода зарплаты при помощи exit:\n\n", e.getMessage());
            }
        }
        System.out.printf("Зарплата добавлена к бюджету!\n\n");
    }

    public BudgetSalary()
    {
        sumSalary = 0;
    }
    public double getSumSalary()
    {
        return (this.sumSalary);
    }
}
