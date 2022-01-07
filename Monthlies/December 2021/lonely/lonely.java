import java.util.Scanner;

public class lonely {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        String str = scan.nextLine();
        char[] arr = new char[n];
        boolean[] visited = new boolean[n];
        boolean[] falsePos = new boolean[n];
        boolean[] falsePos2 = new boolean[n];
        
        int total = 0;
        for(int i=0; i<n; i++)
        {
            arr[i] = str.charAt(i);
        }
        
        for(int i=3; i<=n-2; i++)
        {
            boolean flag2 = true;
            
            for(int j=0; j<=n-i; j++)
            {
                /*
                if(visited[j] == true)
                {
                    continue;
                }
                if(falsePos[j] == true)
                {
                    if(falsePos2[j] == true)
                    {
                        if(arr[j+i-1] != arr[j])
                        {
                            falsePos2[j] = false;
                            falsePos[j] = false;
                            visited[j] = true;
                        }
                        continue;
                    }
                    if(arr[j+i-1] != arr[j])
                    {
                        falsePos2[j] = true;
                        total++;
                    }
                    continue;
                }
                */
                
                int g = 0, h = 0;
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
                } 
                if(g > 2 && h == 0 ||  h > 2 && g == 0)
                {
                    flag = true;
                    falsePos[j] = true;
                }
                if(!flag)
                {
                    total++;
                    flag2 = false;
                }else if(falsePos[j] == false){
                    visited[j] = true;
                }     
                
            }
            if(flag2)
            {
                break;
            }
        }

        System.out.println(total);
        scan.close();
    }
    
}
