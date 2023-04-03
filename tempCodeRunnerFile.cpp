class Solution {
public:
    void solve(vector<int> cand, int target, vector<vector<int>> &res, int ind, vector<int> curr, int currSum){
        
        if(ind == cand.size()){
            if(currSum == target){
                res.push_back(curr);
            }
            return;
        }
        if(currSum > target){
            return;
        }
        if(cand[ind] <= target){
            curr.push_back(cand[ind]);
            solve(cand, target, res, ind, curr, currSum + cand[ind]);
            curr.pop_back();
        }
        solve(cand, target, res, ind + 1, curr, currSum);
    }

    //Not taking this element
            solve(cand, target, res, ind + 1, curr, currSum);
            //Take this element again
            curr.push_back(cand[ind]);
            solve(cand, target, res, ind, curr, currSum + cand[ind]);
        //Take the next element
        solve(cand, target, res, ind + 1, curr, currSum + cand[ind]);

    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<vector<int>> res;
        int currS = 0;
        vector<int> curr;
        solve(candidates, target, res, 0, curr, currS);
        // vector<vector<int>> ans;
        // for(int i = 0; i < res.size(); i++){
        //     if(find(ans.begin(), ans.end(), res[i]) == ans.end()){
        //         ans.push_back(res[i]);
        //     }
        // }
        return res;
    }
};