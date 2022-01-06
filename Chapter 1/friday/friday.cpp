/*
ID: hwodza1
TASK: friday
LANG: C++                 
*/

#include <iostream>
#include <fstream>
#include <string>

using namespace std;

int main(){
    ofstream fout ("friday.out");
    ifstream fin ("friday.in");

    int n; fin >> n;
    int days[7] = {3, 0, 1, 3, 1, 2, 2};
    int start[12] = {0, 3, 3, 6, 0, 4, 6, 2, 5, 0, 3, 5}; //Saturday:0, Sunday:1, Monday:2, Tuesday:3, Wednesday:4, Thursday:5, Friday:6
    int year = 1900;
    int month = 0;
    for(int i=0; i<n-1; i++)
    {
        year ++;
        int add = 1;
        if(year%4 == 0)
        {
            if(year%100 == 0)
            {
                if(year%400 == 0)
                {
                    add = 2;
                }
            }
            else
            {
                add = 2;
            }
        }
        for(int j=0; j<12; j++)
        {
            start[j] = (start[j] + add)%7;
            for(int k=0; k<7; k++)
            {
                if(start[j] == k)
                {
                    days[k] ++;
                }
            }
        }
    }
    for(int i=0; i<7; i++)
    {
        fout << days[i] << " ";
    }
    fout << endl;
}