import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class retriveCanditate {
    String[] namelist;
    String[] logolist;
    retriveCanditate(String[] namelist,String[] logolist)
    {
        this.logolist=logolist;
        this.namelist = namelist;
        File file = new File("Canditate.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            for (int i=0;i<5;i++)
            {
                String name = br.readLine();
                String logo = br.readLine();
                namelist[i]=name;
                logolist[i]=logo;
            }
            br.close();
        }
        catch (Exception e)
        {

        }

    }
}
