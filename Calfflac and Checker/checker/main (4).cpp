/*
ID: hwodza1
TASK: checker
LANG: C++                 
*/


//NAME                      : Henry Odza
//GROUP                     : AdvCS
//LAST MODIFIED             : February 23, 2022
//PROBLEM ID                : USACO Mother's Milk 
//Decription                : Determines what amounts of milk he can leave inbucket C
//                          : when he begins with three buckets, pours milk among the 
//                          : buckets for a while, and then notes that bucket A is empty.
//SOURCES/HELPERS/HELPED    : Mr.H, Ben Whitsett


#include <iostream>
#include <fstream>
#include <string>
#include <cstring>

using namespace std;


ofstream fout ("checker.out");
//Global Variables
int n;
bool rows[13]; //False = empty, True = full
int placement[13]; 
bool** diags = new bool*[2];
bool ldiags[25]; //Top left to bottom right diagonal check
bool rdiags[25]; //Top right to bottom left diagonal check
int total{0};
int printed{0};

void placequeen(int column){
	//Checks to see if is a final solution
    if(column == n){
        if(printed > 2)
        {
            ++total;
            return;
        }
        ++total;
        ++printed;
        fout << placement[0];
        for(int i=1; i<n; ++i){
            fout << " " << placement[i];
        }
        fout << endl;
        return;
    }
    for(int row=0; row<n; ++row){
        //Checks rows and diags and then places new queen
        if(!rows[row]&&!ldiags[-1*row+column+13]&&!rdiags[row+column]){
            rows[row] = true;
            ldiags[-1*row+column + 13] = true;
            rdiags[row+column] = true;
            placement[column] = row+1;
            placequeen(column+1);
            rows[row] = false;
            ldiags[-1*row+column + 13] = false;
            rdiags[row+column] = false;
        }
    }
}


int main(){
    
    ifstream fin ("checker.in");
    fin >> n;
	
	placequeen(0);
    fout << total << '\n';
    return 0;
}

