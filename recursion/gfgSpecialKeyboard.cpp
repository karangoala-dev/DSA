#include<bits/stdc++.h>
using namespace std;
//Using recursion
// class Solution{
// public:
//     long long int optimalKeys(int N){
//         long long int res = -1;
//         long long int n = N;
//         if(n <= 6){
//             res = N;
//             return res;
//         }
//         for(long long int i = 3; i <= n - 1; i++){
//             long long subRes = (i - 1) * optimalKeys(n - i); //((n-i)+(n-i)*(i-2))
//             res = max(res, subRes);
//         }
//         return res;
//     }
// };

//Using DP(efficient)
class Solution{
public:
    
    long long int optimalKeys(int N){
        if(N <= 6){
            return N;
        }
        long long int dp[N+1];
        for(int i = 0; i < N+1; i++){
            dp[i] = 0;
        }
        long long int res = -1;
        long long int n = N;
        for(int i = 0; i <= 6; i++){
            dp[i] = i;
        }
        for(long long int i = 7; i <= n; i++){
            for(long long int j = 3; j <= i-1; j++){
                dp[i] = max(dp[i],(j - 1) * dp[i - j]);
            }
        }
        res = dp[n];
        return res;
    }
};

int main(){
    int n;
    cin >> n;
    Solution obj;
    long long int res = obj.optimalKeys(n);
    cout << endl << res;
}