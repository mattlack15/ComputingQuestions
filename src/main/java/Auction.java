import java.util.Scanner;

public class Auction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int am = scanner.nextInt();
        scanner.nextLine();

        int bidHigh = Integer.MIN_VALUE;
        String bidName = null;

        for (int i = 0; i < am; i++) {
            String name = scanner.nextLine();
            int bid = scanner.nextInt();
            scanner.nextLine();

            if(bid > bidHigh) {
                bidHigh = bid;
                bidName = name;
            }
        }

        scanner.close();

        System.out.println(bidName);
    }
}
