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
    cout << "Hello\n";
}