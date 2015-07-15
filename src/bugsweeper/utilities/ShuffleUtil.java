package bugsweeper.utilities;

import java.util.List;
import java.util.Random;

/**
 * Created by snyder on 2015-07-15.
 */
public class ShuffleUtil {
    private static Random random = new Random();

    public static <T> void shuffle(List<T> array) {
        for (int i = array.size(); i > 1; i--) {
            swap(array, i - 1, random.nextInt(i));
        }
    }

    private static <T> void swap(List<T> array, int i, int j) {
        T temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }

    public static <T> void shuffle(T[] array) {
        for (int i = array.length; i > 1; i--) {
            swap(array, i - 1, random.nextInt(i));
        }
    }

    private static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
