/*
ID: hwodza1
TASK: checker
LANG: C++                 
*/


//NAME                      : Henry Odza
//GROUP                     : AdvCS
//LAST MODIFIED             : January 8, 2022
//PROBLEM ID                : USACO Mother's Milk 
//Decription                : Determines what amounts of milk he can leave inbucket C
//                          : when he begins with three buckets, pours milk among the 
//                          : buckets for a while, and then notes that bucket A is empty.
//SOURCES/HELPERS/HELPED    : Mr.H


#include <iostream>
#include <fstream>
#include <string>
#include <cstring>

using namespace std;


ofstream fout ("checker.out");
//Global Variables
int tempn = 0;
int *pn = &tempn;
bool rows[13] = {0}; //False = empty, True = full
int placement[13]; 
bool** diags = new bool*[2];

void placequeen(int column){
    if(column == *pn){
        for(int i=0; i<*pn; i++){
            cout << placement[i] << " ";
        }
        cout << endl;
        return;
    }
    for(int row=0; row<*pn; row++){
        //Do something
        
        if(!rows[row]&&!diags[0][-1*row+column+5]&&!diags[1][row+column]){
            rows[row] = true;
            diags[0][-1*row+column + 5] = true;
            diags[1][row+column] = true;
            placement[row] = column+1;
            placequeen(column+1);
            rows[row] = false;
            diags[0][-1*row+column + 5] = false;
            diags[1][row+column] = false;
        }
    }
}


int main(){
    
    ifstream fin ("checker.in");
    int n; fin >> n;
    *pn = n;
    diags[0] = new bool[n*2-1]; //Top left to bottom right diagonal check
    diags[1] = new bool[n*2-1]; //Top right to bottom left diagonal check
    memset(diags[0], false, sizeof(diags[0]));
    memset(diags[1], false, sizeof(diags[1]));
    placequeen(0);
    cout << *pn << "\n";
    return 0;
}

