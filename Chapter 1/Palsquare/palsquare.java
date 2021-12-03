/*
ID: hwodza1
TASK: palsquare
LANG: JAVA
*/

//NAME                      : Henry Odza
//GROUP                     : APCS
//LAST MODIFIED             : March 19, 2021
//PROBLEM ID                : USACO Palindromic Squares
//SOURCES/HELPERS/HELPED    : Mr.H
import java.io.*;
import java.util.*;

public class palsquare
{
    public static void main(String[] args) throws IOException
    {
        //Creates input and output files
        BufferedReader in = new BufferedReader(new FileReader("palsquare.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));

        //Reads in base
        int base = Integer.parseInt(in.readLine());

        //For loop that finds all palsquares
        for(int i=1; i<=300; i++)
        {
            //Changes the base of the squared number
            String str = Integer.toString(Integer.parseInt(Integer.toString(i*i), 10), base);
            
            //Determines if its a palindrome
            boolean idk = true;
            for(int j=0; j<str.length(); j++)
            {
                if(str.charAt(j) != str.charAt(str.length()-j-1))
                {
                    idk = false;
                }
            }
            
            //Prints if it is a palindrome
            if(idk)
            {
                out.println(Integer.toString(Integer.parseInt(Integer.toString(i), 10), base).toUpperCase() + " " + str.toUpperCase());
            }
        }

        //Closes files and exits program
        in.close();
        out.close();
        System.exit(0);
    }
}
