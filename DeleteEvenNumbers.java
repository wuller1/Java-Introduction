//Пусть дан произвольный список целых чисел, удалить из него чётные числа

import java.util.ArrayList;
import java.util.Random;

public class DeleteEvenNumbers {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = generateRandomArrayList(100, 0, 1000);
        System.out.println(arrayList.toString());
        deleteEvenNumbersFromArrayList(arrayList);
        System.out.println(arrayList.toString());
    }

    public static void deleteEvenNumbersFromArrayList(ArrayList<Integer> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) % 2 == 0) {
                arrayList.remove(i);
                i--;
            }
        }
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
