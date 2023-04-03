#include <bits/stdc++.h>

using namespace std;
//GFG- combination sum
void solve(int index, int curr_diff, vector<int> curr_com, vector<int> arr, int sum, vector<vector<int>> &res)
{
    if (curr_diff < 0 || index >= arr.size())
    {
        return;
    }
    if (curr_diff == 0)
    {
        res.push_back(curr_com);
        return;
    }
    curr_com.push_back(arr[index]);
    solve(index, curr_diff - arr[index], curr_com, arr, sum, res);
    curr_com.pop_back();
    solve(index + 1, curr_diff, curr_com, arr, sum, res);
}

vector<vector<int>> combinationSum(vector<int> &arr, int sum)
{
    vector<vector<int>> res;
    map<int, int> m;
    for (int i = 0; i < arr.size(); i++)
    {
        m[arr[i]]++;
    }
    arr.clear();
    for (auto it : m)
    {
        arr.push_back(it.first);
    }
    vector<int> curr_com;
    solve(0, sum, curr_com, arr, sum, res);
    return res;
}

int main()
{
    int n, sum;
    cin >> n >> sum;
    vector<int> arr;
    while (n--)
    {
        int d;
        cin >> d;
        arr.push_back(d);
    }
    vector<vector<int>> res = combinationSum(arr, sum);
    // cout << res.size();
    // cout << endl;
    // for(int i = 0; i < res.size(); i++){
    //     cout << res[i].size() << " ";
    // }
    for(int i = 0; i < res.size(); i++){
        for (int j = 0; j < res[i].size(); j++)
        {
            cout << res[i][j] << " ";
        }
        cout << endl;
    }
    return 0;
}