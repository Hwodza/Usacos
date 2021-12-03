/*
ID: hwodza1
TASK: combo
LANG: JAVA
*/

//NAME                      : Henry Odza
//GROUP                     : AdvCS
//LAST MODIFIED             : November 11, 2021
//PROBLEM ID                : USACO Combination Lock, given a combination lock find all possible "mistake" pairing that would unlock it
//SOURCES/HELPERS/HELPED    : Mr.H
import java.io.*;
import java.util.*;
public class combo
{
    public static void main(String[] args) throws IOException
    {
        //Creates input and output files
        BufferedReader in = new BufferedReader(new FileReader("combo.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("combo.out")));

        //Reads in data
        int n = Integer.parseInt(in.readLine());
        String[] str1 = in.readLine().split(" ");
        String[] str2 = in.readLine().split(" ");
        int[] combo1 = new int[3];
        int[] combo2 = new int[3];
        for(int i=0; i<3; i++)
        {
            combo1[i] = Integer.parseInt(str1[i]);
            combo2[i] = Integer.parseInt(str2[i]);
        }

        //Checks for case of n == 1
        if(n == 1)
        {
            out.println(1);
        }else{
            //Creates Arraylist to store all combos
            ArrayList<String> arr = new ArrayList<String>();

            //Loop that controls first dial
            for(int i=-2; i<=2;i++)
            {
                //Puts the right number for the dial
                String temp1 = "";
                String temp2 = "";
                if(i == 0)
                {
                    temp1 += "" + combo1[0];
                    temp2 += "" + combo2[0];
                }else{
                    if(combo1[0]+i <= 0)
                    {
                        if(combo1[0]+i == -1)
                        {
                            temp1 += "" + (n-1);
                        }else{
                            temp1 += "" + n;
                        }
                    }else if(combo1[0] + i > n){
                        if(combo1[0] + i == n + 1)
                        {
                            temp1 += "1";
                        }else{
                            temp1 += "2";
                        }
                    }else{
                        temp1 += "" + (combo1[0]+i);
                    }

                    if(combo2[0]+i <= 0)
                    {
                        if(combo2[0]+i == -1)
                        {
                            temp2 += "" + (n-1);
                        }else{
                            temp2 += "" + n;
                        }
                    }else if(combo2[0] + i > n){
                        if(combo2[0]+i == n + 1)
                        {
                            temp2 += "1";
                        }else{
                            temp2 += "2";
                        }
                    }else{
                        temp2 += "" + (combo2[0]+i);
                    }
                }

                //Loop that controls second dial
                for(int j=-2; j<=2; j++)
                {
                    //Puts the right number for the dial
                    String temp3 = "";
                    String temp4 = "";
                    if(j == 0)
                    {
                        temp3 += "" + combo1[1];
                        temp4 += "" + combo2[1];
                    }else{
                        if(combo1[1]+j <= 0)
                        {
                            if(combo1[1]+j == -1)
                            {
                                temp3 += "" + (n-1);
                            }else{
                                temp3 += "" + n;
                            }
                        }else if(combo1[1] + j > n){
                            if(combo1[1]+j == n + 1)
                            {
                                temp3 += "1";
                            }else{
                                temp3 += "2";
                            }
                        }else{
                            temp3 += "" + (combo1[1]+j);
                        }

                        if(combo2[1]+j <= 0)
                        {
                            if(combo2[1]+j == -1)
                            {
                                temp4 += "" + (n-1);
                            }else{
                                temp4 += "" + n;
                            }
                        }else if(combo2[1] + j > n){
                            if(combo2[1]+j == n + 1)
                            {
                                temp4 += "1";
                            }else{
                                temp4 += "2";
                            }
                        }else{
                            temp4 += "" + (combo2[1]+j);
                        }
                    }

                    //Loop that controls third dial
                    for(int k=-2; k<=2; k++)
                    {
                        //Puts the right number for the dial
                        String temp5 = "";
                        String temp6 = "";
                        if(k == 0)
                        {
                            temp5 += "" + combo1[2];
                            temp6 += "" + combo2[2];
                        }else{
                            if(combo1[2]+k <= 0)
                            {
                                if(combo1[2]+k == -1)
                                {
                                    temp5 += "" + (n-1);
                                }else{
                                    temp5 += "" + n;
                                }
                            }else if(combo1[2] + k > n){
                                if(combo1[2]+k == n + 1)
                                {
                                    temp5 += "1";
                                }else{
                                    temp5 += "2";
                                }
                            }else{
                                temp5 += "" + (combo1[2]+k);
                            }

                            if(combo2[2]+k <= 0)
                            {
                                if(combo2[2]+k == -1)
                                {
                                    temp6 += "" + (n-1);
                                }else{
                                    temp6 += "" + n;
                                }
                            }else if(combo2[2] + k > n){
                                if(combo2[2]+k == n + 1)
                                {
                                    temp6 += "1";
                                }else{
                                    temp6 += "2";
                                }
                            }else{
                                temp6 += "" + (combo2[2]+k);
                            }
                            
                        }

                        //Adds the two possible combos to arraylist
                        arr.add((temp1 + " " + temp3 + " " + temp5));
                        arr.add((temp2 + " " + temp4 + " " + temp6));
                    }
                }
            }
            
            //Determines and removes all duplicates
            for(int i=0; i<arr.size(); i++)
            {
                for(int j=0; j<arr.size(); j++)
                {
                    if(i != j)
                    {
                        if(arr.get(i).equals(arr.get(j)))
                        {
                            arr.remove(j);
                            j--;
                        }
                    }
                }
            }
            //Outputs answer
            out.println(arr.size());
        }

        //Closes Program
        in.close();
        out.close();
        
    }
}