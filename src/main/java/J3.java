import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int numSensors = input.nextInt();

        int[] frequencies = new int[1000];

        for (int i = 0; i < numSensors; i++) {
            int reading = input.nextInt();
            frequencies[reading]++;
        }

        // Find the top frequency.
        int topFreq = 0; // EDIT: This is now the actual top frequency instead of (previously) the index of the top frequency.
        for (int i = 0; i < frequencies.length; i++) {
            if (frequencies[i] > topFreq) {
                topFreq = frequencies[i];
            }
        }

        // Find the 2nd top frequency.
        int secondTopFreq = 0;
        for (int i = 0; i < frequencies.length; i++) {
            if (frequencies[i] > secondTopFreq && frequencies[i] < topFreq) {
                secondTopFreq = frequencies[i];
            }
        }

        List<Integer> topReadings = new ArrayList<>();

        // Add the readings (indexes) that have the top frequency.
        for (int i = 0; i < frequencies.length; i++) {
            if (frequencies[i] == topFreq) {
                topReadings.add(i);
            }
        }

        List<Integer> secondTopReadings = new ArrayList<>();

        // Add the readings (indexes) that have the 2nd top frequency.
        for (int i = 0; i < frequencies.length; i++) {
            if (frequencies[i] == secondTopFreq) {
                secondTopReadings.add(i);
            }
        }

        // Find what combination of the top and 2nd top readings have the biggest absolute difference.
        int maxDiff = 0;
        for (int topReading : topReadings) {
            for (int secondTopReading : secondTopReadings) {
                int diff = Math.abs(topReading - secondTopReading);
                if (diff > maxDiff) {
                    maxDiff = diff;
                }
            }
        }

        // Print that out.
        System.out.println(maxDiff);
    }
}
