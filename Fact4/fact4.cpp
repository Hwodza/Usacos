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
    int fact = 1; 
    int num2 = 0, num5 = 0;
    for(int i=1; i<=n; i++)
    {
        int temp = i;
        
        temp %= 10;
        if(temp == 0 || temp == 1)
        {
            continue;
        }
        if(temp == 2)
        {
            num2++;
            continue;
        }else if(temp == 5)
        {
            num5++;
            continue;
        }
        while(fact%10 == 0)
        {
            fact /= 10;
        }
        fact %= 10;
        cout << "fact " << fact << " i " << temp << endl;
        fact *= temp;
        
    }
    while(fact%10 == 0)
    {
        fact /= 10;
    }
    cout << "here2 " << fact << endl;
    fact %=10;
    
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
    
    fact%=10;
    //cout << "here\n";
    fout << fact << '\n';
    cout << fact << '\n';
    return 0;
}
