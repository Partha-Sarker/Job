package numbersystem;

public class PermutationCombination {
    public static void main(String[] args) {
//        System.out.println(nPr(5, 3));
//        System.out.println(factorial(0));
//        System.out.println(nCr(5, 3));
        System.out.println(nCrV2(5, 3));
    }

    public static int nPr(int n, int r) {
        if (r > n)
            return -1;
        if (r == 1)
            return n;
        return n * nPr(n - 1, r - 1);
    }

    public static int factorial(int n) {
        if (n < 0)
            return -1;
        if (n == 0)
            return 1;
        return n * factorial(n - 1);
    }

    public static int nCr(int n, int r) {
        return nPr(n, r) / factorial(r);
    }

    public static int nCrV2(int n, int r) {
        if (r > n)
            return -1;
        if (r == n || r == 0)
            return 1;
        return nCrV2(n - 1, r - 1) + nCrV2(n - 1, r);
    }
}
