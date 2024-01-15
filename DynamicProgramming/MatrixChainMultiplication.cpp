#include<bits/stdc++.h>
using namespace std;

//recursive
int help(vector<int> arr, int i, int j){
    if(i >= j){
        return 0;
    }
    int minAns = INT_MAX;
    for(int k = i; k <= j - 1; k++){
        int tempAns = help(arr, i, k) + help(arr, k + 1, j) + (arr[i - 1] * arr[k] * arr[j]);
        if(tempAns < minAns)
            minAns = tempAns;
    }
    return minAns;
}

//bottom-up dp
int dp[101][101];
int help2(vector<int> arr, int i, int j){
    if(i >= j){
        return dp[i][j] = 0;
    }
    if(dp[i][j] != -1){
        return dp[i][j];
    }
    int minAns = INT_MAX;
    for(int k = i; k <= j - 1; k++){
        int tempAns = help2(arr, i, k) + help2(arr, k + 1, j) + (arr[i - 1] * arr[k] * arr[j]);
        if(tempAns < minAns)
            minAns = tempAns;
    }
    return dp[i][j] = minAns;
}

int main(){
    vector<int> arr = {40, 20, 30, 10, 30};
    int res = help(arr, 1, arr.size() - 1);
    cout << res << endl;
    memset(dp, -1, sizeof dp);
    int res2 = help2(arr, 1, arr.size() - 1);
    cout << res2 << endl;
    return 0;
}