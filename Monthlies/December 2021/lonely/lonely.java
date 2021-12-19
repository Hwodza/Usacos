import java.util.*;

public class lonely {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        String str = scan.nextLine();
        char[] arr = new char[n];
        int total = 0;
        for(int i=0; i<n; i++)
        {
            arr[i] = str.charAt(i);
        }
        
        for(int i=n-2; i>=3; i--)
        {
            boolean flag2 = true;
            int g = 0, h = 0;
            for(int j=0; j<n; j++)
            {
                boolean flag = false;
                for(int k=0; k<i; k++)
                {
                    if(arr[j+k] == 'G')
                    {
                        g++;
                    }else{
                        h++;
                    }
                    if(g > 1 && h > 1)
                    {
                        flag = true;
                        break;
                    }     
                    if(!flag)
                    {
                        total++;
                        flag2 = false;
                    }  
                }     
                if(flag2)
                {
                    break;
                }
            }
        }

        System.out.println(total);
        scan.close();
    }
    
}
