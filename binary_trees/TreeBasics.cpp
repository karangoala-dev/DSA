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

void levelOrderTraversal(Node* root){
    queue<Node*> q;
    q.push(root);
    q.push(NULL);
    while(!q.empty()){
        Node* temp = q.front();
        q.pop();
        if(temp == NULL){
            cout << endl;
            if(!q.empty()){
                q.push(NULL);
            }
        }else{
            cout << temp->data << " ";
            if(temp->left)
                q.push(temp->left);
            if(temp->right)
                q.push(temp->right);
        }
    }
}

void inorderTraversal(Node* root){
    if(root == NULL){
        return;
    }
    inorderTraversal(root->left);
    cout << root->data << " ";
    inorderTraversal(root->right);
}

void preorderTraversal(Node* root){
    if(root == NULL){
        return;
    }
    cout << root->data << " ";
    preorderTraversal(root->left);
    preorderTraversal(root->right);
}

void postorderTraversal(Node* root){
    if(root == NULL){
        return;
    }
    postorderTraversal(root->left);
    postorderTraversal(root->right);
    cout << root->data << " ";
}

Node* buildFromLevelOrder(Node* root){
    cout << "Enter data :" << endl;
    int data;
    cin >> data;
    if(data == -1){
        return NULL;
    }
    root = new Node(data);
    queue<Node*> q;
    q.push(root);
    while(!q.empty()){
        Node* temp = q.front();
        q.pop();
        int leftData, rightData;
        cout << "Enter data for left of " << temp->data << endl;
        cin >> leftData;
        if(leftData != -1){
            temp->left = new Node(leftData);
            q.push(temp->left);
        }
        cout << "Enter data for right of " << temp->data << endl;
        cin >> rightData;
        if(rightData != -1){
            temp->right = new Node(rightData);
            q.push(temp->right);
        }
    }
    return root;
}

int main(){
    // Node* root = buildTree(root);
    Node* root = buildFromLevelOrder(root);
    cout << endl << "Level order traversal :" << endl;
    //1 3 7 -1 -1 11 -1 -1 5 17 -1 -1 -1
    levelOrderTraversal(root);
    cout << endl << "In order traversal :" << endl;
    //1 3 7 -1 -1 11 -1 -1 5 17 -1 -1 -1
    inorderTraversal(root);
    cout << endl << "Pre order traversal :" << endl;
    //1 3 7 -1 -1 11 -1 -1 5 17 -1 -1 -1
    preorderTraversal(root);
    cout << endl << "Post order traversal :" << endl;
    //1 3 7 -1 -1 11 -1 -1 5 17 -1 -1 -1
    postorderTraversal(root);

    return 0;
}