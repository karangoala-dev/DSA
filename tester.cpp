#include <bits/stdc++.h>

using namespace std;

class Solution
{
public:
    int dp[10000 + 1] = {0};
    int solve(int source, int i, int dist, int dest)
    {
        if (abs(source) > dest)
        {
            return INT_MAX;
        }
        if (i == dist)
        {
            return i;
        }

        return min(solve(source + i, i + 1, dist - i, dest), solve(source - i, i + 1, dist + i, dest));
    }
    int minSteps(int D)
    {
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 3;
        if (D == 1)
        {
            return 1;
        }
        if (D == 2)
        {
            return 3;
        }
        return solve(0, 1, D, D);
    }
};

int main()
{
    int n;
    cin >> n;
    Solution s;
    cout << endl << s.minSteps(n);

    return 0;
}