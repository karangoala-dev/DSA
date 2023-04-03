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

vector<int> zigZag(Node *root)
{
    vector<int> res;
    queue<Node*> q;
    q.push(root);
    bool l_to_r = true;
    while(!q.empty()){
        int size = q.size();
        vector<int> v(size);
        for(int i = 0; i < size; i++){
            Node* front_node = q.front();
            q.pop();
            int ind = l_to_r ? i : size - i - 1;
            v[ind] = front_node->data;

            if(front_node->left){
                q.push(front_node->left);
            }
            if(front_node->right){
                q.push(front_node->right);
            }
        }
        l_to_r = !l_to_r;
        for(auto it: v){
            res.push_back(it);
        }
    }
    return res;
}

int main()
{
    Node *root = buildFromLevelOrder(root);
    cout << endl
         << "Zigzag level order traversal :" << endl;
    // 1 3 5 7 9 10 -1 -1 -1 -1 -1 -1 -1
    vector<int> res = zigZag(root);
    for(auto it: res){
        cout << it << " ";
    }
    return 0;
}