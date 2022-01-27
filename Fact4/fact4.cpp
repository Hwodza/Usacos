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
        int temp = i%10;
        if(i%10 == 0)
        {
            continue;
        }else if(fact%5 == 0 && fact%2 == 0)
        {
            fact = fact/2;
        }else if(fact%5 == 0 && fact%2 == 1)
        {
            fact = 5;
        }else{
            fact *= i;
        }
        while(fact%10 == 0)
        {
            fact /= 10;
        }
    }
    while(fact%10 == 0)
    {
        fact /= 10;
    }
    cout << "here2 " << fact << endl;
    //fact %=10;
    
    if(num2 >= 1)
    {
        cout << "here " << fact << endl;
        int temp = (num2-num5)%5;
        temp = pow(2, temp);
        temp %= 10;
        fact *= temp;
    }/*
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
