/*
ID: hwodza1
TASK: transform
LANG: JAVA
*/

//NAME                      : Henry Odza
//GROUP                     : APCS
//LAST MODIFIED             : January 17, 2021
//PROBLEM ID                : USACO Miling cows
//SOURCES/HELPERS/HELPED    : Mr.H
import java.io.*;
public class transform
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader in = new BufferedReader(new FileReader("transform.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));

        int numRows = Integer.parseInt(in.readLine());
        char[][] grid = new char[numRows][numRows];
        char[][] changedGrid = new char[numRows][numRows];
        //out.println("hi");
        
        for(int i=0; i<numRows; i++)
        {
            String s = in.readLine();
            //char[] temp = s.split(" ");
            for(int j=0; j<numRows; j++)
            {
                //System.out.println(s.subchar(j,j+1));
                grid[i][j] = s.charAt(j);
            }
        }
        
        for(int i=0; i<numRows; i++)
        {
            String s = in.readLine();
            //char[] temp = s.split(" ");
            for(int j=0; j<numRows; j++)
            {
                //System.out.println(s.subchar(j,j+1));
                changedGrid[i][j] = s.charAt(j);
            }
        }
        int transform;
        if(equals(rotate(grid, numRows), changedGrid, numRows))
        {
            transform = 1;
        }else if(equals(rotate(rotate(grid, numRows), numRows), changedGrid, numRows)){
            transform = 2;
        }else if(equals(rotate(rotate(rotate(grid, numRows), numRows), numRows), changedGrid, numRows)){
            transform = 3; 
        }else if(equals(reflect(grid, numRows), changedGrid, numRows)){
            transform = 4;
        }else if(equals(rotate(reflect(grid, numRows), numRows), changedGrid, numRows)){
            transform = 5;
        }else if(equals(rotate(rotate(reflect(grid, numRows), numRows), numRows), changedGrid, numRows)){
            transform = 5; 
        }else if(equals(rotate(rotate(rotate(reflect(grid, numRows), numRows), numRows), numRows), changedGrid, numRows)){
            transform = 5;
        }else if(equals(grid, changedGrid, numRows)){
            transform = 6;
        }else{
            transform = 7;
        }
        print(grid, numRows);
        System.out.println();
        print(rotate(grid, numRows), numRows);
        out.println(transform);
        in.close();
        out.close();
        System.exit(0);
    }

    public static char[][] rotate(char[][] arr, int n)
    {
        char[][] arr2 = new char[n][n];
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                arr2[i][j] = arr[n-j-1][i];
            }
        }
        return arr2;
    }

    public static char[][] reflect(char[][] arr, int n)
    {
        char[][] arr2 = new char[n][n];
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                arr2[i][j] = arr[i][n-j-1]; 
            }
        }
        return arr2;
    }

    public static boolean equals(char[][] arr, char[][] arr2, int n)
    {
        boolean output = true;
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(arr[i][j] != arr2[i][j])
                {
                    output = false;
                }
            }
        }
        //print(arr, n);
        return output;
    }

    public static void print(char[][] arr, int n)
    {
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}