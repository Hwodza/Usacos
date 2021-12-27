/*
ID: hwodza1
TASK: dualpal
LANG: JAVA
*/

//NAME                      : Henry Odza
//GROUP                     : APCS
//LAST MODIFIED             : March 19, 2021
//PROBLEM ID                : USACO Dual Palindromes
//SOURCES/HELPERS/HELPED    : Mr.H
import java.io.*;

public class dualpal
{
    public static void main(String[] args) throws IOException
    {
        //Creates input and output files
        BufferedReader in = new BufferedReader(new FileReader("dualpal.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));
        String[] input = in.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);

        //Integers for iterating
        int count = s;
        int total = 0;

        //While loop that finds palindromes
        while(total < n)
        {
            
            int enough = 0;
            //Goes through each base
            for(int i=2; i<=10; i++)
            {
                //Changes the base of the squared number
                String str = Integer.toString(Integer.parseInt(Integer.toString(count), 10), i);

                //Determines if its a palindrome
                boolean isPal = true;
                for(int j=0; j<str.length(); j++)
                {
                    if(str.charAt(j) != str.charAt(str.length()-j-1))
                    {
                        isPal = false;
                    }
                }
                //Adds it to the enough counter if it is a palindrome
                if(isPal && count != 1 && count != 10)
                {
                    enough++;
                }
            }
            //Prints the number if it is a palindrome in 2+ bases
            if(enough >= 2)
            {
                out.println(count);
                total++;
            }
            count++;
        }

        //Closes program
        in.close();
        out.close();
        System.exit(0);
    }
}