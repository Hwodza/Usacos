//NAME                      : Henry Odza
//GROUP                     : AdvCS
//LAST MODIFIED             : January 30th, 2022
//PROBLEM ID                : USACO Photoshoot 2
//SOURCES/HELPERS/HELPED    : Mr.H

#include <iostream>

using namespace std;

int main(){
    int n{};
    cin >> n;
    int original[n];
    int desired[n];
    for(int i{}; i<n; i++)
    {
        cin >> original[i];
    }
    for(int i{}; i<n; i++)
    {
        cin >> desired[i];
    }
    int total{0};
    int cutoff{0};
    while(original[cutoff] == desired[cutoff])
    {
        ++cutoff;
    }
    while(cutoff < n)
    {
        for(int i{cutoff}; i<n; i++)
        {
            if(desired[cutoff] == original[i])
            {
                original[cutoff];
            }
        }
    }
    /*
    int distance[n][2][2]; //Number, index, distance, desired index
    for(int i{0}; i<n; ++i){
        cin >> original[i];
        distance[original[i]][1][0] = i; //Inputs current index
    }
    for(int i{0}; i<n; ++i){
        cin >> desired[i];
        distance[desired[i]][0][1] = distance[desired[i]][1][0] - i; //Inputs distance
        distance[desired[i]][1][1] = i; //Inputs desired index
    }

    int totalMoves{0};
    int cutoff{0};
    int x{0};
    while(original[x] == desired[x])
    {
        ++cutoff;
    }
    while(cutoff < n)
    {
        int maxIndex{0};

        for(int i{cutoff}; i<n; ++i)
        {
            if(distance[original[i]][0][1] > distance[original[maxIndex]][0][1])
            {
                maxIndex = i;
            }
        }
        ++totalMoves;
        distance[original[maxIndex]][0][1] = 0;
        distance[original[maxIndex][1][0]] = distance[original[maxIndex]][1][1];
        int counter{distance[original[maxIndex]][1][1]+1};

        
    }
    */


}