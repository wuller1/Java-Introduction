import java.util.Scanner;

//Реализовать простой калькулятор (+ - / *)
//        Ввод числа ->
//        Ввод знака ->
//        Ввод числа ->
public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        double number1 = scanner.nextDouble();
        System.out.println("Введите оператор (+ - / *): ");
        char operator = scanner.next().charAt(0);
        System.out.println("Введите число: ");
        double number2 = scanner.nextDouble();
        System.out.printf("%.2f %c %.2f = %.2f", number1, operator, number2, calculate(number1, number2, operator));
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
}
