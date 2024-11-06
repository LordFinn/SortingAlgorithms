import java.util.Arrays;
import java.util.function.Consumer;

public class Timer {

    public static <T> long timeOnce(Consumer<T> function, T value) {
        long startTime = System.nanoTime();
        function.accept(value);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    // works, but not useful for testing sorting algorithms, since an array will be sorted after the first timing
    public static <T> long timeAverage(Consumer<T> function, T value, int howMany) {
        if (howMany < 1) {
            return 0;
        }
        long[] timings = new long[howMany];
        for (int i = 0; i < howMany; i++) {
            timings[i] = timeOnce(function, value);
        }
        return Arrays.stream(timings).sum() / howMany;
    }

}
