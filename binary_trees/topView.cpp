#include<bits/stdc++.h>

using namespace std;

class Node{
    public:
        int data;
        Node* left;
        Node* right;
};

class Solution
{
    public:
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    vector<int> topView(Node *root)
    {
        vector<int> ans;
        map<int, int> m;
        queue<pair<Node*, int>> q;
        q.push(make_pair(root, 0));
        while(!q.empty()){
            pair<Node*, int> p = q.front();
            q.pop();
            if(m.find(p.second) == m.end()){
                m[p.second] = p.first->data;
            }
            if(p.first->left){
                q.push(make_pair(p.first->left, p.second-1));
            }
            if(p.first->right){
                q.push(make_pair(p.first->right, p.second+1));
            }
        }
        for(auto it: m){
            ans.push_back(it.second);
        }
        return ans;
    }

};

int main(){
    return 0;
}