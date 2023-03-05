//Вычислить n-ое треугольного число(сумма чисел от 1 до n), а так же n! (произведение чисел от 1 до n)

import java.util.Scanner;

// Ввод:5
// Треугольное число 1 + 2 + 3 + 4 + 5 = 15
// n! 1 * 2 * 3 * 4 * 5 = 120
public class TriangularNumberAndFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число: ");
        int number = scanner.nextInt();
        printResult(number);
    }

    public static long getTriangularNumber(int number) {
        long triangularNumber = 0;

        for (int i = 1; i <= number; i++) {
            triangularNumber += i;
        }

        return triangularNumber;
    }

    public static double getFactorial(int number) {
        double factorial = 1;

        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }

        return factorial;
    }

    public static void printResult(int number) {
        System.out.printf("Треугольное число: %d\n%d! = %.0f", getTriangularNumber(number), number, getFactorial(number));
    }
}
