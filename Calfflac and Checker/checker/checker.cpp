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


void placequeen(int column){
    if(column == *pn){
        //Do something
    }
    for(int row=0; row<*pn; row++){
        //Do something
        if(!rows[row]){
            rows[row] = true;
            placement[column] = row;
            rows[row] = false;
        }
    }
}


int main(){
    
    ifstream fin ("checker.in");
    int n; fin >> n;
    *pn = n;
    cout << *pn << "\n";
    return 0;
}

/*
bool** outer = new bool*[3];
int** ptorder = new int*[1];
int temp = 0;
int* p = &temp;

void placequeen(int column){
    
    if(column == *p){
        for(int i=0; i<*p; i++){
            fout << ptorder[0][i]+1 << " ";
        }
        return;
    }
    for(int row = 0; row < *p; row++){
        if(outer[0][row] && outer[1][-1*row+column + 5] && outer[2][row+column]){
            ptorder[0][row] = column;
            outer[0][row] = false;
            outer[1][-1*row+column + 5] = false;
            outer[2][row+column] = false;
            placequeen(column + 1);
            outer[0][row] = true;
            outer[1][-1*row+column + 5] = true;
            outer[2][row+column] = true;
        }
    }
    
}


int main(){
    
    ifstream fin ("checker.in");
    int n; cin >> n;
    
    *p = n;
    outer[0] = new bool[n]; //Row check
    outer[1] = new bool[n*2-1]; //Top left to bottom right diagonal check
    outer[2] = new bool[n*2-1]; //Top right to bottom left diagonal check
    memset(outer[0], true, sizeof(outer[0]));
    memset(outer[1], true, sizeof(outer[1]));
    memset(outer[2], true, sizeof(outer[2]));
    ptorder[0] = new int[n];
    placequeen(0);
    return 0;
}*/