#include <bits/stdc++.h>
// tower of Hanoi using recursion
using namespace std;

void towerOfHanoi(int n, char from, char to, char aux, int &steps)
{
    steps++;
    if (n == 1)
    {
        // cout << "Move plate " << n << " from " << from << " to " << to << " via " << aux << endl;
        return;
    }
    towerOfHanoi(n - 1, from, aux, to, steps);
    // cout << "Move plate " << n << " from " << from << " to " << aux << " via " << aux << endl;
    towerOfHanoi(n - 1, aux, to, from, steps);
    // cout << "Move plate " << n << " from " << aux << " to " << to << " via " << from << endl;
    return;
}

int main()
{
    int n, steps = 0;
    cin >> n;
    towerOfHanoi(n, 'A', 'B', 'C', steps);
    cout << steps;
    return 0;
}