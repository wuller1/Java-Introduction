//Задано уравнение вида q + w = e, q, w, e >= 0.
//        Некоторые цифры могут быть заменены знаком вопроса, например 2? + ?5 = 69 (пользователь).
//        Требуется восстановить выражение до верного равенства.
//        Предложить хотя бы одно решение или сообщить, что его нет.
//        Ввод: 2? + ?5 = 69
//        Вывод: 24 + 45 = 69

import java.util.Scanner;

public class Equation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите уравнение: ");
        String equation = scanner.nextLine();
        String solvedEquation = solveEquation(equation);
        System.out.println(solvedEquation.equals("") ? "Решение не существует" : solvedEquation);
    }

    public static String solveEquation(String equation) {
        String[] equationArray = equation.split(" ");

        for (int i = 0; i < 10; i++) {
            int number1 = Integer.parseInt(equationArray[0].contains("?") ? equationArray[0].replaceAll("\\?", "%d".formatted(i)) : equationArray[0]);
            int number2 = Integer.parseInt(equationArray[2].contains("?") ? equationArray[2].replaceAll("\\?", "%d".formatted(i)) : equationArray[2]);
            int result = Integer.parseInt(equationArray[4].contains("?") ? equationArray[4].replaceAll("\\?", "%d".formatted(i)) : equationArray[4]);
            String operator = equationArray[1];

            if (calculate(number1, number2, operator) == result) {
                return "%d %s %d = %d".formatted(number1, operator, number2, result);
            }
        }

        return "";
    }

    public static double calculate(double number1, double number2, String operator) {
        return switch (operator) {
            case "+" -> number1 + number2;
            case "-" -> number1 - number2;
            case "/" -> number1 / (double) number2;
            case "*" -> number1 * number2;
            default -> -1;
        };
    }
}
