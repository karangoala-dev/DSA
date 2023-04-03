#include <bits/stdc++.h>

using namespace std;
// GFG- Word Boggle
// Approach #1 - not efficient - uses recursion
bool dfs(vector<vector<char>> &board, string word, vector<vector<bool>> isVisited, int ind, int r, int c){
    if(ind == word.size()){
        return true;
    }
    if(r>=0 && r<board.size() && c>=0 && c<board[0].size() && isVisited[r][c]==false && board[r][c]==word[ind]){
        isVisited[r][c] = true;
        if(dfs(board,word,isVisited,ind+1,r,c+1)||
        dfs(board,word,isVisited,ind+1,r,c-1)||
        dfs(board,word,isVisited,ind+1,r+1,c)||
        dfs(board,word,isVisited,ind+1,r-1,c)||
        dfs(board,word,isVisited,ind+1,r+1,c+1)||
        dfs(board,word,isVisited,ind+1,r-1,c+1)||
        dfs(board,word,isVisited,ind+1,r+1,c-1)||
        dfs(board,word,isVisited,ind+1,r-1,c-1)){
            return true;
        }
        isVisited[r][c] = false;
    }
    return false;
}

bool exists(vector<vector<char>> &board, string word)
{
    vector<vector<bool>> isVisited(board.size(), (vector<bool>(board[0].size(), false)));
    for (int i = 0; i < board.size(); i++)
    {
        for (int j = 0; j < board[0].size(); j++)
        {
            if (word[0] == board[i][j])
            {
                if (dfs(board, word, isVisited, 0, i, j) == true)
                {
                    return true;
                }
            }
        }
    }
    return false;
}

vector<string> wordBoggle(vector<vector<char>> board, vector<string> dictionary)
{
    vector<string> res;
    for (int i = 0; i < dictionary.size(); i++)
    {
        if (exists(board, dictionary[i]) == true)
        {
            res.push_back(dictionary[i]);
        }
    }
    return res;
}

int main()
{
    vector<string> dictionary = {"GEEKS", "FOR", "QUIZ", "GIT"};
    vector<vector<char>> board = {{'G', 'I', 'Z'},
                                  {'U', 'E', 'K'},
                                  {'Q', 'S', 'E'}};
    vector<string> res = wordBoggle(board, dictionary);
    for (int i = 0; i < res.size(); i++)
    {
        cout << res[i] << " ";
    }
    return 0;
}