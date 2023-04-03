#include <bits/stdc++.h>
// Balanced parantheses
using namespace std;

void checkBalanced(int o, int c, string op)
{
    if (o == 0 && c == 0)
    {
        cout << op << endl;
        return;
    }
    string op1 = op, op2 = op;
    if (o != 0)
    {
        if (o < c)
        {
            op1 += "(";
            checkBalanced(o - 1, c, op1);
            op2 += ")";
            checkBalanced(o, c - 1, op2);
        }
        else
        {
            op1 += "(";
            checkBalanced(o - 1, c, op1);
        }
    }
    else
    {
        op2 += ")";
        checkBalanced(o, c - 1, op2);
    }
    return;
}

int main()
{
    int n;
    cin >> n;
    int o = n, c = n;
    string op = "";
    checkBalanced(o, c, op);
    return 0;
}