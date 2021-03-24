package enosis;

public class Stuffs {
    public static void main(String[] args) {
//        printWithRecursionDescending(10);
        printStringWithoutIndex("hello kitty", 12);
    }

    static void printWithRecursionAscending(int n) {
        if (n == 1) {
            System.out.print(n + " ");
            return;
        }
        printWithRecursionAscending(n - 1);
        System.out.print(n + " ");
    }

    static void printWithRecursionDescending(int n) {
        if (n == 0)
            return;
        System.out.print(n + " ");
        printWithRecursionDescending(n - 1);
    }

    static void printStringWithoutIndex(String s, int index) {
        try {
            String newString = s.substring(0, index) + s.substring(index + 1);
            System.out.println(newString);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println(s);
        }
    }
}
