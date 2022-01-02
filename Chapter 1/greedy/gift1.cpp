/*
ID: hwodza1
TASK: gift1
LANG: C++                 
*/

#include <iostream>
#include <fstream>
#include <string>

using namespace std;

int main(){
    ofstream fout ("gift1.out");
    ifstream fin ("gift1.in");

    int n; 
    fin >> n;
    string names[n];
    for(int i=0; i<n; i++){
        fin >> names[i];
    }
    int balance[n];
    for(int i=0; i<n; i++){
        balance[i] = 0;
    }
    for(int i=0; i<n; i++){
        string giver;
        fin >> giver;
        int index;
        for(int j=0; j<n; j++){
            if(names[j] == giver){
                index = j;
                break;
            }
        }
        int money, num_people;
        fin >> money >> num_people;
        if(num_people == 0 || money == 0){
            continue;
        }
        int money_per_person = money/num_people;
        for(int j=0; j<num_people; j++){
            string receiver;
            fin >> receiver;
            for(int k=0; k<n; k++){
                if(names[k] == receiver){
                    balance[k] += money_per_person;
                    break;
                }
            }
        }
        balance[index] -= money;
        balance[index] += money%num_people;
    }
    for(int i=0; i<n; i++){
        fout << names[i] << " " << balance[i] << endl;
    }
}