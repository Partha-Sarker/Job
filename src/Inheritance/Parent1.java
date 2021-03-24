package Inheritance;

public class Parent1 {
    int parent1Field;

    public Parent1(int parent1Field) {
        this.parent1Field = parent1Field;
    }

    public static void main(String[] args) {
        Parent1 p1 = new Parent1(1);
        Parent1 p2 = new Child1(1);
        Parent1 p3 = new Child2(1);
        Child1 c1 = new Child1(1);
        Child1 c2 = new Child2(1);
        Child2 c21 = new Child2(1);
        System.out.println(c21 instanceof Parent1);
    }
}
