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
    int n;
    fin >> n;
    int arr[n];
    for(int i=0; i<n; i++)
    {
        fin >> arr[i];
    }
    int swaps = 0;
    for(int j=0; j<n; j++)
    {
        cout << arr[j] << " ";
    }
    cout << endl;
    for(int i=1; i<n; i++)
    {
        if(arr[i] == 1)
        { 
            int index = 0;
            while(index < i && arr[index] <= 2)
            {
                ++index;
            }
            if(arr[index] > 2)
            {
                int temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
                ++swaps;
                i = index-1;
                for(int j=0; j<n; j++)
                {
                    cout << arr[j] << " ";
                }
                cout << endl;
                cout << index << endl;
            }else{
                index = 0;
                while(index < i && arr[index] == 1)
                {
                    ++index;
                }
                if(arr[index] > 1)
                {
                    int temp = arr[index];
                    arr[index] = arr[i];
                    arr[i] = temp;
                    ++swaps;
                    i = index-1;
                    for(int j=0; j<n; j++)
                    {
                        cout << arr[j] << " ";
                    }
                    cout << endl;
                    cout << index << endl;
                }
            }
        }
    }
    for(int i=1; i<n; i++)
    {
        if(arr[i] == 2)
        { 
            int index = 0;
            while(index < i && arr[index] <= 2)
            {
                ++index;
            }
            if(arr[index] > 2)
            {
                int temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
                ++swaps;
                i = index-1;
                for(int j=0; j<n; j++)
                {
                    cout << arr[j] << " ";
                }
                cout << endl;
                cout << index << endl;
            }
        }
    }
    for(int j=0; j<n; j++)
    {
        cout << arr[j] << " ";
    }
    cout << endl;
    fout << swaps << endl;
}