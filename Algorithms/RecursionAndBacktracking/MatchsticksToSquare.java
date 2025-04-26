package Algorithms.RecursionAndBacktracking;

public class MatchsticksToSquare {
    public boolean helper(int[] matchsticks, int ind, int sides, boolean[] visited, int currentSideLength, int targetLength){
        if(sides == 0){
            //all sides formed, return true
            return true;
        }
        if(currentSideLength == targetLength){
            //we found one side, recurse for other sides
            return helper(matchsticks, 0, sides - 1, visited, 0, targetLength);
        }

        //we start from ind as we have visited previous indices already
        for(int i = ind; i < matchsticks.length; i++){
            if(visited[i] || currentSideLength + matchsticks[i] > targetLength){
                continue;
            }

            visited[i] = true;
            if(helper(matchsticks, i + 1, sides, visited, currentSideLength + matchsticks[i], targetLength)){
                return true;
            }
            visited[i] = false;
        }

        return false;
    }
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for(int i: matchsticks){
            sum += i;
        }
        if(sum % 4 != 0){
            return false;
        }
        int targetLength = sum / 4;
        boolean[] visited = new boolean[matchsticks.length];
        return helper(matchsticks, 0, 4, visited, 0, targetLength);
    }
    public static void main(String[] args) {

    }
}
