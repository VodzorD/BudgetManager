import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.nio.file.*;
import java.io.*;

public class BudgetFileParse
{
    private InputStream in;
    private Path filePath;
    private ArrayList<String> list;


    public BudgetFileParse()
    {
        filePath = getFilePath();
        list = new ArrayList<String>();
        try 
        {

            in = Files.newInputStream(filePath);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line = null;
            while ((line = reader.readLine()) != null)
            {
                list.add(line);
            }
        }
        catch (IOException x)
        {
            System.out.println(x);
        }
        finally
        {
            try
            {
                if (in != null)
                    in.close();
            }
            catch (IOException x)
            {
                System.out.println(x);
            }
        }
    }

    public ArrayList<String> getFileLines()
    {
        return this.list;
    }

    public Path getFilePath()
    {
        return Paths.get("./BudgetFile.txt");
    }

    public ArrayList<BudgetPurchase> parseFileToPurchase()
    {
        var newList = new ArrayList<BudgetPurchase>();

        for (String str : this.list)
        {
            String[] splitStr = str.split(" ");
            BudgetPurchase purchase = new BudgetPurchase(splitStr[0], Double.parseDouble(splitStr[1]));
            newList.add(purchase);
        }
        return newList;
    }

}
