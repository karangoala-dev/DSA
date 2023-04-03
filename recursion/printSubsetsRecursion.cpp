#include <bits/stdc++.h>
// print subsets
using namespace std;

void printSubsets(string ip, string op, vector<string> &res)
{
    if(ip.length() == 0){
        res.push_back(op);
        return;
    }
    string op1 = op, op2 = op;      //Current output to be same as previous output
    op2.push_back(ip[0]);           //One of them will take the first letter from input(op2) and one wont(op1)
    ip.erase(ip.begin());           //Remove first letter from input since it is already considered in input whether to be taken or not
    printSubsets(ip, op1, res);     //Check for other possibilities on caseA
    printSubsets(ip, op2, res);     //Check for other possibilities on caseB
    return;
}

int main()
{
    string ip, op = "";
    cin >> ip;
    vector<string> res;
    printSubsets(ip, op, res);
    for (int i = 0; i < res.size(); i++)
    {
        if(res[i] == ""){
            cout << "'',";
        }
        else{
            cout << "'" << res[i] << "'"<< ",";
        }
    }
    
    return 0;
}