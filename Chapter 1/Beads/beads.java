/*
ID: hwodza1
TASK: beads
LANG: JAVA
*/

//NAME                      : Henry Odza
//GROUP                     : APCS
//LAST MODIFIED             : February 13, 2021
//PROBLEM ID                : USACO Broken Necklace
//SOURCES/HELPERS/HELPED    : Mr.H
import java.io.*;

public class beads 
{
    public static void main(String[] args) throws IOException
    {
        //Reads in files
        BufferedReader in = new BufferedReader(new FileReader("beads.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
        
        //Creates variables and reads in necesary data
        int numBlue = 0, blueNum = 0, numRed = 0, redNum = 0, forward = 0, backward = 0, total = 0;
        int n = Integer.parseInt(in.readLine());
        String input = in.readLine();
        input += input;
        char[] beads = new char[n*2];
        for(int i=0; i<n*2; i++)  
        {
            beads[i] = input.charAt(i);
        }

        //For loop that determines the output
        for(int i=0; i<n+1; i++)
        {
            //Intializes variables
            int x = i;
            numBlue = 0;
            blueNum = 0;
            forward = 0;
            backward = 0;
            numRed = 0;
            redNum = 0;

            //Finds the amount of blue beads
            while(beads[x] != 'r' && x < i+n-1)
            {
                numBlue++;
                x++;
            }
            int y = n+i-1;
            while(y > i + x && beads[y] != 'r')
            {
                blueNum++;
                y--;
            }
            
            //Finds the amount of red beads
            x = i;
            while(beads[x] != 'b' && x < i+n-1)
            {
                numRed++;
                x++;
            }
            y = n+i-1;
            while(y > i + x - n && beads[y] != 'b')
            {
                redNum++;
                y--;
            }

            //Determines which thing is bigger
            if(numBlue > numRed)
            {
                forward = numBlue;
            }else{
                forward = numRed;
            }
            if(blueNum > redNum)
            {
                backward = blueNum;
            }else{
                backward = redNum;
            }
            if(total < forward + backward)
            {
                total = forward + backward;
            }
        }
        if(total > n)
        {
            total = n;
        }
        
        //Outputs total
        out.println(total);
        in.close();
        out.close();
        System.exit(0);
    }
}
