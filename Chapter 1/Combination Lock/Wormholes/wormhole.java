/*
ID: hwodza1
TASK: wormhole
LANG: JAVA
*/

//NAME                      : Henry Odza
//GROUP                     : AdvCS
//LAST MODIFIED             : November 21, 2021
//PROBLEM ID                : USACO Ski Course Design, Helping Farmer John commit tax fraud.
//SOURCES/HELPERS/HELPED    : Mr.H
import java.io.*;


public class wormhole
{
    static int max = 12, n;
    static int[] x = new int[max+1];
    static int[] y = new int[max+1];
    static int[] partner = new int[max+1];
    static int[] next = {0,0,0,0,0,0,0,0,0,0,0,0,0};
    public static void main(String[] args) throws IOException
    {
        //Creates input and output files
        BufferedReader in = new BufferedReader(new FileReader("wormhole.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("wormhole.out")));

        //Reads in data
        n = Integer.parseInt(in.readLine());
        for(int i=1; i<=n; i++)
        {
            String[] str = in.readLine().split(" ");
            x[i] = Integer.parseInt(str[0]);
            y[i] = Integer.parseInt(str[1]);
        }
        //Sets next on right
        for(int i=1; i<=n; i++)
        {
            for(int j=1; j<=n; j++)
            {   
                //Determines j right of i
                if(x[j] > x[i] && y[i] == y[j])
                {
                    if(next[i] == 0 || x[j] - x[i] < x[next[i]]-x[i])
                    {
                        next[i] = j; 
                    }
                }
            }
        }
        out.println(solve());
        in.close();
        out.close();
    }

    public static boolean cycle()
    {
        for(int start=1; start<=n; start++)
        {
            //Does a cycle exist starting from start
            int pos = start;
            for(int count=0; count<n; count++)
            {
                pos = next[partner[pos]];
            }
            if(pos != 0)
            {
                return true;
            }
        }
        return false;
    }

    //Count all solutions
    public static int solve()
    {
        //Finds first unpaired wormhole
        int total = 0;
        int i;
        for(i=1; i<=n; i++)
        {
            if(partner[i] == 0)
            {
                break;
            }
        }

        //Everyone paired?
        if(i > n)
        {
            if(cycle())
            {
                return 1;
            }else{
                return 0;
            }
        }

        //Try pairing i with all possible other wormholes j
        for(int j=i+1; j<=n; j++)
        {
            if(partner[j] == 0)
            {
                //Try pairing i & j, let recursion continue to generate the rest of the solution
                partner[i] = j;
                partner[j] = i;
                total += solve();
                partner[i] = 0;
                partner[j] = 0;  
            }
        }
        return total;
    }
}