import java.util.Arrays;
import java.util.Random;

//(Дополнительно) Реализовать алгоритм сортировки слиянием

public class MergeSort {

    public static void main(String[] args) {
        int[] array = generateRandomArray(100, 0, 1000);
        System.out.println(Arrays.toString(array));
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void mergeSort(int[] array) {
        if (array.length < 2) {
            return;
        }

        int middle = array.length / 2;
        int[] leftPart = new int[middle];
        int[] rightPart = new int[array.length - middle];

        System.arraycopy(array, 0, leftPart, 0, leftPart.length);
        System.arraycopy(array, middle, rightPart, 0, rightPart.length);

        mergeSort(leftPart);
        mergeSort(rightPart);

        merge(array, leftPart, rightPart);
    }

    public static void merge(int[] array, int[] leftPart, int[] rightPart) {
        int i = 0, j = 0, k = 0;

        while (i < leftPart.length && j < rightPart.length) {
            if (leftPart[i] <= rightPart[j]) {
                array[k] = leftPart[i];
                i++;
            } else {
                array[k] = rightPart[j];
                j++;
            }
            k++;
        }

        while (i < leftPart.length) {
            array[k] = leftPart[i];
            i++;
            k++;
        }

        while (j < rightPart.length) {
            array[k] = rightPart[j];
            j++;
            k++;
        }
    }

    public static int[] generateRandomArray(int length, int min, int max) {
        int[] array = new int[length];
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(min, max);
        }

        return array;
    }
}
