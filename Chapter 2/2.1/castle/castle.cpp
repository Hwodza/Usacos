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
#include <vector>

using namespace std;

bool walls[50][50][2][2] = {false}; //False is no wall, 00:North, 01:East, 10:South, 11:West
bool visited[50][50] = {false};
vector<int> roomsize;
void dfs(int x, int y, int roomNum)
{
    if(x < 0 || x >= 50 || y < 0 || y >= 50 || visited[x][y])
        cout << "ERROR" << endl;
        return;
    
    cout << x << " " << y << endl;
    visited[x][y] = true;
    roomsize[roomNum]++;
    if(!(walls[x][y][0][0]))
    {
        if(!visited[x][y-1])
        {
            cout << "NORTH" << endl;
            dfs(x,y-1,roomNum);
        }
    }
    if(!(walls[x][y][0][1]))
    {
        cout << "here" << endl;
        if(!visited[x+1][y])
        {
            cout << "EAST" << endl;
            dfs(x+1,y,roomNum);
        }
    }
    if(!(walls[x][y][1][0]))
    {
        if(!visited[x][y+1])
        {
            cout << "SOUTH" << endl;
            dfs(x,y+1,roomNum);
        }
    }
    if(!(walls[x][y][1][1]))
    {
        if(!visited[x-1][y])
        {
            cout << "WEST" << endl;
            dfs(x-1,y,roomNum);
        }
    }
}

int main(){
    //Open files
    ofstream fout ("castle.out");
    ifstream fin ("castle.in");

    //Reads in the input data
    int width, height;
    fin >> width >> height;
    int input[width][height];
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
            //South
            if(result[0] == '1')
            {
                walls[i][j][1][0] = true;
            }
            //East
            if(result[1] == '1')
            {
                walls[i][j][0][1] = true;
            }
            //North
            if(result[2] == '1')
            {
                walls[i][j][0][0] = true;
            }
            //West
            if(result[3] == '1')
            {
                walls[i][j][1][1] = true;
            }
        }
    }
    //Call dfs algorithm
    for(int x=0; x<height; x++)
    {
        for(int y=0; y<width; y++)
        {
            if(!visited[x][y])
            {
                //visited[x][y] = true;
                roomsize.push_back(0);
                dfs(x,y,roomsize.size()-1);
            }
        }
    }
    cout << roomsize.size() << endl;
    int largest = 0;
    for(int i=0; i<roomsize.size(); i++)
    {
        if(roomsize[i] > largest)
        {
            largest = roomsize[i];
        }
    }
    cout << largest << endl;
    fin.close();
    return 0;
}