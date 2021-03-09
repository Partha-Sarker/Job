package Inheritance;

public class Child1 extends Parent1{
    public static void main(String[] args) {

    }

    // you will get error if you don't call super constructor
    public Child1(int a) {
        super(a);
    }
}
