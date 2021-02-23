import java.util.Arrays;

public class LunchConcert {
    public static void main(String[] args) {

        double[][] arr = {{6, 8, 3}, {1, 4, 1}, {14, 5, 2}};

        double[][] original = new double[arr.length][];
        for (int i = 0; i < original.length; i++) {
            original[i] = Arrays.copyOf(arr[i], arr[i].length);
        }

        double weightedAvg = average(arr);
        System.out.println("First average: " + weightedAvg);

        for (int i = 0; i < arr.length; i++) {
            double a = arr[i][0];
            arr[i][0] += Math.signum(weightedAvg - arr[i][0]) * arr[i][2];
            System.out.println(": " + Arrays.toString(arr[i]) + " from " + a);
        }

        weightedAvg = average(arr);

        System.out.println(weightedAvg);

        int c = (int) Math.round(weightedAvg);

        int time = 0;

        for (int i = 0; i < original.length; i++) {
            int dist = (int) Math.abs(original[i][0] - c);
            System.out.println(i + " : " + original[i][0] + ", " + original[i][1] + ", " + original[i][2]);
            dist = (int) Math.max(0, dist - original[i][2]);
            time += dist * original[i][1];
        }

        System.out.println(time);
    }

    public static double average(double[][] arr) {
        double sum = 0;
        double weights = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i][0] * arr[i][1];
            weights += arr[i][1];
        }
        return sum / weights;
    }
}
