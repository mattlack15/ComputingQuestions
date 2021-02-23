import java.util.Arrays;
import java.util.Scanner;

public class S32019 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] grid = new int[3][3];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                String x = scanner.next();
                if(x.equals("X")) {
                    grid[i][j] = Integer.MIN_VALUE;
                } else {
                    grid[i][j] = Integer.parseInt(x);
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == Integer.MIN_VALUE) {

                }
            }
        }

        scanner.close();
    }
}
