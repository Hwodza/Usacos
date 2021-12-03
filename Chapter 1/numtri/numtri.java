/*
ID: hwodza1
TASK: numtri
LANG: JAVA
*/

//NAME                      : Henry Odza
//GROUP                     : APCS
//LAST MODIFIED             : March 19, 2021
//PROBLEM ID                : USACO numtri
//SOURCES/HELPERS/HELPED    : Mr.H
import java.io.*;

public class numtri
{
    public static void main(String[] args) throws IOException
    {
        //Creates input and output files
        BufferedReader in = new BufferedReader(new FileReader("numtri.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("numtri.out")));

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
        
        out.println(search(numRows, triangle, output, 0, 0));
        in.close();
        out.close();
    }

    public static int search(int numRows, int triangle[][], int output[][], int i, int j)
    {
        if(output[i][j] != -1)
        {
            return output[i][j];
        }else if(i <= triangle.length){
            int num1 = search(numRows, triangle, output, i+1, j);
            int num2 = search(numRows, triangle, output, i+1, j+1);
            if(num1 > num2)
            {
                output[i][j] = num1 + triangle[i][j];
            }else{
                output[i][j] = num2 + triangle[i][j];
            }
            return output[i][j];
        }else{
            return 0;
        }
    }
    
}