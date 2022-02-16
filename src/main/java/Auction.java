import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Auction {
    public static void main1(String[] args) {
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

    public static void match(String input) {
        //Every 1st line in input is a name (string) and every 2nd line in input is a bid (int), print the highest bidder and their bid.
        Scanner reader = new Scanner(input);
        String currentName = reader.next();
        int currentBid = reader.nextInt();
        while (reader.hasNext()) {
            String nextName = reader.next();
            int nextBid = reader.nextInt();
            if (nextBid > currentBid) {
                currentName = nextName;
                currentBid = nextBid;
            }
        }
        reader.close();
        System.out.println(currentName + " is the highest bidder with a bid of " + currentBid);
    }

    public static void main(String[] args) {
        int[] arr = new int[100000000];

        for (int i = 0; i < 100000000; i++) {
            arr[i] = (int) (Math.random() * 100000);
        }

        Arrays.sort(arr);

        long ms = System.currentTimeMillis();

        for (int i = 0; i < 100000000; i++) {
            int searchFor = 99999;
            if (arr[i] == searchFor) {
                System.out.println("Found it!");
                break;
            }
        }
        ms = System.currentTimeMillis() - ms;


        System.out.println("Linear search took " + ms + "ms.");

        // Binary search.
        ms = System.currentTimeMillis();
        int index = Arrays.binarySearch(arr, 19023);
        System.out.println("Binary search took " + (System.currentTimeMillis() - ms) + "ms.");
    }
}
