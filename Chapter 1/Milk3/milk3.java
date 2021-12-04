/*
ID: hwodza1
TASK: milk3
LANG: JAVA
*/

//NAME                      : Henry Odza
//GROUP                     : AdvCS
//LAST MODIFIED             : November 22, 2021
//PROBLEM ID                : USACO Mother's Milk, determines what amounts of milk he can leave in
//                            bucket C when he begins with three buckets, pours milk among the buckets for a while, and then notes that bucket A is empty.
//SOURCES/HELPERS/HELPED    : Mr.H
import java.io.*;
import java.util.ArrayList;


public class milk3
{
    static int a,b,c;
    static boolean[][][] possible = new boolean[21][21][21];
    static boolean[][][] visited = new boolean[21][21][21];
    public static void main(String[] args) throws IOException
    {
        //Creates input and output files
        BufferedReader in = new BufferedReader(new FileReader("milk3.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk3.out")));
        String[] str = in.readLine().split(" ");
        int A = Integer.parseInt(str[0]);
        int B = Integer.parseInt(str[1]);
        int C = Integer.parseInt(str[2]);
        
        //Sets up the constants
        a=A;
        b=B;
        c=C;

        //Starts the recursive function
        find(0,0,c);

        //Finds all possible values for C
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i=0; i<=c; i++)
        {
            for(int j=0; j<=b; j++)
            {
                for(int k=0; k<=a; k++)
                {
                    if(possible[0][j][i])
                    {
                        arr.add(i);
                    }
                }
            }
        }
        
        //Removes any duplicates of C
        for(int i=1; i<arr.size(); i++)
        {
            if(arr.get(i) == arr.get(i-1))
            {
                arr.remove(i);
                i--;
            }
        }

        //Prints the answer
        out.print(arr.get(0));
        for(int i=1; i<arr.size(); i++)
        {
            out.print(" " + arr.get(i));
        }
        out.println();
        out.close();
    }

    public static void find(int A, int B, int C)
    {
        
        //Returns if combo has already been visited
        if(visited[A][B][C] || possible[A][B][C])
        {
            return;
        }

        //Sets combo as visited
        visited[A][B][C] = true;
        if(A == 0)
        {
            
            possible[A][B][C] = true;
        }

        //Continues recursion
        int tempA = A;
        int tempB = B;
        int tempC = C;

        //Bucket C to B
        if(b >= C+B)
        {
            tempB = C+B;
            tempC = 0;
        }else{
            tempB = b;
            tempC = C - (b-B);
            if(B == b)
            {
                tempC = C;
            }
        }
        find(tempA, tempB, tempC);

        //Bucket C to A
        tempB = B;
        if(a >= C+A)
        {
            tempA = C+A;
            tempC = 0;
        }else{
            tempA = a;
            tempC = C - (a-A);
            if(a == A)
            {
                tempC = C;
            }
        }
        find(tempA, tempB, tempC);

        //Bucket B to C
        tempA = A;
        if(c >= B+C)
        {
            tempC = B+C;
            tempB = 0;
        }else{
            tempC = c;
            tempB = B - (c-C);
            if(c == C)
            {
                tempB = B;
            }
        }
        find(tempA, tempB, tempC);

        //Bucket B to A
        tempC = C;
        if(a >= B+A)
        {
            tempA = B+A;
            tempB = 0;
        }else{
            tempA = a;
            tempB = B - (a-A);
            if(a == A)
            {
                tempB = B;
            }
        }
        find(tempA, tempB, tempC);

        
        //Bucket A to C
        tempB = B;
        if(c >= A+C)
        {
            tempC = A+C;
            tempA = 0;
        }else{
            tempC = c;
            tempA = A - (c-C);
            if(c == C)
            {
                tempA = A;
            }
        }
        find(tempA, tempB, tempC);

        //Bucket A to B
        tempC = C;
        if(b >= A+B)
        {
            tempB = A+B;
            tempA = 0;
        }else{
            tempB = b;
            tempA = A - (b-B);
            if(b == B)
            {
                tempA = A;
            }
        }
        find(tempA, tempB, tempC);
    }
        
}

