import java.util.Arrays;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {

        testAllSortingAlgorithms(10, 250);
        testAllSortingAlgorithms(20, 100);
        testAllSortingAlgorithms(50, 25);
        testAllSortingAlgorithms(500, 5);
        testAllSortingAlgorithms(5000, 1);
        testAllSortingAlgorithms(50000, 1);

    }

    private static void testAllSortingAlgorithms(int arrayLength, int sampleSize) {
        System.out.println("Testing BubbleSort for n = " + arrayLength);
        testSortingAlgorithm(SortingMachine::bubbleSort, arrayLength, sampleSize);

        if (arrayLength < 10000) {
            System.out.println("Testing CubeSort for n = " + arrayLength);
            testSortingAlgorithm(SortingMachine::cubeSort, arrayLength, sampleSize);
        } else {
            System.out.println("Testing CubeSort would take way too long for n = " + arrayLength);
            System.out.println();
        }

        if (arrayLength < 30) {
            System.out.println("Testing ExpoSort for n = " + arrayLength);
            testSortingAlgorithm(SortingMachine::expoSort, arrayLength, sampleSize);
        } else {
            System.out.println("Testing ExpoSort would take way too long for n = " + arrayLength);
            System.out.println();
        }

        System.out.println();
    }

    private static void testSortingAlgorithm(Consumer<Integer[]> function , int arrayLength, int sampleSize) {
        // run method(s) once for caching reasons (at least I guess that this is the reason why the first call always takes way longer)
        Timer.timeOnce(function, SortingMachine.getRandomIntegerArray(arrayLength));

        // collect timing samples
        long[] samples = new long[sampleSize];
        for (int i = 0; i < sampleSize; i++) {
            samples[i] = Timer.timeOnce(function, SortingMachine.getRandomIntegerArray(arrayLength));
        }
        long sampleAverage = Arrays.stream(samples).sum() / sampleSize;

        // print samples (in ns and another time unit)
        System.out.println("Average of " + sampleSize + " [ns]: " + sampleAverage);
        if (sampleAverage < 10 * Math.pow(1000, 2)) {
            System.out.println("Average of " + sampleSize + " [µs]: " + sampleAverage / Math.pow(1000, 1));
        } else if (sampleAverage < 10 * Math.pow(1000, 3)) {
            System.out.println("Average of " + sampleSize + " [ms]: " + sampleAverage / Math.pow(1000, 2));
        } else {
            System.out.println("Average of " + sampleSize + "  [s]: " + sampleAverage / Math.pow(1000, 3));
        }
        System.out.println();

    }

}