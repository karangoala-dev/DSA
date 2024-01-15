//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// Tree Node
struct Node
{
    int data;
    Node* left;
    Node* right;
};

// Utility function to create a new Tree Node
Node* newNode(int val)
{
    Node* temp = new Node;
    temp->data = val;
    temp->left = NULL;
    temp->right = NULL;
    
    return temp;
}

// Function to Build Tree
Node* buildTree(string str)
{   
    // Corner Case
    if(str.length() == 0 || str[0] == 'N')
            return NULL;
    
    // Creating vector of strings from input 
    // string after spliting by space
    vector<string> ip;
    
    istringstream iss(str);
    for(string str; iss >> str; )
        ip.push_back(str);
        
    // Create the root of the tree
    Node* root = newNode(stoi(ip[0]));
        
    // Push the root to the queue
    queue<Node*> queue;
    queue.push(root);
        
    // Starting from the second element
    int i = 1;
    while(!queue.empty() && i < ip.size()) {
            
        // Get and remove the front of the queue
        Node* currNode = queue.front();
        queue.pop();
            
        // Get the current node's value from the string
        string currVal = ip[i];
            
        // If the left child is not null
        if(currVal != "N") {
                
            // Create the left child for the current node
            currNode->left = newNode(stoi(currVal));
                
            // Push it to the queue
            queue.push(currNode->left);
        }
            
        // For the right child
        i++;
        if(i >= ip.size())
            break;
        currVal = ip[i];
            
        // If the right child is not null
        if(currVal != "N") {
                
            // Create the right child for the current node
            currNode->right = newNode(stoi(currVal));
                
            // Push it to the queue
            queue.push(currNode->right);
        }
        i++;
    }
    
    return root;
}

class Solution
{
private:

public:
    pair<Node*, int> findTargetNode(Node* root, int target, int d){
        if(root == NULL){
            pair<Node*, int> p = make_pair(nullptr, d);
            return p; 
        }
        if(root->data == target){
            pair<Node*, int> p = make_pair(root, d);
            return p;
        }
        pair<Node*, int> leftP = findTargetNode(root->left, target, d + 1);
        pair<Node*, int> rightP = findTargetNode(root->right, target, d + 1);
        if(leftP.first != NULL){
            return leftP;
        }
        else if(rightP.first != NULL){
            return rightP;
        }
        return make_pair(nullptr, d);
    }
    void findNodes(vector<int> &res, Node* root, int d, int curr){
        if(root == NULL){
            return;
        }
        if(d < 0){
            return;
        }
        if(d == curr){
            res.push_back(root->data);
            return;
        }
        findNodes(res, root->left, d, curr + 1);
        findNodes(res, root->right, d, curr + 1);
        return;
    }
    vector <int> KDistanceNodes(Node* root, int target , int k)
    {
        vector<int> res;
        if(root == NULL){
            return res;
        }
        if(root->data == target){
            findNodes(res, root, k, 0);
        }
        int dist = 0;
        pair<Node*, int> leftP = findTargetNode(root->left, target, dist + 1);
        pair<Node*, int> rightP = findTargetNode(root->right, target, dist + 1);
        Node* targetNodeLeft = leftP.first;
        Node* targetNodeRight = rightP.first;
        Node* targetNode;
        int leftD, rightD;
        
        if(targetNodeLeft == NULL && targetNodeRight == NULL){
            targetNode = root;
            dist = 0;
            leftD = k;
            rightD = k;
        }else if(targetNodeLeft != NULL && targetNodeRight == NULL){
            targetNode = targetNodeLeft;
            dist = leftP.second;
            leftD = dist + k;
            rightD = k - dist;
        }else{
            targetNode = targetNodeRight;
            dist = rightP.second;
            leftD = k - dist;
            rightD = dist + k;
        }
        int curr = 1;
        /*cout << side << dist << endl << rightD << " " << leftD;*/
        findNodes(res, root->left, leftD, curr);
        findNodes(res, root->right, rightD, curr);
        if(k == dist){
            res.push_back(root->data);
        }
        sort(res.begin(), res.end());
        return res;
    }
};

//{ Driver Code Starts.

int main()
{
    int t;
    cin>>t;
    getchar();
    
    Solution x = Solution();
    
    while(t--)
    {
        string s;
        getline(cin,s);
        Node* head = buildTree(s);
        
        int target, k;
        cin>> target >> k;
        getchar();
        
        vector <int> res = x.KDistanceNodes(head, target, k);
        
        for( int i=0; i<res.size(); i++ )
            cout<< res[i] << " ";
        cout<<endl;
    }
    return 0;
}

// } Driver Code Ends