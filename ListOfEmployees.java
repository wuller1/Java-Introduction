import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

//Написать программу, которая найдет и выведет повторяющиеся
//имена с количеством повторений.
//Отсортировать по убыванию популярности Имени.
public class ListOfEmployees {
    public static void main(String[] args) {
        String[] arrayOfEmployees = {
                "Иван Иванов",
                "Светлана Петрова",
                "Кристина Белова",
                "Анна Мусина",
                "Анна Крутова",
                "Иван Юрин",
                "Петр Лыков",
                "Павел Чернов",
                "Петр Чернышов",
                "Мария Федорова",
                "Марина Светлова",
                "Мария Савина",
                "Мария Рыкова",
                "Марина Лугова",
                "Анна Владимирова",
                "Иван Мечников",
                "Петр Петин",
                "Иван Ежов"
        };

        HashMap<String, Integer> frequencyOfEmployeesNames = getNamesFrequency(arrayOfEmployees);
        printSortedEmployeesNamesFrequencies(frequencyOfEmployeesNames);
    }

    public static HashMap<String, Integer> getNamesFrequency(String[] arrayOfEmployees) {
        HashMap<String, Integer> frequencyOfEmployeesNames = new HashMap<>();

        for (String employee : arrayOfEmployees) {
            String[] employeeFullNameArray = employee.split(" ");
            String name = employeeFullNameArray[0];
            String surname = employeeFullNameArray[1];

            if (!frequencyOfEmployeesNames.containsKey(name)) {
                frequencyOfEmployeesNames.put(name, 1);
            } else {
                frequencyOfEmployeesNames.put(name, frequencyOfEmployeesNames.get(name) + 1);
            }
        }

        return frequencyOfEmployeesNames;
    }

    public static void printSortedEmployeesNamesFrequencies(HashMap<String, Integer> frequencyOfEmployeesNames) {
        ArrayList<String> arrayList = new ArrayList<>();
        StringBuilder builder = new StringBuilder();

        for (Map.Entry<String, Integer> entry : frequencyOfEmployeesNames.entrySet()) {
            if (entry.getValue() > 1) {
                arrayList.add("%d раза - %s".formatted(entry.getValue(), entry.getKey()));
            }
        }

        arrayList.sort(Collections.reverseOrder());

        for (String line : arrayList) {
            builder.append(line).append("\n");
        }

        System.out.println(builder);
    }
}
