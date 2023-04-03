#include <bits/stdc++.h>

using namespace std;
// Josephus Problem
void josephusProblem(int index, int k, vector<int> arr)
{
    if (arr.size() == 1)
    {
        cout << arr[0] << endl;
    }
    arr.erase(arr.begin() + ((index + (k - 1)) % arr.size()));
    josephusProblem(((index + (k - 1)) % arr.size()), k, arr);
    return;
}

int main()
{
    int n, k;
    cin >> n >> k;
    vector<int> arr(n);
    for (int i = 0; i < n; i++)
    {
        arr[i] = i + 1;
    }
    josephusProblem(0, k, arr);
    return 0;
}