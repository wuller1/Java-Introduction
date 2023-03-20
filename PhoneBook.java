import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

//Реализуйте структуру телефонной книги с помощью HashMap, учитывая,
//что 1 человек может иметь несколько телефонов.
//Добавить функции 1) Добавление номера
//2) Вывод всего
//Пример:
//Я ввожу: 1
//К: Введите фамилию
//Я: Иванов
//К: Введите номер
//Я: 1242353
//К: Введите 1) Добавление номера
//2) Вывод всего
//Я ввожу: 1
//К: Введите фамилию
//Я: Иванов
//К: Введите номер
//Я: 547568
//К: Введите 1) Добавление номера
//2) Вывод всего
//Я: 2
//Иванов: 1242353, 547568
public class PhoneBook {
    public static void main(String[] args) {
        runUI();
    }

    public static void addEntryToPhonebook(HashMap<String, ArrayList<String>> phonebook, String surname, String phoneNumber) {
        if (!phonebook.containsKey(surname)) {
            phonebook.put(surname, new ArrayList<String>());
        }

        phonebook.get(surname).add(phoneNumber);
    }

    public static void runUI() {
        HashMap<String, ArrayList<String>> phoneBook = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.print("""
                
                 _______________________________________________
                | Enter the action:                             |
                | 1 - to add new number                         |
                | 2 - to show all phonebook entries             |
                | exit - to stop the execution of the program   |
                |_______________________________________________|
                
                >\s\s""");

            String action = scanner.next();

            if (action.equalsIgnoreCase("exit")) {
                break;
            }

            switch (action) {
                case "1" -> {
                    System.out.print("Enter the surname: \n>  ");
                    String surname = scanner.next();
                    System.out.print("Enter the phone number you want to add: \n>  ");
                    String phoneNumber = scanner.next();
                    addEntryToPhonebook(phoneBook, surname, phoneNumber);
                }
                case "2" -> {
                    System.out.println("Phonebook entries:");
                    phoneBook.forEach((surname, phoneNumbers) -> {
                        StringBuilder phoneNumbersBuilder = new StringBuilder(phoneNumbers.toString());
                        phoneNumbersBuilder
                                .replace(0, 1, "")
                                .replace(phoneNumbersBuilder.length() - 1, phoneNumbersBuilder.length(), "");
                        System.out.printf("%s: %s\n", surname, phoneNumbersBuilder);
                    });
                }
                default -> {}
            }
        }
    }
}
