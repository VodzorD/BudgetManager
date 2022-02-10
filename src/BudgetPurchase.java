import java.text.NumberFormat;
import java.util.Scanner;

public class BudgetPurchase
{
    static private double sumPurchase = 0;
    private double prise;
    private String purchaseName;

    public static void mainPurchase(BudgetPurchase purchase)
    {
        byte i = 0;
        Scanner in = new Scanner(System.in);

        String inPurchase;

        while (i != 1)
        {
            System.out.println();
            System.out.println("Введите сумму покупки, которую хотите внести:");
            System.out.println();
            inPurchase = in.nextLine();
            try
            {
                double s = Double.parseDouble(inPurchase);
                purchase.prise = s;

                System.out.println();
                System.out.println("Введите наименование покупки:");
                System.out.println();
            
                inPurchase = in.nextLine();
                
                purchase.purchaseName = inPurchase;

                i++;
            }
            catch (NumberFormatException e)
            {
                System.out.printf("\n%s\nНе верный формат ввода покупки.\nВ покупке не могут встречаться буквы.\nПовторите попытку ввода:\n\n", e.getMessage());
            }
        }   
        BudgetPurchase.sumPurchase += purchase.prise;
        System.out.printf("Покупка вычтена из бюджета!\n");
        System.out.println("");
    }

    public BudgetPurchase()
    {
        purchaseName = "Nan";
        prise = 0;
    }

    public static double returnPurchaseSum()
    {
        return (BudgetPurchase.sumPurchase);
    }

    public String returnPurchaseName()
    {
        return (this.purchaseName);
    }
    public double returnPurchasePrise()
    {
        return (this.prise);
    }
    
    public void printPunchasePrise()
    {
        var cur = NumberFormat.getCurrencyInstance();
        System.out.print(cur.format(this.prise));
    }
    
    public void printPunchaseName()
    {
        System.out.print(this.purchaseName);
    }
}
