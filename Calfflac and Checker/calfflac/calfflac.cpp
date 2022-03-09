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
    while(s != NULL)
    {
        all += s;
        lines[counter] = all.length();
        ++counter;
        getline(fin,s);
    }

    //Lowercase copy
    string lower = tolower(all);

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
    int middle[all.length()][2][2]{0}; //index, odd/even, a/b
    int half{length/2};
    int a{half-1};
    int b{};
    int index = half;
    while(length > 0)
    {
        half = length/2;
        a = half-1;
        if(odd)
        {
            b = half+1;
        }else{
            b = half;
        }

        //Adds to a and b to move down the string
        int add{0};
        while(b-a < length)
        {
            while(!check(lower[a+add]))
            {
                --a;
            }
            while(!check(lower[b+add]))
            {
                ++b;
            }
            if(lower[a+add] == lower[b+add])
            {
                if(odd)
                {
                    middle[add+half][0][0] = a;
                    middle[add+half][0][1] = b;
                }else{
                    middle[add+half][1][0] = a;
                    middle[add+half][1][1] = b;
                }
            }else{
                break;
            }
        }
    }
    return 0;
}