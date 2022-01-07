import java.util.Scanner;
import java.util.ArrayList;

public class air {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        ArrayList<Integer> current = new ArrayList<Integer>();
        ArrayList<Integer> prefered = new ArrayList<Integer>();
        int total = 0;
        for(int i=0; i<n; i++)
        {
            prefered.add(scan.nextInt());
        }
        scan.nextLine();
        for(int i=0; i<n; i++)
        {
            current.add(scan.nextInt());
        }
        int x = 0;
        int y = 0;
        loop: while(prefered.size() > 0)
        {
            if(prefered.get(0) == current.get(0))
            {
                prefered.remove(0);
                current.remove(0);
                continue;
            }
            if(prefered.get(prefered.size()-1) == current.get(current.size()-1))
            {
                prefered.remove(prefered.size()-1);
                current.remove(current.size()-1);
                continue;
            }
            if(current.get(0)+y > prefered.get(0))
            {
                x = current.get(0)+y - prefered.get(0);
                total += x;
                //System.out.println("Here2 " + x + " " + total);
                current.remove(0);
                prefered.remove(0);
                if(prefered.size() == 0)
                {
                    //System.out.println("Hello");
                    break;
                }
                while(current.get(current.size()-1)+y - x == prefered.get(prefered.size()-1))
                {
                    prefered.remove(prefered.size()-1);
                    current.remove(current.size()-1);
                    if(prefered.size() == 0)
                    {
                        break loop;
                    }
                }
            }
            if(current.get(0)-x < prefered.get(0))
            {
                y = prefered.get(0) - current.get(0) - x;
                total += y;
                //System.out.println("Here: " + y + " " + total + " ");
                current.remove(0);
                prefered.remove(0);
                if(prefered.size() == 0)
                {
                    break;
                }
                while(current.get(current.size()-1) + y-x == prefered.get(prefered.size()-1))
                {
                    prefered.remove(prefered.size()-1);
                    current.remove(current.size()-1);
                    if(prefered.size() == 0)
                    {
                        break loop;
                    }
                }
                
            }
        }
        System.out.println(total);
        scan.close();
    }
}
