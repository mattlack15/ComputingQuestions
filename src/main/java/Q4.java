import java.util.Scanner;

public class Q4 {

    private static class IntList {
        public int[] arr = new int[2];
        public int start = 0;
        public int end = 0;

        public IntList(int size) {
            arr = new int[size];
        }

        public void add(int num) {
            if (end + 1 > arr.length) {
                resize(arr.length << 1);
            }
            arr[end++] = num;
        }

        private void resize(int capacity) {
            int[] newArr = new int[capacity];

            System.arraycopy(arr, start, newArr, 0, end - start);
            arr = newArr;

            end -= start;
            start = 0;
        }

        public int get(int index) {
            return arr[start + index];
        }

        public int removeFirst() {
            return arr[start++];
        }

        public int size() {
            return end - start;
        }
    }

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

        System.out.println(unsorted.length);

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
