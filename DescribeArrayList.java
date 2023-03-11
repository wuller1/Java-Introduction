import java.util.ArrayList;
import java.util.Random;

//Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее ариф. из этого списка.
public class DescribeArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = generateRandomArrayList(100, 0, 1000);
        describeArrayList(arrayList);
    }

    public static void describeArrayList(ArrayList<Integer> arrayList) {
        System.out.printf("Minimum value: %d\nMaximum value: %d\nMean value: %.2f\n",
                getMinValue(arrayList),
                getMaxValue(arrayList),
                getMean(arrayList));
    }

    public static double getMean(ArrayList<Integer> arrayList) {
        double sum = 0;

        for (int value : arrayList) {
            sum += value;
        }

        return sum / arrayList.size();
    }

    public static int getMinValue(ArrayList<Integer> arrayList) {
        int min = Integer.MAX_VALUE;

        for (int value : arrayList) {
            if (value < min) {
                min = value;
            }
        }

        return min;
    }

    public static int getMaxValue(ArrayList<Integer> arrayList) {
        int max = Integer.MIN_VALUE;

        for (int value : arrayList) {
            if (value > max) {
                max = value;
            }
        }

        return max;
    }

    public static ArrayList<Integer> generateRandomArrayList(int length, int min, int max) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            arrayList.add(random.nextInt(min, max));
        }

        return arrayList;
    }
}
