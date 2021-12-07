/*
ID: hwodza1
TASK: sprime
LANG: JAVA
*/

//NAME                      : Henry Odza
//GROUP                     : APCS
//LAST MODIFIED             : March 19, 2021
//PROBLEM ID                : USACO Superprime Rib, given a string of numbers determine if it is a superprime (each subset from the right is prime)
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
        int n = Integer.parseInt(in.readLine());
        ArrayList<Integer> nums = new ArrayList<Integer>();
        nums.add(2);
        nums.add(3);
        nums.add(5);
        nums.add(7);
        nums = sprimes(nums, 1, n);
        for(int i=0; i<nums.size(); i++)
        {
            System.out.println((nums.get(i)));
            out.println(nums.get(i));
        }
        in.close();
        out.close();
    }
    public static ArrayList<Integer> sprimes(ArrayList<Integer> dynamic, int n, int max)
    {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        System.out.println(dynamic.size());
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
        if(n == max)
        {
            return nums;
        }else{
            nums = sprimes(nums, n, max);
        }
        return nums;
    }

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
