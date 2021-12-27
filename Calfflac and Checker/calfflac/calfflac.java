/*
ID: hwodza1
TASK: calfflac
LANG: JAVA
*/

//NAME                      : Henry Odza
//GROUP                     : AdvCS
//LAST MODIFIED             : December 8, 2021
//PROBLEM ID                : USACO calfflack finds palindromes in a very long series of strings
//SOURCES/HELPERS/HELPED    : Mr.H

import java.io.*;
import java.util.*;
public class calfflac {
	public static ArrayList<Character> let = new ArrayList<Character>();
	public static ArrayList<Character> let2 = new ArrayList<Character>();
	public static ArrayList<Integer> index = new ArrayList<Integer>();
	public static ArrayList<Boolean> good = new ArrayList<Boolean>();
	public static void main(String[] args) throws IOException {
		//Creates input and output files
		BufferedReader in = new BufferedReader(new FileReader("calfflac.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("calfflac.out")));
		
		//Reads in data and puts it into two arrays, original, and lowercase
		String str = "";
		while((str = in.readLine()) != null)
		{
			index.add(str.length());
			for(int i=0; i<str.length(); i++)
			{
				let.add(str.charAt(i));
				String temp = "" + str.charAt(i);
				temp = temp.toLowerCase();
				char temp1 = temp.charAt(0);
				let2.add(temp.charAt(0));
				if(temp1 >= 97 && temp1 <= 122)
				{
					good.add(true);
				}else{
					good.add(false);
				}
			}
		}

		

		
		in.close();
		out.close();
		System.exit(0);
	}
}