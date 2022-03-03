/*
ID: hwodza1
TASK: castle
LANG: C++                 
*/


//NAME                      : Henry Odza
//GROUP                     : AdvCS
//LAST MODIFIED             : March 2nd, 2022
//PROBLEM ID                : USACO The Castle
//Decription                : Given a floor plan of a castle, determine a single wall to break to 
//                          : make the biggest possible area
//SOURCES/HELPERS/HELPED    : Mr.H

#include <iostream>
#include <fstream>
#include <string>
#include <cstring>

using namespace std;



int main(){
    //Open files
    ofstream fout ("castle.out");
    ifstream fin ("castle.in");

    //Reads in the input data
    int width, height;
    fin >> width >> height;
    int input[width][height];
    bool walls[width][height][4][4][4][4] = {false}; //False is no wall: S,E,N,W
    for(int i=0; i<height; i++)
    {
        for(int j=0; j<width; j++)
        {
            //Reads in the input data
            fin >> input[i][j];

            //Converts to base 2
            int temp = input[i][j];
            int temp2;
            string result{""};
            while(temp > 0)
            {
                temp2 = temp%2;
                result.insert(0,1,temp2+'0');
                temp /= 2;
            }
            while(result.length() < 4)
            {
                result.insert(0,"0");
            }

            //Sets the walls
            if(result[0] == '1')
            {
                walls[i][j][1][0][0][0] = true;
            }
            if(result[1] == '1')
            {
                walls[i][j][0][1][0][0] = true;
            }
            if(result[2] == '1')
            {
                walls[i][j][0][0][1][0] = true;
            }
            if(result[3] == '1')
            {
                walls[i][j][0][0][0][1] = true;
            }
        }
    }
    
    bool visited[width][height] = {false};
    //Call dfs algorithm

    fin.close();
    return 0;
}