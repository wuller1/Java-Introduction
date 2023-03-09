import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

//3*дополнительно. К калькулятору из предыдущего дз добавить логирование.
//        1 + 3 = 4
//        4 + 3 = 7
public class CalculatorWithLogger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        double number1 = scanner.nextDouble();
        System.out.println("Введите оператор (+ - / *): ");
        char operator = scanner.next().charAt(0);
        System.out.println("Введите число: ");
        double number2 = scanner.nextDouble();
        writeToLog("%.2f %c %.2f = %.2f".formatted(number1, operator, number2, calculate(number1, number2, operator)));
    }

    public static double calculate(double number1, double number2, char operator) {
        return switch (operator) {
            case '+' -> number1 + number2;
            case '-' -> number1 - number2;
            case '/' -> number1 / (double) number2;
            case '*' -> number1 * number2;
            default -> -1;
        };
    }

    public static void writeToLog(String textToLog) {
        SimpleFormatter sf = new SimpleFormatter();
        Logger logger = Logger.getLogger(CalculatorWithLogger.class.getName());
        logger.info(textToLog);
    }
}
