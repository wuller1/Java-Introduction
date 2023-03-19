//Реализуйте очередь с помощью LinkedList со следующими методами:
//enqueue() - помещает элемент в конец очереди,
//dequeue() - возвращает первый элемент из очереди и удаляет его,
//first() - возвращает первый элемент из очереди, не удаляя.

import java.util.LinkedList;
import java.util.Scanner;

public class LinkedListQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedList<String> queue = new LinkedList<>();

        while (true) {
            System.out.print("""
                    _________________________________________________________
                   | Enter 1 to add element to the end of queue              |
                   | Enter 2 to return the first element and delete it       |
                   | Enter 3 to return the first element without deleting it |
                   | Enter 4 to view the contents of the queue               |
                   | Enter exit to exit the program                          |
                   | ________________________________________________________|
                    >\s\s""");

            String option = scanner.nextLine();

            switch (option) {
                case "1" -> {
                    System.out.println("Enter element you want to add to the end of queue: ");
                    System.out.print(">  ");
                    String item = scanner.nextLine();
                    enqueue(queue, item);
                }
                case "2" -> {
                    System.out.println(dequeue(queue));
                }
                case "3" -> {
                    System.out.println(first(queue));
                }
                case "4" -> {
                    System.out.println(queue);
                }
                case "exit" -> {return;}
                default -> {
                    System.out.println("Invalid option, please try again");
                }
            }
        }
    }

    public static void enqueue(LinkedList<String> queue, String item) {
        queue.add(queue.size(), item);
    }

    public static String dequeue(LinkedList<String> queue) {
        String element = queue.getFirst();
        queue.remove(0);
        return element;
    }

    public static String first(LinkedList<String> queue) {
        return queue.getFirst();
    }

}
