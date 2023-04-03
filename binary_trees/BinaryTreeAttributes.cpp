#include<bits/stdc++.h>

using namespace std;

class Node{
    public:
        int data;
        Node* left;
        Node* right;
        Node(int d){
            this->data = d;
            this->left = NULL;
            this->right = NULL;
        }
};

Node* buildTree(Node* root){
    cout << "Enter data for node : ";
    int data; 
    cin >> data;
    if(data == -1){
        return NULL;
    }
    root = new Node(data);
    cout << "Enter data for inserting to the left of " << data << endl;
    root->left = buildTree(root->left);
    cout << "Enter data for inserting to the right of " << data << endl;
    root->right = buildTree(root->right);
    return root;
}
//Height of a binary tree
int height(Node* root, int res){
    if(root == NULL){
        return res;
    }
    return max(height(root->left, res+1), height(root->right, res+1));
}

//Diameter of a binary tree
//O(N2)
int diameter(Node* root){
    if(root == NULL){
        return 0;
    }
    int heightLeft = height(root->left, 1), heightRight = height(root->right, 1);
    int resA = max(diameter(root->left), diameter(root->right));
    return max(resA, heightLeft + heightRight - 1);
}
//Diameter second approach, O(N)
pair<int, int> diameterFast(Node* root){
    if(root == NULL){
        pair<int, int> res = make_pair(0,0);
        return res;
    }
    pair<int, int>left = diameterFast(root->left);
    pair<int, int>right = diameterFast(root->right);

    int op1 = left.first, op2 = right.first, op3 = left.second + right.second + 1;
    pair<int, int>res = make_pair(max(op1, max(op2, op3)), max(left.second, right.second) + 1);
    return res;
}

int diameterFastTrigger(Node* root){
    return diameterFast(root).first;
}
//O(N) solution
pair<bool, int> checkBalancedTree(Node* root){ // two ways to check, one of O(N2) using checkBalanced fn and height fn, or O(N)
    if(root == NULL){
        pair<bool, int> res = make_pair(true, 0);
        return res;
    }
    pair<bool, int> leftSide = checkBalancedTree(root->left);
    pair<bool, int> rightSide = checkBalancedTree(root->right);
    bool firstAns;
    firstAns = leftSide.first && rightSide.first && (abs(leftSide.second - rightSide.second) <= 1);
    int secondAns = max(leftSide.second, rightSide.second) + 1;
    pair<bool, int> ans = make_pair(firstAns, secondAns);
    return ans;
}

bool checkBalanceTrigger(Node* root){
    return checkBalancedTree(root).first;
}

int main(){
    Node* root = buildTree(root);
    int res = 0;
    // cout << endl << "Height of tree is :";
    // cout << height(root, res) << endl;
    cout << endl << "Diameter of tree is :";
    cout << diameterFastTrigger(root) << endl;
    cout << endl << "Balanced Tree?";
    cout << checkBalanceTrigger(root) << endl;
    return 0;
}