// 2. Вывести все простые числа от 1 до 1000

public class PrimeNumbers {
    public static void main(String[] args) {
        printPrimeNumbers(1, 1000);
    }

    public static boolean isPrime(int number) {
        if (number == 1 || number <= 0) return false;

        for (int i = 2; i < number; i++) {
            if (number % i == 0) return false;
        }

        return true;
    }

    public static void printPrimeNumbers(int minNumber, int maxNumber) {
        for (int i = minNumber; i <= maxNumber; i++) {
            if (isPrime(i)) {
                System.out.printf("%d ", i);
            }
        }
    }
}
