package JavaBasics;

//Arrays are not dynamic in Java

public class Arrays {
    public static void main(String[] args) {
        int[] nums = {10, 20, 30, 40, 50};
        int[] squares = new int[5];

        for(int i = 0; i < nums.length; i++){
            squares[i] = nums[i] * nums[i];
        }
        System.out.print("Nums array is : ");
        for(int i : nums){
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.print("Squares array is : ");
        for(int i = 0; i < squares.length; i++){
            System.out.print(squares[i] + " ");
        }


    }
}
