import java.util.Scanner;

public class CCC2021J4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();

        char[] unsorted = s.toCharArray();

        int numL = 0, numM = 0;

        for (int i = 0; i < unsorted.length; i++) {
            if (unsorted[i] == 'L') {
                numL++;
            } else if (unsorted[i] == 'M') {
                numM++;
            }
        }

        int swaps = 0;
        int mInL = 0;
        int lInM = 0;

        for (int i = 0; i < unsorted.length; i++) {
            if(i < numL) {
                if (unsorted[i] != 'L') {
                    swaps++;
                    if(unsorted[i] == 'M') {
                        mInL++;
                    }
                }
            } else if(i < numM + numL) {
                if (unsorted[i] != 'M') {
                    swaps++;
                    if(unsorted[i] == 'L') {
                        lInM++;
                    }
                }
            }
        }
        swaps -= Math.min(lInM, mInL);

        System.out.println(swaps);
    }
}
