/*
ID: hwodza1
TASK: ariprog
LANG: JAVA
*/

//NAME                      : Henry Odza
//GROUP                     : AdvCS
//LAST MODIFIED             : June 5, 2021
//PROBLEM ID                : USACO Ariprog, Find a sequence of bisqaures, then figure out what 
//                          : sequences of a and b in a+nb equal one of the bisquares
//SOURCES/HELPERS/HELPED    : Mr.H
import java.io.*;
import java.util.ArrayList;


public class ariprog
{
    public static void main(String[] args) throws IOException
    {
        //Creates input and output files
        BufferedReader in = new BufferedReader(new FileReader("ariprog.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ariprog.out")));

        //Initialize variables
        int n = Integer.parseInt(in.readLine());
        int m = Integer.parseInt(in.readLine());
        int max = m*m*2;
        boolean[] bisquares = new boolean[max+1];

        //Finds all the bisquares in range M
        for(int i=0; i<=m; i++)
        {
            for(int j=0; j<=m; j++)
            {
                bisquares[i*i + j*j] = true;
            }
        }
        
        //Determines if a+nb is a bisquare
        ArrayList<Integer> stuff = new ArrayList<Integer>();
        for(int i=0; i<=max; i++)
        {
            if(!bisquares[i])
            {
                continue;
            }
            loop: for(int j=0; j<=(max-i)/(n-1); j++)
            {
                for(int k=1; k<=n-1; k++)
                {
                    if(!bisquares[i+j*k])
                    {
                        continue loop;
                    }
                }
                if(j != 0)
                {
                    stuff.add(j);
                    stuff.add(i);
                } 
            }
        }
        
        //Sorts the list for b
        for(int i=0; i<stuff.size(); i++)
        {
            for(int j=0; j<stuff.size()-2; j+=2)
            {
                if(stuff.get(j) > stuff.get(j+2))
                {
                    int temp = stuff.get(j);
                    stuff.set(j, stuff.get(j+2));
                    stuff.set(j+2, temp);
                    temp = stuff.get(j+1);
                    stuff.set(j+1, stuff.get(j+3));
                    stuff.set(j+3, temp);
                }
            }
        }

        //Sorts the list for a within each b
        for(int i=0; i<stuff.size(); i++)
        {
            for(int j=0; j<stuff.size()-2; j+=2)
            {
                if(stuff.get(j) == stuff.get(j+2))
                {
                    if(stuff.get(j+1) > stuff.get(j+3))
                    {
                        int temp = stuff.get(j+1);
                        stuff.set(j+1, stuff.get(j+3));
                        stuff.set(j+3, temp);
                    }
                }
            }
        }

        //Outputs the list
        if(stuff.size() == 0)
        {
            out.println("NONE");
        }else{
            for(int i=0; i<stuff.size(); i+=2)
            {
                out.println(stuff.get(i+1) + " " + stuff.get(i));
            }
        }
        
        in.close();
        out.close();
    }
}
