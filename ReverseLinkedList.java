//Пусть дан LinkedList с несколькими элементами. Реализуйте метод(не void), который вернет “перевернутый” список.


import java.util.LinkedList;
import java.util.Random;

public class ReverseLinkedList {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = generateLinkedlist(10, 0, 100);
        System.out.println(linkedList);
        LinkedList<Integer> reversedLinkedList = reverseLinkedList(linkedList);
        System.out.println(reversedLinkedList);
    }
    public static LinkedList<Integer> reverseLinkedList(LinkedList<Integer> linkedList) {
        LinkedList<Integer> reversedLinkedList = new LinkedList<>();

        for (int i = 0; i < linkedList.size(); i++) {
            reversedLinkedList.add(i, linkedList.get(linkedList.size() - 1 - i));
        }

        return reversedLinkedList;
    }

    public static LinkedList<Integer> generateLinkedlist(int length, int min, int max) {
        Random random = new Random();
        LinkedList<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < length; i++) {
            linkedList.add(i, random.nextInt(min, max));
        }

        return linkedList;
    }
}
