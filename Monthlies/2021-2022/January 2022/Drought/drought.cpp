//NAME                      : Henry Odza
//GROUP                     : AdvCS
//LAST MODIFIED             : January 30th, 2022
//PROBLEM ID                : USACO Drought
//SOURCES/HELPERS/HELPED    : Mr.H

#include <iostream>

using namespace std;



int main(){
    int t;
    cin >> t;
    for(int count=0; count<t; count++)
    {
        int n;
        cin >> n;
        //cout << "N: " << n << endl;

        int hunger[n];
        for(int i=0; i<n; i++){
            cin >> hunger[i];
        }
        if(n == 1)
        {
            cout << "0\n";
            continue;
        }
        if(n == 2)
        {
            cout << "-1\n";
            continue;
        }
        if(hunger[0] > hunger[1])
        {
            cout << "-1\n";
            continue;
        }
        if(hunger[n-1] > hunger[n-2])
        {
            cout << "-1\n";
            continue;
        }
        int total = 0;
        int index[n];
        int sorted[n];
        for(int i=0; i<n; i++)
        {
            index[i] = i;
            sorted[i] = hunger[i];
        }
        
        
        for(int i=0; i<n-1;i++)
        {
            for(int j=0; j<n-i-1;j++)
            {
                if(sorted[j] > sorted[j+1])
                {
                    int temp = sorted[j];
                    sorted[j] = sorted[j+1];
                    sorted[j+1] = temp;
                    temp = index[j];
                    index[j] = index[j+1];
                    index[j+1] = temp;
                }
            }
        }
        int index2 = n-1;
        /*
        for(int i=0; i<n; i++)
        {
            cout << sorted[i] << " ";
        }
        cout << endl;
        for(int i=0; i<n; i++)
        {
            cout << index[i] << " ";
        }
        cout << endl;*/
        while(true)
        {
            int max = hunger[index[index2]];
            int maxIndex = index[index2];
            //cout << index[index2] << endl;
            if(index2 == 2 && hunger[0] == hunger[n-1])
            {
                if(hunger[1] == 1)
                {
                    cout << "-1\n";
                    break;
                }
                cout << total << "\n";
                break;
            }
            if(!(maxIndex == n-1))
            {
                if(max == hunger[maxIndex-1]){
                    int temp = max - hunger[maxIndex+1];
                    hunger[maxIndex] -= temp;
                    hunger[maxIndex-1] -= temp;
                    total += temp*2;
                }else if(hunger[maxIndex+1] == max){
                    int temp = max - hunger[maxIndex-1];
                    hunger[maxIndex] -= temp;
                    hunger[maxIndex+1] -= temp;
                    total += temp*2;
                }else if(hunger[maxIndex-1] <= hunger[maxIndex+1]){
                    int temp = max - hunger[maxIndex+1];
                    if(hunger[maxIndex-1] - temp < 0)
                    {
                        cout << "-1\n";
                        break;
                    }
                    hunger[maxIndex-1] -= temp;
                    hunger[maxIndex] -= temp;
                    total += temp*2;
                }else{
                    int temp = max - hunger[maxIndex-1];
                    if(hunger[maxIndex+1] - temp < 0)
                    {
                        cout << "-1\n";
                        break;
                    }
                    hunger[maxIndex+1] -= temp;
                    hunger[maxIndex] -= temp;
                    total += temp*2;
                }
                if(hunger[index[index2]] >= hunger[index[index2-1]])
                {
                    //index2--;
                }else{
                    index2--;
                }
            }else{
                if(hunger[maxIndex-1] == max)
                {
                    int temp = max - hunger[maxIndex-2];
                    total += temp*2;
                    cout << total << "\n";
                    break;
                }else{
                    cout << "-1\n";
                    break;
                }
            }
        }
    }
    return 0;
}