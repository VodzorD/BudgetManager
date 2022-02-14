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


    public static void mainPurchase(BudgetPurchase purchase)
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
                purchase.price = s;
                System.out.println("\nВведите наименование покупки:\n");            
                inPurchase = prt.getIn();
                purchase.purchaseName = inPurchase;
                i++;
            }
            catch (NumberFormatException e)
            {
                System.out.printf("\n%s\nНе верный формат ввода покупки.\nВ покупке не могут встречаться буквы.\nПовторите попытку ввода:\n\n", e.getMessage());
            }
        }   
        BudgetPurchase.sumPurchase += purchase.price;
        System.out.printf("Покупка вычтена из бюджета!\n\n");
    }
    
}
