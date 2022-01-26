/*
ID: hwodza1
TASK: fact4
LANG: C++                 
*/

#include <iostream>
#include <fstream>
#include <string>
#include <stdio.h>
using namespace std;

int main(){
    ifstream fin ("fact4.in");
    ofstream fout ("fact4.out");
    /*
    int n;
    fin >> n;
    int fact = 1;
    for(int i=1; i<=n; i++)
    {
        fact *= i;
        int temp = fact%10;
        while(temp == 0)
        {
            if(fact == 0)
            {
                cout << "here " << i << endl;
                break;
            }
            fact /= 10;
            temp = fact%10;
        }
        fact %= 10;
    }*/

    
    int n;
    fin >> n;
    int fact = n; 
    for(int i=n-1; i>0; i--)
    {
        
        while(fact%10 == 0)
        {
            fact /= 10;
        }
        int temp = i;
        while(temp%10 == 0)
        {
            temp /= 10;
        }
        temp %= 10;
        fact %= 10;
        cout << "fact " << fact << " i " << temp << endl;
        fact *= temp;
        
    }
    
    //cout << "here\n";
    fout << fact << '\n';
    cout << fact << '\n';
    return 0;
}