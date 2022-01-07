/*
ID: hwodza1
TASK: ride
LANG: C++                 
*/

#include <iostream>
#include <fstream>
#include <string>

using namespace std;

int main(){
    ofstream fout ("ride.out");
    ifstream fin ("ride.in");
    
    string a,b;
    fin >> a >> b;

    int x = int(a[0])-64, y = int(b[0])-64;
    for(int i = 1; i < a.length(); i++){
        x *= int(a[i])-64;
    }
    for(int i = 1; i < b.length(); i++){
        y *= int(b[i])-64;
    }
    if(x%47 == y%47){
        fout << "GO\n";
    }
    else{
        fout << "STAY\n";
    }
    
    
    return 0;
}