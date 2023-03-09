import java.io.File;
import java.io.IOException;
import java.util.Scanner;

//    Дана строка (получение через обычный текстовый файл!!!)
//
//    "фамилия":"Иванов","оценка":"5","предмет":"Математика"
//    "фамилия":"Петрова","оценка":"4","предмет":"Информатика"
//
//    Написать метод(ы), который распарсит строку и, используя StringBuilder, создаст строки вида:
//    Студент [фамилия] получил [оценка] по предмету [предмет].
//
//    Пример вывода в консоль:
//    Студент Иванов получил 5 по предмету Математика.
//    Студент Петрова получил 4 по предмету Информатика.
//    Студент Краснов получил 5 по предмету Физика.
public class PrintDataFromTextDB {

    public static void main(String[] args) {
        String text = generateStringFromFile("db.txt");
        System.out.println(text);
    }

    public static String generateStringFromFile(String path) {
        File file = new File(path);
        StringBuilder builder = new StringBuilder();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(",");
                String surname = line[0].split(":")[1].replaceAll("\"", "");
                String mark = line[1].split(":")[1].replaceAll("\"", "");
                String subject = line[2].split(":")[1].replaceAll("\"", "");
                builder.append("Студент(ка) %s получил(а) %s по предмету %s\n".formatted(surname, mark, subject));
            }
        } catch (IOException e) {
            System.out.println("Something bad happened");
        }

        return builder.toString();
    }
}
