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
int findroom[50][50] = {0};
vector<int> roomsize; //Vector of room sizes
vector<vector<vector<int>>> rooms; //Vector of every coordinate of every room
vector<vector<int>> tempRooms; //Vector of coordinates of current room

//Function to find the size of a room
void dfs(int x, int y, int roomNum)
{
    
    //cout << x << " " << y << endl;
    if(x < 0 || x >= 50 || y < 0 || y >= 50 || visited[x][y])
    {
        cout << "ERROR" << endl;
        return;
    }
    vector<int> temp = {x,y,roomNum};
    findroom[x][y] = roomNum;
    tempRooms.push_back(temp);
    visited[x][y] = true;
    roomsize[roomNum]++;
    if(!(walls[x][y][1][1]))
    {
        if(!visited[x][y-1])
        {
            //cout << "WEST" << endl;

            dfs(x,y-1,roomNum);
        }
    }
    if(!(walls[x][y][1][0]))
    {
        if(!visited[x+1][y])
        {
            //cout << "SOUTH" << endl;
            dfs(x+1,y,roomNum);
        }
    }
    if(!(walls[x][y][0][0]))
    {
        if(!visited[x-1][y])
        {
            //cout << "NORTH" << endl;
            dfs(x-1,y,roomNum);
        }
    }
    if(!(walls[x][y][0][1]))
    {
        if(!visited[x][y+1])
        {
            //cout << "EAST" << endl;
            dfs(x,y+1,roomNum);
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
    for(int y=0; y<width; y++)
    {
        for(int x=height-1; x>=0; x--)
        {
            cout << input[x][y] << " ";
        }
        cout << endl;
    }
    //Call dfs algorithm
    for(int y=0; y<width; y++)
    {
        for(int x=height-1; x>=0; x--)
        {
            if(!visited[x][y])
            {
                roomsize.push_back(0);
                findroom[x][y] = roomsize.size()-1;
                vector<int> temp = {x,y,roomsize.size()-1};
                tempRooms.push_back(temp);
                dfs(x,y,roomsize.size()-1);
                rooms.push_back(tempRooms);
                tempRooms.clear();
            }
        }
    }
    //Outputs number of rooms
    cout << roomsize.size() << endl;
    fout << roomsize.size() << endl;
    for(int y=0; y<width; y++)
    {
        for(int x=height-1; x>=0; x--)
        {
            cout << findroom[x][y] << " ";
        }
        cout << endl;
    }

    //Finds the largest room by breaking a single wall
    int largest = 0;
    int wall[3] = {0}; //0:x, 1:y, 2:direction(0:North, 1:East)
    for(int y=0; y<width-1; y++)
    {
        //Breaks the northern wall
        for(int x=height-1; x>=1; x--)
        {
            if(findroom[x][y] != findroom[x-1][y])
            {
                if(roomsize[findroom[x][y]] + roomsize[findroom[x-1][y]] > largest)
                {
                    largest = roomsize[findroom[x][y]] + roomsize[findroom[x-1][y]];
                    wall[0] = x;
                    wall[1] = y;
                    wall[2] = 0;
                    cout << "HERE " <<  x << " " << y << " " << wall[2] << endl;
                }
            }
        }
        //Breaks the eastern wall
        for(int x=height-1; x>=0; x--)
        {
            if(findroom[x][y] != findroom[x][y+1])
            {
                if(roomsize[findroom[x][y]] + roomsize[findroom[x][y+1]] > largest)
                {
                    largest = roomsize[findroom[x][y]] + roomsize[findroom[x][y+1]];
                    wall[0] = x;
                    wall[1] = y;
                    wall[2] = 1;
                    cout << "HERE " <<  x << " " << y << " " << wall[2] << endl;
                }
            }
        }
    }
    //Breaks the final set of northern walls
    int y = width-1;
    for(int x=height-1; x>=1; x--)
        {
            if(findroom[x][y] != findroom[x-1][y])
            {
                if(roomsize[findroom[x][y]] + roomsize[findroom[x-1][y]] > largest)
                {
                    largest = roomsize[findroom[x][y]] + roomsize[findroom[x-1][y]];
                    wall[0] = x;
                    wall[1] = y;
                    wall[2] = 0;
                    cout << "HERE " <<  x << " " << y << " " << wall[2] << endl;
                }
            }
        }
    
    //Sorts the rooms by size to find largest
    for(int i=0; i<roomsize.size()-1; i++)
    {
        for(int j=0; j<roomsize.size()-1-i; j++)
        {
            if(roomsize[j] < roomsize[j+1])
            {
                int temp = roomsize[j];
                roomsize[j] = roomsize[j+1];
                roomsize[j+1] = temp;
                vector<vector<int>> temp2 = rooms[j];
                rooms[j] = rooms[j+1];
                rooms[j+1] = temp2;
            }
        }
    }
    

    //Prints largest room with and without breaking a wall, and the wall that was broken
    cout << roomsize[0] << endl;
    cout << largest << endl;
    fout << roomsize[0] << endl;
    fout << largest << endl;
    string walldir = (wall[2] == 0)? "N" : "E";
    cout << wall[0]+1 << " " << wall[1]+1 << " " << walldir << endl;
    fout << wall[0]+1 << " " << wall[1]+1 << " " << walldir << endl;
    fin.close();
    return 0;
}