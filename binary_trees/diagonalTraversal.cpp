#include <bits/stdc++.h>

using namespace std;

class Node
{
public:
    int data;
    Node *left;
    Node *right;
    Node(int data)
    {
        this->data = data;
        this->left = NULL;
        this->right = NULL;
    }
};

Node *buildFromLevelOrder(Node *root)
{
    cout << "Enter data :" << endl;
    int data;
    cin >> data;
    if (data == -1)
    {
        return NULL;
    }
    root = new Node(data);
    queue<Node *> q;
    q.push(root);
    while (!q.empty())
    {
        Node *temp = q.front();
        q.pop();
        int leftData, rightData;
        cout << "Enter data for left of " << temp->data << endl;
        cin >> leftData;
        if (leftData != -1)
        {
            temp->left = new Node(leftData);
            q.push(temp->left);
        }
        cout << "Enter data for right of " << temp->data << endl;
        cin >> rightData;
        if (rightData != -1)
        {
            temp->right = new Node(rightData);
            q.push(temp->right);
        }
    }
    return root;
}

void solve(Node* root, int d, map<int, vector<int>> &m){
    if(root == NULL){
        return;
    }
    m[d].push_back(root->data);
    solve(root->left, d - 1, m);
    solve(root->right, d, m);
}

vector<int> diagonal(Node *root)
{
    vector<int> res;
    map<int, vector<int>> m;
    solve(root, 0, m);
    for(auto it: m){
        vector<int> temp = it.second;
        for(auto jt: temp){
            res.push_back(jt);
        }
    }
    return res;
}
//12 11 12 7 1 12 14 11 -1 7 3 6 4 12 7 14 14 -1 2 10 8 7
int main()
{
    Node *root = nullptr; 
    root = buildFromLevelOrder(root);
    vector<int> res = diagonal(root);
    for(auto it: res){
        cout << it << " ";
    }
    return 0;
}