package Algorithms.Recursion;

public class TowerOfHanoi {
    static int steps = 0;
    public static void helper(int n, int A, int C, int B){
        if(n > 0){
            helper(n - 1, A, B, C);
            System.out.println("move disk " + n + " from rod "+ A +" to rod " + C);
            steps++;
            helper(n - 1, B, C, A);
        }
    }

    public int towerOfHanoi(int n, int A, int C, int B) {
        helper(n, A, C, B);

        return steps;
    }
    public static void main(String[] args) {
        TowerOfHanoi toh = new TowerOfHanoi();
        System.out.println(toh.towerOfHanoi(2, 1, 3, 2));
    }
}
