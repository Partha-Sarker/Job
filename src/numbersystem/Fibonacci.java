package numbersystem;

public class Fibonacci {
    static long[] array;

    public static void main(String[] args) {
        System.out.println(getFibNum(5));
    }

    public static long getFibonacciNumberRecursive(int n) {
        array = new long[n + 1];
        return fibonacci(n);
    }

    public static int getFibNum(int n) {
        if (n == 0)
            return 0;
        int first = 0, second = 1, temp;
        while (n - 1 > 0) {
            temp = second;
            second = first + second;
            first = temp;
            n--;
        }
        return second;
    }

    public static long[] getFibonacciSeriesBottomUp(int n) {
        if (n == 0) {
            long[] fibArray = {0};
            return fibArray;
        }
        long[] fibArray = new long[n + 1];
        fibArray[0] = 0;
        fibArray[1] = 1;
        for (int i = 2; i <= n; i++)
            fibArray[i] = fibArray[i - 1] + fibArray[i - 2];
        return fibArray;
    }

    private static long fibonacci(int n) {
        if (array[n] != 0)
            return array[n];
        long result;
        if (n == 0)
            result = 0;
        else if (n == 1)
            result = 1;
        else
            result = fibonacci(n - 1) + fibonacci(n - 2);
        array[n] = result;
        return result;
    }
}
