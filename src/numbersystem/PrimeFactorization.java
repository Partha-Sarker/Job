package numbersystem;

public class PrimeFactorization {
    public static void main(String[] args) {
        printPrimeFactors(210);
    }

    public static void printPrimeFactors(int num) {
        if (num % 2 == 0) {
            System.out.print(2 + " ");
            while (num % 2 == 0)
                num /= 2;
        }
        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) {
                System.out.print(i + " ");
                while (num % i == 0) {
                    num /= i;
                }
            }
        }
        if (num > 2)
            System.out.println(num);
    }
}
