package numbersystem;

import java.util.List;

public class Miscellaneous {
    public static void main(String[] args) {
        System.out.println(isPowerOf2V2(1024));
        printAllPrime(100);
//        System.out.println(isPrime(49));
    }

    public static boolean isPowerOf2(int num) {
        while (num > 1) {
            int remainder = num % 2;
            if (remainder == 1)
                return false;
            num /= 2;
        }
        return true;
    }

    public static boolean isPowerOf2V2(int num) {
        if (num < 1)
            return false;
        if (num == 1)
            return true;
        if (num % 2 == 1)
            return false;
        return isPowerOf2(num / 2);
    }

    public static void printAllPrime(int num) {
        boolean primeArray[] = new boolean[num + 1];
        for (int i = 2; i < primeArray.length; i++) primeArray[i] = true;
        primeArray[0] = false;
        primeArray[1] = false;
        for (int i = 2; i * i <= num; i++) {
            if (primeArray[i]) {
                for (int j = i * i; j <= num; j += i) {
                    primeArray[j] = false;
                }
            }
        }
        for (int i = 2; i <= num; i++) {
            if (primeArray[i])
                System.out.print(i + " ");
        }
        System.out.println();
    }

    public static boolean isPrime(int num) {
        if (num <= 1)
            return false;
        if (num <= 3)
            return true;
        if (num % 2 == 0)
            return false;
        for (int i = 5; i * i <= num; i += 2) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}
