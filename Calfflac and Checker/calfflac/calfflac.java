/*
ID: hwodza1
TASK: calfflac
LANG: JAVA
*/
import java.io.*;
import java.util.*;
class Main {
	public static ArrayList<Character> let = new ArrayList<Character>();
	public static ArrayList<Character> let2 = new ArrayList<Character>();
	public static ArrayList<Integer> index = new ArrayList<Integer>();
	public static ArrayList<Boolean> equal = new ArrayList<Boolean>();
	public static ArrayList<Boolean> good = new ArrayList<Boolean>();
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("calfflac.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("calfflac.out")));
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
		int x = 0, y = 1;
		while(x < let.size()-2 && y < let.size()-1)
		{
			if(good.get(x) == true && good.get(y) == true)
			{
				if(let2.get(x) == let2.get(y))
				{
					equal.add(true);
				}else{
					equal.add(false);
				}
				x=y;
				y++;
			}else{
				y++;
			}
		}

		x = 0;
		for(int i=0; i<let2.size()-1; i++)
		{
			if(good.get(i) == true)
			{
				
			}
		}
		
		in.close();
		out.close();
		System.exit(0);
	}
}