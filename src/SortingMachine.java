import java.util.Random;

public class SortingMachine {

    private static void swap(Integer[] array, int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

    public static Integer[] getRandomIntegerArray(int size) {
        Random random = new Random();
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(1000);
        }
        return array;
    }

    public static void bubbleSort(Integer[] array) {
        // TODO: implement algorithm
    }

    public static void cubeSort(Integer[] array) {
        cubeSort(array, array.length - 1);
    }

    private static void cubeSort(Integer[] array, int to) {
        if (to > 0) {
            cubeSort(array, to - 1);
            if (array[to - 1] > array[to]) {
                swap(array, to - 1, to);
                cubeSort(array, to - 1);
            }
        }
    }

    public static void expoSort(Integer[] array) {
        expoSort(array, array.length - 1);
    }

    private static void expoSort(Integer[] array, int to) {
        if (to > 0) {
            expoSort(array, to - 1);
            if (array[to - 1] > array[to]) {
                swap(array, to - 1, to);
            }
            expoSort(array, to - 1);
        }
    }

}
