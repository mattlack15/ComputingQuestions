import java.util.Scanner;

public class S2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int[] primes = new int[1414];
        boolean[] primeSet = new boolean[1414];

        // Compute all primes up to 1414.
        int count = 0;
        for (int i = 2; i <= 1414; i++) {
            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes[count] = i;
                primeSet[i] = true;
                count++;
            }
        }

        int[] arr = new int[count];
        System.arraycopy(primes, 0, arr, 0, count);
        primes = arr;

        int target = num * 2;
        // Find two primes that multiply to the target.
        int left = 0;
        int right = count - 1;
        while (left < right) {
            int sum = primes[left] + primes[right];
            if (sum == target) {
                System.out.println(primes[left] + " " + primes[right]);
                break;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println("Ended.");
    }
}
