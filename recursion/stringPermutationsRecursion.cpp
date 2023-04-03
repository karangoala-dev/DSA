#include <bits/stdc++.h>

using namespace std;

void swap(char &a, char &b)
{
    char c = a;
    a = b;
    b = c;
}

void solve(string &s, int index)
{
    if (index >= s.size())
    {
        cout << s << endl;
        return;
    }
    for (int j = index; j < s.size(); j++)
    {
        swap(s[index], s[j]);
        solve(s, index + 1);
        swap(s[index], s[j]);
    }
    return;
}

int main()
{
    string input;
    cin >> input;
    solve(input, 0);

    return 0;
}