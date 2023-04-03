#include <bits/stdc++.h>
// reverse a stack using recursion
using namespace std;

void insert(stack<int> &s, int temp)
{
    if (s.size() == 0)
    {
        s.push(temp);
        return;
    }
    int v = s.top();
    s.pop();
    insert(s, temp);
    s.push(v);
    return;
}

void reverse(stack<int> &s)
{
    if (s.size() == 1)
    {
        return;
    }
    int temp = s.top();
    s.pop();
    reverse(s);
    insert(s, temp);
    return;
}

int main()
{
    int n;
    cin >> n;
    stack<int> input;
    for (int i = 0; i < n; i++)
    {
        int d;
        cin >> d;
        input.push(d);
    }
    reverse(input);
    for (int i = 0; i < n; i++)
    {
        cout << input.top() << " ";
        input.pop();
    }
    return 0;
}