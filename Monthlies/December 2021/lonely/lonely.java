import java.util.*;

public class lonely {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String str = scan.nextLine();
        char[] arr = new char[n];
        int total = 0;
        for(int i=0; i<n; i++)
        {
            arr[i] = str.charAt(i);
        }
        for(int i=0; i<n-3; i++)
        {
            if(!(arr[i] == arr[i+1] && arr[i+2] == arr[i+1]))
            {
                total++;
            }
        }
        System.out.println(total);
        scan.close();
    }
    
}
