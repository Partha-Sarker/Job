package numbersystem;

public class PrimeFactorization {
    public static void main(String[] args) {
        printPrimeFactors(210);
    }

    public static void printPrimeFactors(int num) {
        int recentPrime = 0;
        while (num % 2 == 0) {
            if (recentPrime != 2) {
                System.out.println(2 + " ");
                recentPrime = 2;
            }
            num /= 2;
        }
        for (int i = 3; i * i <= num; i += 2) {
            while (num % i == 0) {
                if (recentPrime != i) {
                    System.out.println(i + " ");
                    recentPrime = i;
                }
                num /= i;
            }
        }
        if (num > 2)
            System.out.println(num);
    }

    static void printPrimeFactorsV2(int num) {

    }

    private static void sieve() {

    }
}
