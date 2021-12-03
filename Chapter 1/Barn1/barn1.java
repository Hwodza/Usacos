/*
ID: hwodza1
TASK: barn1
LANG: JAVA
*/

//NAME                      : Henry Odza
//GROUP                     : APCS
//LAST MODIFIED             : April 29, 2021
//PROBLEM ID                : USACO Barn Repair, Finds the fewest amount of stalls needed to be covered with a certain amount of boards
//SOURCES/HELPERS/HELPED    : Mr.H
import java.io.*;
import java.util.ArrayList;

public class barn1
{
    public static void main(String[] args) throws IOException
    {
        //Creates input and output files
        BufferedReader in = new BufferedReader(new FileReader("barn1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));

        //Initializes and reads in data
        String[] str = in.readLine().split(" ");
        int m = Integer.parseInt(str[0]);
        int s = Integer.parseInt(str[1]);
        int c = Integer.parseInt(str[2]);
        ArrayList<Integer> stalls = new ArrayList<Integer>();
        int[] occupied = new int[c];

        //Reads in all occupied Stalls
        for(int i=0; i<c; i++)
        {
            occupied[i] = Integer.parseInt(in.readLine().split(" ")[0]);
        }

        //Bubble sort to sort occupied Stalls
        for(int i=0; i<c-1; i++)
        {
            for(int j=0; j<c-i-1; j++)
            {
                if(occupied[j] > occupied[j+1])
                {
                    int temp = occupied[j];
                    occupied[j] = occupied[j+1];
                    occupied[j+1] = temp;
                }
            }
        }
        
        //For loop that makes ArrayList for all stalls
        int count = 0;
        for(int i=0; i<=s; i++)
        {
            if(count < c)
            {
                if(occupied[count] == i)
                {
                    stalls.add(1);
                    count++;
                }else{
                    stalls.add(0);
                }
            }else{
                stalls.add(0);
            }
            
        }
        
        //Removes empty stalls at the two ends
        while(stalls.get(0) == 0)
        {
            stalls.remove(0);
            s--;
        }
        while(stalls.get(stalls.size()-1) == 0)
        {
            stalls.remove(stalls.size()-1);
            s--;
        }
        
        //Finds how many occupied on right end
        int counter = 0;
        int counter2 = 0;
        while(stalls.get(stalls.size()-1-counter) == 1)
        {
            counter++;
            counter2++;
        }
        
        //Find the 3 largest gaps
        int[] largest = new int[m-1];
        for(int i=0; i<m-1; i++)
        {
            largest[i] = 0; 
        }
        for(int i=0; i<stalls.size()-counter2; i++)
        {
            int tempZero = 0;
            int x = i;
            while(stalls.get(x) == 1)
            {
                x++;
            }
            while(stalls.get(x) == 0)
            {
                tempZero++;
                x++;
            }
            i=x;
            
            //Re-orders the order of largest gaps
            loop:for(int j=0; j<m-1; j++)
            {
                if(tempZero > largest[j])
                {
                    for(int k=m-2; k>j; k--)
                    {
                        largest[k] = largest[k-1];
                    }
                    largest[j] = tempZero;
                    j=m;
                    break loop;
                }
            }
        }
        
        //Subracts the m-1 largest gaps from total stalls
        for(int i=0; i<m-1; i++)
        {
            s -= largest[i];
        }

        //Adds one to s to counteract starting at 0 instead of 1
        s += 1;
        int x =2;
        double y=x;
        //Outputs s and closes program
        out.println(s);
        in.close();
        out.close();
    }
}