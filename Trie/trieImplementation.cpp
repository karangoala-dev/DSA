#include <bits/stdc++.h>

using namespace std;
//Time complexity of insert O(Length of word)
//Time complexity of search O(Length of word)
class TrieNode
{
public:
    char data;
    TrieNode *children[26];
    bool isTerminal;
    TrieNode(char c)
    {
        data = c;
        for (int i = 0; i < 26; i++)
        {
            children[i] = NULL;
        }
        isTerminal = false;
    }
};

class Trie
{
public:
    void insertUtil(TrieNode *root, string word)
    {
        if (word.size() == 0)
        {
            root->isTerminal = true;
            return;
        }
        int ind = word[0] - 'A'; // Assumption, all words are in CAPS
        TrieNode *child = NULL;
        // Character present in children, set child node
        if (root->children[ind] != NULL)
        {
            child = root->children[ind];
        }
        // Character not present in children, create new TrieNode and set it as children
        else
        {
            child = new TrieNode(word[0]);
            root->children[ind] = child;
        }
        insertUtil(child, word.substr(1));
    }
    bool searchUtil(TrieNode *root, string word)
    {
        if(word.size() == 0){
            return root->isTerminal;
        }
        int ind = word[0] - 'A';
        TrieNode* next;
        if(root->children[ind] != NULL){
            next = root->children[ind];
        }
        else{
            return false;
        }
        return searchUtil(next, word.substr(1));
    }
    TrieNode *root;
    void insert(string word)
    {
        return insertUtil(root, word);
    }
    bool search(string word)
    {
        return searchUtil(root, word);
    }
    Trie()
    {
        root = new TrieNode('\0');
    }
};

int main()
{
    Trie *t = new Trie();
    t->insert("DOGGO");
    t->insert("TIME");
    t->insert("DOGGOMATI");
    cout << "Present or not " << t->search("DOGGOMATI");
    return 0;
}