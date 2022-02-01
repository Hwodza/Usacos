/*
ID: hwodza1
TASK: fact4
LANG: C++                 
*/

#include <iostream>
#include <fstream>
#include <string>
#include <stdio.h>
#include <cmath>
using namespace std;

int main(){
    ifstream fin ("fact4.in");
    ofstream fout ("fact4.out");

    int n;
    fin >> n;
    int fact = 1; 
    int num2 = 0, num5 = 0;
    for(int i=1; i<=n; i++)
    {
        
    }
    
    cout << "here2 " << fact << endl;
    //fact %=10;
    
    /*
    if(num5 > 1)
    {
        if(num5 > num2)
        {
            fact *= 5;
            fact %= 10; 
        }
    }*/
    
    //fact%=10;
    //cout << "here\n";
    fout << fact << '\n';
    cout << fact << '\n';
    return 0;
}
