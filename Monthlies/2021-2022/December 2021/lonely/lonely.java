//NAME                      : Henry Odza
//GROUP                     : AdvCS
//LAST MODIFIED             : December 18, 2021
//PROBLEM ID                : USACO Lonely Photos
//SOURCES/HELPERS/HELPED    : Mr.H
import java.util.Scanner;

public class lonely {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        String str = scan.nextLine();
        int count = 0;
        for(int i=0; i<str.length(); i++)
        {
            int g=0, h=0;
            for(int j=i; j<str.length(); j++)
            {
                if(str.charAt(j) == 'G')
                {
                    g++;
                }else{
                    h++;
                }
                if(g+h >=3 && (g==1 || h==1))
                {
                    count++;
                }
            }
        }
        System.out.println(count);
        scan.close();
    }
    
}
