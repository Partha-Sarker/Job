package test;

import sorting.BadSort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test{
    Test () {

    }
    static int test = 4;
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(11);
        list.remove(1);
        System.out.println(list.toString());
//        AbstractClass c1 = new AbstractClass(2);
    }

    private static int test() {
        return test++;
    }

    private static void stringTest(){
        String a = "abc";
        String b = "abc";
        if(a==b)
            System.out.println("a and b are equal!");
        a = "hello";
        printStuffs(a, b);
        String c = new String("hi");
        String d = new String("hi");
        if(c==d){
            System.out.println("c and d are equal");
        }
        b = a;
        a = "new";
        printStuffs(a, b);
        c = d;
        if(c==d)
            printStuffs("c equals d! yeee");
        c = "what";
        d = c;
        d = "why";
        printStuffs(c, d);

    }

    public static <T> void printStuffs(T... values){
        for (T val : values) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    private static void passByValRef(){
        Integer a = 10;
        int b = 2;
        passByRef(a);
        printStuffs(a);
        a = 20;
        b = 20;
        if(a==b)
            printStuffs("a equals b!");
        Integer c = new Integer(2);
        passByRef(c);
        printStuffs(c);
    }

    private static void passByRef(Integer a){
        a = 40;
    }

    private static void printDiamond(int n){ // 7
        int midIndex = (n % 2 == 1) ? n / 2 : n / 2 - 1; // 3
        int maxLength = midIndex * 2 + 1; // 7

        for (int i = 0; i < n; i++) { // i = 3
            int starSize;
            if (i < n / 2)
                starSize = 1 + (i * 2); //7
            else
                starSize = 1 + ((n - i - 1) * 2); //
            int startStarIndex = (maxLength / 2) - starSize / 2; //  aa***aa, 2
            int endStarIndex = startStarIndex + starSize; // 5
            for (int j = 0; j < maxLength; j++) {
                if (j >= startStarIndex && j < endStarIndex)
                    System.out.print('*');
                else
                    System.out.print(' ');
            }
            System.out.println();
        }
    }

    private static void changeArray(int[] arr) {
        arr[0] = 9999;
    }

    private static void changeList(List<Integer> list) {
        list.set(0, 9999);
    }
}

class A extends Super{
    int a;
    A (int a) {
        this.a = a;
    }
}

class B extends Super{
    int a;
    B (int a) {
        this.a = a;
    }
}

class Super {
    int sup;
    public void printHi() {
        System.out.println("Hi...");
    }
}

interface IA {
    void hello();
    default int hi(int a) {
        return 2;
    }
}

abstract class AbstractClass {
    int param;
    AbstractClass(int p) {
        param = p;
    }

    public String hello() {
        return " ";
    }
}