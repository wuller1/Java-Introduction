import java.io.IOException;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

// Реализуйте алгоритм сортировки пузырьком числового массива (введён вами),
// результат после каждой итерации запишите в лог-файл.
public class BubbleSort {
    public static void main(String[] args) {
        int[] numbers = {1, 10, 32, 9, 3, 6, 18};
        bubbleSort(numbers);
    }

    public static void bubbleSort(int[] numbers) {

        Logger logger = Logger.getLogger(BubbleSort.class.getName());
        try {
            FileHandler fh = new FileHandler("bubbleSortLog.txt");
            logger.addHandler(fh);
            SimpleFormatter sf = new SimpleFormatter();
            fh.setFormatter(sf);
        } catch (IOException e) {
            System.out.println("Exception");
        }

        logger.info(Arrays.toString(numbers));


        while (true) {
            boolean sorted = true;
            int temp;

            for (int i = 0; i < numbers.length - 1; i++) {
                if (numbers[i] > numbers[i + 1]) {
                    sorted = false;
                    temp = numbers[i];
                    numbers[i] = numbers[i + 1];
                    numbers[i + 1] = temp;
                    logger.info(Arrays.toString(numbers));
                }
            }

            if (sorted) {
                break;
            }
        }
    }
}
