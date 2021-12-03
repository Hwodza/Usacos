/*
ID: hwodza1
TASK: milk2
LANG: JAVA
*/

//NAME                      : Henry Odza
//GROUP                     : APCS
//LAST MODIFIED             : March 11, 2021
//PROBLEM ID                : USACO Miling cows
//SOURCES/HELPERS/HELPED    : Mr.H
import java.io.*;
import java.util.*;

public class milk2
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader in = new BufferedReader(new FileReader("milk2.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));

        //Reads in n and initialze arraylists
        int n = Integer.parseInt(in.readLine());
        ArrayList<Integer> start = new ArrayList<Integer>();
        ArrayList<Integer> end = new ArrayList<Integer>();

        //Reads in data for array lists
        for(int i=0; i<n; i++)
        {
            String[] str = in.readLine().split(" ");
            start.add(Integer.parseInt(str[0]));
            end.add(Integer.parseInt(str[1]));
        }

        //Creates working segments
        for(int i=0; i <= n + 1; i++)
        {
            loop: for(int j=0; j < start.size(); j++)
            {
                for(int k=0; k < start.size(); k++)
                {
                    //Condition so that the same thing is not compared
                    if(j != k)
                    {
                        //Determines which start time is later
                        if(start.get(j) > start.get(k))
                        {
                            //Determines if the times overlap
                            if(start.get(j) <= end.get(k))
                            {
                                //Determines which end time is later
                                if(end.get(j) >= end.get(k))
                                {
                                    end.set(k, end.get(j));
                                }
                                //Removes times within larger total worktime
                                start.remove(j);
                                end.remove(j);
                                break loop;
                            }
                            
                        }else{
                            //Determines if they part of the same block
                            if(end.get(j) >= start.get(k))
                            {
                                //Determines which end time is later
                                if(end.get(j) <= end.get(k))
                                {
                                    end.set(j, end.get(k));
                                }
                                //Removes unwanted times
                                start.remove(k);
                                end.remove(k);
                                break loop;
                            }
                        }
                    }
                }
            }
        }

        //Determines the longest work and rest time from data
        int workTotal = 0, restTotal = 0;
        for(int i=0; i<start.size(); i++)
        {
            int work = end.get(i) - start.get(i);
            int rest = 0;
            if(i + 1 < start.size())
            {
                rest = start.get(i+1) - end.get(i);
            }
            if(work > workTotal)
            {
                workTotal = work;
            }
            if(rest > restTotal)
            {
                restTotal = rest;
            }
        }
        
        //outputs data
        out.println(workTotal + " " + restTotal);
        in.close();
        out.close();
        System.exit(0);
    }
}