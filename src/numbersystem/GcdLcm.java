package numbersystem;

public class GcdLcm {
    public static void main(String[] args) {
//        System.out.println(getGCD(9, 17));
        System.out.println(getLCM(4, 6));
    }

    public static int getGCD(int a, int b) {
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        if (a == 0)
            return b;
        return getGCD(b % a, a);
    }

    public static int getLCM(int a, int b) {
        return (a * b) / getGCD(a, b);
    }
}
