import java.util.Scanner;

public class walking {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        scan.nextLine();

        for(int i=0; i<t; i++)
        {
            int n = scan.nextInt(),k=scan.nextInt();
            scan.nextLine();
            char[][] arr = new char[n][n];
            for(int j=0; j<n; j++)
            {
                arr[j] = scan.nextLine().toCharArray();
            }
            System.out.println(findright(arr,0,1,0,n,0,k) + finddown(arr,0,0,1,n,0,k));
        }
    }       
    public static int findright(char[][] arr, int total, int x, int y, int n, int t, int k)
    {
        if(x == n-1 && y == n-1)
        {
            return 1;
        }
        if(x + 1 < n)
        {
            total += findright(arr, total, x+1, y, n, t, k);
            if(y + 1 < n)
            {
                if(t < k){
                    total += finddown(arr, total, x, y+1, n, t+1, k);
                }else{
                    return 0;
                }
            }
        }else if(y + 1 < n){
            if(t < k){
                total += finddown(arr, total, x, y+1, n, t+1, k);
                return total;
            }
        }
        return 0;
    }
    public static int finddown(char[][] arr, int total, int x, int y, int n, int t, int k)
    {
        if(x == n-1 && y == n-1)
        {
            return 1;
        }
        if(y + 1 < n)
        {
            total += finddown(arr, total, x, y+1, n, t, k);
            if(x + 1 < n)
            {
                if(t < k){
                    total += findright(arr, total, x+1, y, n, t+1, k);
                }
                return total;
            }
            return total;
        }else if(x + 1 < n){
            if(t < k){
                total += findright(arr, total, x+1, y, n, t+1, k);
                return total;
            }
        }
        return 0;
    }
    public static int find(char[][] arr, int total, int x, int y, int n, int t, int k, boolean direction){ //direction = true if going right, false if going down
        if(x == n-1 && y == n-1)
        {
            return 1;
        }
        if(arr[x][y] == 'H')
        {
            return 0;
        }
        if(x+1 < n)
        {
            if(!direction)
            {
                t++;
                if(t > k)
                {
                    return 0;
                }
            }
            //System.out.println("here");
            total += find(arr, total, x+1, y, n, t, k, true);
        }
        if(y+1 < n)
        {
            if(x == 0 && y == 0)
            {
                direction = false;
            }
            if(direction)
            {
                t++;
                if(t >= k)
                {
                    return 0;
                }
            }
            total += find(arr, total, x, y+1, n, t, k, false);
        }
        
        return total;
    }
}
