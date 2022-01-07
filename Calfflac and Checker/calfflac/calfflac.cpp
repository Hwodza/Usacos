/*
ID: hwodza1
TASK: calfflac
LANG: C++                 
*/

#include <iostream>
#include <fstream>
#include <string>
#include <stdio.h>
using namespace std;

bool check(char a)
{   
    int b = int(a);
    if(b<96 || b>122)
        return false;
    else
        return true;
}

int main() {
    ofstream fout ("calfflac.out");
    ifstream fin ("calfflac.in");
    string original, a, out;
    while(getline(fin, a))
    {
        original += a + "\n";
        for(int i=0; i<a.length(); i++)
        {
            char c = a[i];
            a[i] = tolower(c);
        }
        out += a + "\n";
    }
    int index, count = 0, countx, county;
    bool flag = false;
    for(int i=0; a.length(); i++)
    {
        if(flag)
        {
            break;
        }
        if(count == a.length()-i)
        {
            break;
        }
        for(int k=0; k<=i; k++)
        {
            
            int start = (a.length()-i)/2 + k;
            if(k == 15)
            {
                cout << original[start] << i << endl;
            }
            int x=0, y=0, temp1=0, temp2=0, j=1;
            while(j<start)
            {
                bool check1 = check(a[start-j-x]);
                bool check2 = check(a[start+j+y]);
                if(check1 && check2)
                {
                    if(a[start-j-x] == a[start+j+y])
                    {
                        temp1++;
                        x++;
                        y++;
                        j++;
                        continue;
                    }
                    break;
                }
                if(!check1)
                {
                    x++;
                }
                if(!check2)
                {
                    y++;
                }
            }
            j=0;
            int x2=0,y2=0;
            while(j<start)
            {
                bool check1 = check(a[start-j-x2-1]);
                bool check2 = check(a[start+j+y2]);
                if(check1 && check2)
                {
                    if(a[start-j-x2-1] == a[start+j+y2])
                    {
                        temp2++;
                        x2++;
                        y2++;
                        j++;
                        continue;
                    }
                    break;
                }
                if(!check1)
                {
                    x2++;
                }
                if(!check2)
                {
                    y2++;
                }
            }
            bool check3 = false;
            if(temp1>temp2>count)
            {
                count = temp1;
                index = start;
                countx = x;
                county = y;
                check3 = true;
                cout << "here" << i << endl;
            }
            if(temp2>=temp1>count)
            {
                count = temp2;
                index = start;
                countx = x2;
                county = y2;
                check3 = true;
                cout << "here2" << i << endl;
            }
            if(check3 && count == a.length()-i)
            {
                break;
            }
        }
    }
    int counter=index-countx+1;
    cout << index << " " << count << " " << counter << " " << countx << " " << county << endl;
    while(counter < index+county)
    {
        cout << original[counter];
        fout << original[counter];
        counter++;
    }
    cout << endl << endl << original << endl;
    return 0;
}