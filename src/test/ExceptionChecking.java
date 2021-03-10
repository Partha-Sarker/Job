package test;

public class ExceptionChecking {
    public static void main(String[] args) {
        try {
            try {
                throw new ArithmeticException();
            } catch (ArithmeticException e) {
                System.out.println("inside catch");
            } finally {
                System.out.println("inside finally");
            }
        } catch (ArithmeticException e) {
            System.out.println("outside catch");
        } finally {
            System.out.println("outside finally");
        }
    }
}
