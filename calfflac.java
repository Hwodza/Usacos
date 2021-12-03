/*
ID: hwodza1
TASK: calfflac
LANG: JAVA
*/
import java.io.*;
import java.util.*;
class Main {
	public static ArrayList<Character> let = new ArrayList<Character>();
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("calfflac.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("calfflac.out")));
		String str = "";
		while((str = in.readLine()) != null)
		{
			for(int i=0; i<str.length(); i++)
			{
				let.add(str.charAt(i));
			}
		}

		
		in.close();
		out.close();
		System.exit(0);
	}
}
