import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class maptest {
    public static void main(String[] args) {
        Map<String,Integer> map=new HashMap<String,Integer>();
        map.put("laptop",0);
        map.put("mouse",0);
        map.put("keyboard",0);
        map.put("router",0);
        map.put("sattalite",0);
        map.put("headphone",0);

        Scanner input = new Scanner(System.in);
        while (true)
        {
            String ss = input.nextLine();
            System.out.println(map.get(ss));
        }
    }
}
