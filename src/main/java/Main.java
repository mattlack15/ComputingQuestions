import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Get first part of input
        Scanner scanner = new Scanner(System.in);
        int numRows = scanner.nextInt();
        int numCols = scanner.nextInt();
        int am = scanner.nextInt();
        scanner.nextLine();

        //Create the two arrays for the state of each row and column
        byte[] rows = new byte[numRows];
        byte[] cols = new byte[numCols];

        for (int i = 0; i < am; i++) {
            String choice = scanner.next();
            int num = scanner.nextInt();
            scanner.nextLine();

            //Change the states by xor-ing them
            if(choice.equals("R")) {
                rows[num-1] ^= 1;
            } else if(choice.equals("C")) {
                cols[num-1] ^= 1;
            }
        }

        scanner.close();

        //Get the amount of 1's in each array
        int totalRow = sum(rows);
        int totalCol = sum(cols);

        //Calculate total
        int total = (totalRow * numCols) + (totalCol * numRows) -
                (totalRow * totalCol * 2);

        System.out.println(total);
    }

    public static int sum(byte[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
