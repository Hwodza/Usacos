/*
ID: hwodza1
TASK: sort3
LANG: C++                 
*/


//NAME                      : Henry Odza
//GROUP                     : AdvCS
//LAST MODIFIED             : March 19nd, 2022
//PROBLEM ID                : USACO Sorting a Three-Valued Sequence
//Decription                : Given a sequence of integers, sort the sequence in ascending order with
//                          : as few moves as possible.
//SOURCES/HELPERS/HELPED    : Mr.H

#include <iostream>
#include <fstream>
#include <string>
#include <cstring>
#include <vector>

using namespace std;

/*Break it into parts, sort until the first 3, then rest, prioritizing moving 3s back*/

int main(){
    //IO
    ofstream fout ("sort3.out");
    ifstream fin ("sort3.in");

    //Reads in data
    int n;
    fin >> n;
    int original[n];
    int sorted[n];
    for(int i=0; i<n; ++i)
    {
        int temp;
        fin >> temp;
        original[i] = temp;
        sorted[i] = temp;
    }

    //Sorts the sorted list
    for(int i=0; i<n-1; ++i)
    {
        for(int j=0; j<n-i-1; ++j)
        {
            if(sorted[j] > sorted[j+1])
            {
                int temp = sorted[j];
                sorted[j] = sorted[j+1];
                sorted[j+1] = temp;
            }
        }
    }
    
    //Finds all of the one move swaps
    int swaps = 0;
    for(int i=0; i<n; ++i)
    {
        for(int j=0; j<n; ++j)
        {
            if(original[i] != sorted[i] && original[j] != sorted[j] && original[i] == sorted[j] && original[j] == sorted[i])
            {
                original[i] = sorted[i];
                original[j] = sorted[j];
                ++swaps;
            }
        }
    }
    //Finds all differences
    int numdiff = 0;
    for(int i=0; i<n; ++i)
    {
        if(original[i] != sorted[i])
        {
            numdiff++;
        }
    }
    //Outputs (numdiff/3*2 is done because the rest are in groups of 3 that need two swaps)
    fout << numdiff/3*2 + swaps << endl;
}