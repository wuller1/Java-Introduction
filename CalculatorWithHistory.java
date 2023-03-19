import java.util.LinkedList;
import java.util.Scanner;

// В калькулятор добавьте возможность отменить последнюю операцию.

public class CalculatorWithHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        runUI();
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

    public static void runUI() {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Double> history = new LinkedList<>();
        double number1;

        while(true) {
            if (history.isEmpty()) {
                System.out.print("Enter a number: ");
                number1 = scanner.nextDouble();
            } else {
                number1 = history.getLast();
            }

            System.out.print("Enter an operator (+, -, /, *): ");
            String operator = scanner.next();

            while (operator.equalsIgnoreCase("Cancel") && history.size() > 0) {
                removeFromHistory(history);
                number1 = history.getLast();
                System.out.printf("First number: %.2f\n", number1);
                System.out.print("Enter an operator (+, -, /, *), exit to close the program: ");
                operator = scanner.next();
            }

            if (operator.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.print("Enter a number: ");
            double number2 = scanner.nextDouble();

            double result = calculate(number1, number2, operator);
            history.add(result);

            System.out.printf("Result: %.2f\n", result);
        }
    }

    public static void removeFromHistory(LinkedList<Double> history) {
        if (history.size() > 0) {
            history.removeLast();
        }
    }
}
