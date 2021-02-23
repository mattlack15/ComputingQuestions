import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CCC2021J3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> nums = new ArrayList<>(10000);

        while(true) {
            int num = scanner.nextInt();
            if(num == 99999)
                break;
            nums.add(num);
        }

        scanner.close();

        int dir = 0; // 0 - left 1 - right

        for (int num : nums) {
            int s = (num / 1000 % 10 + num / 10000 % 10);
            int ss = s;
            s %= 2;
            if(s == 1) {
                dir = 0;
            } else if (s == 0 && ss != 0) {
                dir = 1;
            }

            int steps = num % 1000;

            if(dir == 1) {
                System.out.println("right " + steps);
            } else {
                System.out.println("left " + steps);
            }
        }
    }
}
