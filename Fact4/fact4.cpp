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
<<<<<<< HEAD
        
=======
        int temp = i;
        if(i%10 == 0)
        {
            while(temp%10 == 0)
            {
                temp/=10;
            }
            fact *= temp%10;
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
>>>>>>> df0e2c657b91517f9060fe43513b533cd4d7259b
    }
    
    cout << "here2 " << fact << endl;
    //fact %=10;
    
<<<<<<< HEAD
    /*
    if(num5 > 1)
    {
        if(num5 > num2)
        {
            fact *= 5;
            fact %= 10; 
        }
    }*/
    
=======
>>>>>>> df0e2c657b91517f9060fe43513b533cd4d7259b
    //fact%=10;
    //cout << "here\n";
    fout << fact << '\n';
    cout << fact << '\n';
    return 0;
}
