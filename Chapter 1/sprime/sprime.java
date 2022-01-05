/*
ID: hwodza1
TASK: sprime
LANG: JAVA
*/

//NAME                      : Henry Odza
//GROUP                     : APCS
//LAST MODIFIED             : March 19, 2021
//PROBLEM ID                : USACO Superprime Rib, 
//Description               : Given a string of numbers determine 
//                          : if it is a superprime (each subset from the right is prime)
//SOURCES/HELPERS/HELPED    : Mr.H
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class sprime
{
    public static void main(String[] args) throws IOException
    {
        //Creates input and output files
        BufferedReader in = new BufferedReader(new FileReader("sprime.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sprime.out")));
        
        //Reads in data
        int n = Integer.parseInt(in.readLine());
        
        //Creates prime number arraylist
        ArrayList<Integer> nums = new ArrayList<Integer>();
        //Adds single digit prime numbers
        nums.add(2);
        nums.add(3);
        nums.add(5);
        nums.add(7);
        
        //Calls sprimes method and makes arraylist the output
        nums = sprimes(nums, 1, n);
        
        //Outputs all sprimes
        for(int i=0; i<nums.size(); i++)
        {
            out.println(nums.get(i));
        }
        in.close();
        out.close();
    }
    
    //Method for finding sprimes
    public static ArrayList<Integer> sprimes(ArrayList<Integer> dynamic, int n, int max)
    {
        //Creates new arraylist
        ArrayList<Integer> nums = new ArrayList<Integer>();
        
        //Goes through add sees if each new number keeps the sprimes sprimey
        for(int i=0; i<dynamic.size(); i++)
        {
            for(int j=1; j<10; j+=2)
            {
                int x = dynamic.get(i)*10 + j;
                if(isPrime(x))
                {
                    nums.add(x);
                }
            }
        }
        n++;
        
        //Checks to see if sprime length has been reached
        if(n == max)
        {
            return nums;
        }else{
            nums = sprimes(nums, n, max);
        }
        return nums;
    }
    
    //Method for checking if a number is prime
    public static boolean isPrime(int n)
    {
        if(n%2 == 0)
        {
            return false;
        }
        for(int i = 3; i<=Math.sqrt(n); i+=2)
        {
            if(n%i == 0)
            {
                return false;
            }
        }
        return true;
    }
}
