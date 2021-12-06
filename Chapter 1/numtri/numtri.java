/*
ID: hwodza1
TASK: numtri
LANG: JAVA
*/

//NAME                      : Henry Odza
//GROUP                     : APCS
//LAST MODIFIED             : March 19, 2021
//PROBLEM ID                : USACO numtri, finds highest sum of a path in a tree
//SOURCES/HELPERS/HELPED    : Mr.H
import java.io.*;

public class numtri
{
    public static void main(String[] args) throws IOException
    {
        //Creates input and output files
        BufferedReader in = new BufferedReader(new FileReader("numtri.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("numtri.out")));
        
        //Reads in input data
        int numRows = Integer.parseInt(in.readLine());
        int[][] triangle = new int[numRows+1][numRows+1];
        int[][] output = new int[numRows+1][numRows+1];
        for(int i=0; i<numRows; i++)
        {
            String[] str = in.readLine().split(" ");
            for(int j=0; j<str.length; j++)
            {
                triangle[i][j] = Integer.parseInt(str[j]);
                output[i][j] = -1;
            }
        }
        
        //Calls recursive function and prints result
        out.println(search(numRows, triangle, output, 0, 0));
        in.close();
        out.close();
    }

    public static int search(int numRows, int triangle[][], int output[][], int i, int j)
    {
        //Base Case
        if(output[i][j] != -1)
        {
            return output[i][j];
        }else if(i <= triangle.length){
            //Find the two neighboring points
            int num1 = search(numRows, triangle, output, i+1, j);
            int num2 = search(numRows, triangle, output, i+1, j+1);
            
            //Determines which one is bigger for sum
            if(num1 > num2)
            {
                output[i][j] = num1 + triangle[i][j];
            }else{
                output[i][j] = num2 + triangle[i][j];
            }
            
            //Returns sum
            return output[i][j];
        }else{
            return 0;
        }
    }
    
}
