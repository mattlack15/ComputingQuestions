import java.util.Arrays;

public class TwoSum {

    public static void main(String[] args) {
        

    }

    public static int[] twoSum(int[] arr, int target) {

        //Find two numbers in arr that add up to target. in O(n) time.
        Arrays.sort(arr);

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                return new int[] {arr[left], arr[right]};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[] {-1, -1};

    }
}
