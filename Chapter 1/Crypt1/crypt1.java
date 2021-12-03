/*
ID: hwodza1
TASK: crypt1
LANG: JAVA
*/

//NAME                      : Henry Odza
//GROUP                     : APCS
//LAST MODIFIED             : May 11, 2021
//PROBLEM ID                : USACO Prime Cryptarithm, given a sequence of numbers find the products that fit 5 specific conditions.
//SOURCES/HELPERS/HELPED    : Mr.H
import java.io.*;


public class crypt1
{
    public static void main(String[] args) throws IOException
    {
        //Creates input and output files
        BufferedReader in = new BufferedReader(new FileReader("crypt1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("crypt1.out")));

        //Reads in and intializes data
        int n = Integer.parseInt(in.readLine());
        String[] str = in.readLine().split(" ");
        int[] nums = new int[n];
        int total = 0;
        for(int i=0; i<n; i++)
        {
            nums[i] = Integer.parseInt(str[i]);
        }

        //Tests each case
        for(int i=0; i<n; i++)
        { 
            for(int j=0; j<n; j++)
            { 
                for(int k=0; k<n; k++)
                {
                    //Creates the top row 
                    int temp = Integer.parseInt("" + nums[i] + nums[j] + nums[k]); 
                    for(int a=0; a<n; a++)
                    {
                        //Creates top product
                        String prod1 = Integer.toString(temp * nums[a]); 
                        for(int b=0; b<n; b++)
                        {
                            //Creates bottom product
                            String prod2 = Integer.toString(temp * nums[b]);

                            //Determines if each product is length 3
                            if(prod1.length() == 3 && prod2.length() == 3)
                            {

                                //Loop to determine if all numbers are valid
                                int counter = 0;
                                for(int c=0; c<3; c++)
                                {
                                    boolean test = false;
                                    boolean test2 = false;
                                    for(int d=0; d<n; d++)
                                    {
                                        if(Character.getNumericValue(prod1.charAt(c)) == nums[d])
                                        {
                                            test = true;
                                        }
                                        if(Character.getNumericValue(prod2.charAt(c)) == nums[d])
                                        {
                                            test2 = true;
                                        }
                                    }
                                    if(test && test2)
                                    {
                                        counter++;
                                    }
                                }
                                //Moves to next part if all numbers are valid
                                if(counter == 3)
                                {
                                    //Creates sum of two products and tests to make sure that all numbers are valid
                                    String sum = Integer.toString(Integer.parseInt(prod1) + (Integer.parseInt(prod2)*10));
                                    if(sum.length() == 4)
                                    {  
                                        int counter2 = 0;
                                        for(int d=0; d<4; d++)
                                        {
                                            boolean test3 = false;
                                            for(int e=0; e<n; e++)
                                            {
                                                if(Character.getNumericValue(sum.charAt(d)) == nums[e])
                                                {
                                                    //System.out.println(sum);
                                                    test3 = true;
                                                }
                                                
                                            }
                                            if(test3)
                                            {
                                                counter2++;
                                            }                    
                                        }
                                        if(counter2 == 4)
                                        {
                                            //System.out.println(prod1 + " + " + prod2 + " count: " + count);
                                            //count++;
                                            total++; 
                                        }
                                    }
                                }                         
                            }  
                        }
                    }
                }
            }
        }
        //Output and closes program
        out.println(total);
        in.close();
        out.close();
    }
}