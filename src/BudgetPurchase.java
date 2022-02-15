

public class BudgetPurchase
{
    static private double sumPurchase = 0;
    private double price;
    private String purchaseName;


    public BudgetPurchase()
    {
        purchaseName = "Non";
        price = 0;
    }

    public BudgetPurchase(String name, double price)
    {
        this.purchaseName = name;
        this.price = price;
    }

    public Double getPrice()
    {
        return this.price;
    }
    public void setPrice(double value)
    {
        this.price = value;
    }
    
    public String getName()
    {
        return this.purchaseName;
    }
    public void setName(String value)
    {
        this.purchaseName = value;
    }

    public static double getSumPurchase()
    {
        return BudgetPurchase.sumPurchase;
    }


    public void mainPurchase()
    {
        byte i = 0;
        BudgetPrint prt = new BudgetPrint();

        String inPurchase;

        while (i != 1)
        {
            System.out.println("\nВведите сумму покупки, которую хотите внести:\n");
            inPurchase = prt.getIn();
            try
            {
                double s = Double.parseDouble(inPurchase);
                this.price = s;
                System.out.println("\nВведите наименование покупки:\n");            
                inPurchase = prt.getIn();
                this.purchaseName = inPurchase;
                i++;
            }
            catch (NumberFormatException e)
            {
                System.out.printf("\n%s\nНе верный формат ввода покупки.\nВ покупке не могут встречаться буквы.\nПовторите попытку ввода:\n\n", e.getMessage());
            }
        }   
        BudgetPurchase.sumPurchase += this.price;
        System.out.printf("Покупка вычтена из бюджета!\n\n");
    }    
}
