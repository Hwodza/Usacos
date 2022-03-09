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
    //I/O
    ofstream fout ("calfflac.out");
    ifstream fin ("calfflac.in");
    
    //Holds the position of newlines
    int lines[250];

    //Temp string to read in each line
    string s;
    getline(fin,s);

    //Total string
    string all = "";
    int counter{0};

    //Read in each line
    while(s)
    {
        all += s;
        lines[counter] = all.length();
        ++counter;
        getline(fin,s);
    }

    //Lowercase copy
    string lower = "";
    for(int i=0; i<all.length(); ++i)
    {
        lower += tolower(all[i]);
    }

    //Finds first length
    int length{2000};
    if(length > all.length())
    {
        length = all.length();
    }

    //Determines if first length is odd or even
    bool odd{false};
    if(length%2 != 0)
    {
        odd = true;
    }

    //Stores how large the palindrome is from each middle part
    int middle[all.length()][2][2]{0}; //index, odd/even, a/b, add
    int arr[all.length()]{0}; // add
    int half{length/2};
    int a{half-1};
    int b{};
    int index{};
    bool flag{true};
    bool odd2{true};
    while(length > 0 && flag)
    {
        half = length/2;
        for(int add{0}; add<=all.length()-length; add++)
        {            
            a = half-1;
            if(odd)
            {
                //Checks to see if a palindrome has been calculated for this middle
                if(middle[add+half][0][1] - middle[add+half][0][0] == length-1)
                {
                    index = add+half;
                    flag = false;
                    break;
                }
                if(middle[add+half][0][1] - middle[add+half][0][0] > 0)
                {
                    continue;
                }
                b = half+1;
            }else{
                //Checks to see if a palindrome has been calculated for this middle
                if(middle[add+half][1][1] - middle[add+half][1][0] == length-1)
                {
                    index = add+half;
                    flag = false;
                    odd2 = false;
                    break;
                }
                if(middle[add+half][1][1] - middle[add+half][1][0] > 0)
                {
                    continue;
                }
                b = half;
            }

            //Adds to a and b to move down the string
            while(b-a < length && a >= 0 && b < all.length())
            {
                while(!check(lower[a+add]) && a >= 0)
                {
                    --a;
                }
                while(!check(lower[b+add]) && b < all.length())
                {
                    ++b;
                }
                if(lower[a+add] == lower[b+add])
                {
                    
                    if(odd)
                    {
                        middle[add+half][0][0] = a;
                        middle[add+half][0][1] = b;
                        arr[add+half] = add;
                    }else{
                        middle[add+half][1][0] = a;
                        middle[add+half][1][1] = b;
                    }
                    --a;
                    ++b;
                }else{
                    break;
                }
            }
        }
        --length;
        if(odd)
        {
            odd = false;
        }else{
            odd = true;
        }
    }

    if(odd2)
    {
        a = middle[index][0][0] + arr[index];
        b = middle[index][0][1] + arr[index];
        cout << index << " " << middle[index][0][0] << " " << b << endl;
        int x{0};
        while(a > lines[x])
        {
            ++x;
        }
        --x;
        for(a; a<=b; a++)
        {
            fout << all[a];
            cout << all[a];
            if(a == lines[x])
            {
                fout << endl;
                cout << endl;
                ++x;
            }
        }
    }
    return 0;
}