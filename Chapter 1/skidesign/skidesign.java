/*
ID: hwodza1
TASK: skidesign
LANG: JAVA
*/

//NAME                      : Henry Odza
//GROUP                     : AdvCS
//LAST MODIFIED             : November 21, 2021
//PROBLEM ID                : USACO Ski Course Design, Helping Farmer John commit tax fraud.
//SOURCES/HELPERS/HELPED    : Mr.H
import java.io.*;


public class skidesign
{
    public static void main(String[] args) throws IOException
    {
        //Creates input and output files
        BufferedReader in = new BufferedReader(new FileReader("skidesign.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("skidesign.out")));
        int n = Integer.parseInt(in.readLine());
        int[] hills = new int[n];
        for(int i=0; i<n; i++)
        {
            hills[i] = Integer.parseInt(in.readLine());
        }

        //Sorts the array using bubble sort
        for(int i=0; i<n-1; i++)
        {
            for(int j=0; j<n-i-1; j++)
            {
                if(hills[j] > hills[j+1])
                {
                    int temp = hills[j];
                    hills[j] = hills[j+1];
                    hills[j+1] = temp;
                }
            }
        }
        
        //Checks to make sure that landscaping is needed
        if(hills[n-1] - hills[0] <= 17)
        {
            out.println(0);
        }else{
            //Goes through each possible landscaping case and finds cheapest one
            int total = 1000000000;
            for(int i=hills[0]; i<=hills[n - 1]; i++)
            {
                int round = 0;
                for(int j=0; j<n; j++)
                {
                    int temp = hills[j];
                    int count = 0;
                    if(temp > i)
                    {
                        while(temp - i > 17)
                        {
                            temp--;
                            count++;
                        }
                    }else{
                        while(i - temp > 0)
                        {
                            temp++;
                            count++;
                        }
                    }
                    
                    if(count != 0)
                    {
                        round += count*count;
                    }
                    
                }
                if(round < total)
                {
                    total = round;
                }
            }
            //Outputs cheapest option
            out.println(total);
        }
        //Closes program
        in.close();
        out.close();
    }
}