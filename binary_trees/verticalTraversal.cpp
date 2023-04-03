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
//Outer map stores horizontal distance, inner map stores vertical distance(level order)
void printVerticalOrder(Node* root, int horizontal_distance, int vertical_distance, map<int, map<int, vector<int>>> &m){
    if(root == NULL){
        return;
    }
    if(root->left == NULL && root->right == NULL){
        m[horizontal_distance][vertical_distance].push_back(root->data);
        return;
    }
    m[horizontal_distance][vertical_distance].push_back(root->data);
    printVerticalOrder(root->left, horizontal_distance - 1, vertical_distance + 1, m);
    printVerticalOrder(root->right, horizontal_distance + 1, vertical_distance + 1, m);
}

void printDiagonalOrder(Node* root, int horizontal_distance, int vertical_distance, map<int, map<int, vector<int>>> &m){
    if(root == NULL){
        return;
    }
    if(root->left == NULL && root->right == NULL){
        m[horizontal_distance][vertical_distance].push_back(root->data);
        return;
    }
    m[horizontal_distance][vertical_distance].push_back(root->data);
    printVerticalOrder(root->left, horizontal_distance - 1, vertical_distance + 1, m);
    printVerticalOrder(root->right, horizontal_distance, vertical_distance + 1, m);
}

int main()
{
    Node *root = nullptr; 
    root = buildFromLevelOrder(root);
    // cout << endl
    //      << "Level order traversal :" << endl;
    // 1 3 5 7 9 10 -1 -1 -1 -1 -1 -1 -1
    map<int, map<int, vector<int>>> m;
    // printVerticalOrder(root, 0, 0, m);
    printDiagonalOrder(root, 0, 0, m);
    for(auto it: m){
        cout << "Horizontal " << it.first << "->    ";
        cout << endl;
        for(auto jt: it.second){
            cout << "Level " << jt.first << "-> ";
            for(auto kt: jt.second){
                cout << kt << " ";
            }
            cout << endl;
        }
        cout << endl << endl;
    }

    return 0;
}