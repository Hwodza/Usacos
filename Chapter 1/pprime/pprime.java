/*
ID: hwodza1
TASK: pprime
LANG: JAVA
*/

//NAME                      : Henry Odza
//GROUP                     : APCS
//LAST MODIFIED             : March 19, 2021
//PROBLEM ID                : USACO Prime Palindromes
//SOURCES/HELPERS/HELPED    : Mr.H
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class pprime
{
    public static void main(String[] args) throws IOException
    {
        //Creates input and output files
        BufferedReader in = new BufferedReader(new FileReader("pprime.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("pprime.out")));
        String str[] = in.readLine().split(" ");
        int min = Integer.parseInt(str[0]), max = Integer.parseInt(str[1]);
        ArrayList<Integer> palindromes = new ArrayList<Integer>();
        for(int i=1; i<=9; i+=2)
        {
            int palindrome1 = i;
            int palindrome2 = i*10 + i;
            if(isPrime(palindrome1))
            {
                palindromes.add(palindrome1);
            }
            if(isPrime(palindrome2))
            {
                palindromes.add(palindrome2);
            }
            for(int j=0; j<=9; j++)
            {
                int palindrome3 = i*100 + j*10 + i;
                int palindrome4 = i*1000 + j*100 + j*10 + i;
                if(isPrime(palindrome3))
                {
                    palindromes.add(palindrome3);
                }
                if(isPrime(palindrome4))
                {
                    palindromes.add(palindrome4);
                }
                for(int k=0; k<=9; k++)
                {
                    int palindrome5 = i*10000 + j*1000 + k*100 + j*10 + i;
                    int palindrome6 = i*100000 + j*10000 + k*1000 + k*100 + j*10 + i;
                    if(isPrime(palindrome5))
                    {
                        palindromes.add(palindrome5);
                    }
                    if(isPrime(palindrome6))
                    {
                        palindromes.add(palindrome6);
                    }
                    for(int a=0; a<=9; a++)
                    {
                        int palindrome7 = i*1000000 + j*100000 + k*10000 + a*1000 + k*100 + j*10 + i;
                        int palindrome8 = i*10000000 + j*1000000 + k*100000 + a*10000 + a*1000 + k*100 + j*10 + i;
                        if(isPrime(palindrome7))
                        {
                            palindromes.add(palindrome7);
                        }
                        if(isPrime(palindrome8))
                        {
                            palindromes.add(palindrome8);
                        }
                    }
                }
            }
        }
        Collections.sort(palindromes);
        while(palindromes.get(0) < min)
        {
            palindromes.remove(0);
        }
        while(palindromes.get(palindromes.size()-1) > max)
        {
            palindromes.remove(palindromes.size()-1);
        }
        for(int i=0; i<palindromes.size(); i++)
        {
            out.println(palindromes.get(i));
        }
        /*
        if(min%2 == 0)
        {
            min++;
        }
        for(int i=min; i<=max; i+=2)
        {
            if(isPrime(i))
            {
                if(isPalin(i))
                {
                    out.println(i);
                }
            }
        }*/
        in.close();
        out.close();
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

    public static boolean isPalin(int n)
    {
        String str = Integer.toString(n);
        int x = str.length();
        if(x%2==0)
        {
            x /= 2;
            for(int i=0; i<x; i++)
            {
                if(str.charAt(x-1-i) != str.charAt(x+i))
                {
                    return false;
                }
            }
        }else{
            x /= 2;
            for(int i=0; i<x; i++)
            {
                if(str.charAt(x-1-i) != str.charAt(x+1+i))
                {
                    return false;
                }
            }
        }
        /*
        for(int i=0; i<x; i++)
        {
            if(str.charAt(x-1-i) != str.charAt(i))
            {
                return false;
            }
        }*/
        return true;
    }
}