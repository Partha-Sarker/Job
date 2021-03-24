package test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Test {

    private static class Texts<T> {
        String s1, s2;

        Texts(String s1, String s2) {
            this.s1 = s1;
            this.s2 = s2;
        }

        @Override
        public int hashCode() {
            String newString = s1 + s2;
            return newString.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this)
                return true;
            if (!(obj instanceof Texts))
                return false;
            Texts thisObj = (Texts) obj;
            return thisObj.s1.equals(this.s1) && thisObj.s2.equals(this.s2);
        }

        @Override
        public String toString() {
            return s1 + " " + s2;
        }
    }

    public static void main(String[] args) {
//        Map<Texts, Integer> countMap = new HashMap<>();
//        countMap.put(new Texts("a", "b"), 2);
//        countMap.put(new Texts("a", "b"), 3);
//        for (Texts key : countMap.keySet()) {
//            System.out.println(key);
//        }

//        List<List<Integer>> adjacencyList = new ArrayList<>(10);
//        adjacencyList.get(9).add(10);
//        System.out.println(adjacencyList.toString());
//        System.out.println(Integer.MAX_VALUE + " " + 8276704464L);

//        List<Integer> list = List.of(0, 1, 2, 3);
//        List square = list.stream().map( x -> x * x).collect(Collectors.toList());
//        square.forEach( x -> System.out.println(x));

//        Set<Integer> set = new HashSet<>();

//        Map<String, Integer> map = Map.of("hello", 2, "hi", 3);
//        map.computeIfPresent("hi", new BiFunction<String, Integer, Integer>() {
//            @Override
//            public Integer apply(String s, Integer integer) {
//                return integer + 1;
//            }
//        });
//        System.out.println(map.get("hi"));

//
//        System.out.println(map.getOrDefault(5, -3));
//
//        Set<Integer> set = new HashSet<>(list);

//        int[][] ar1 = {{1, 2}, {3, 4}};
//        int[][] ar2 = Arrays.copyOf(ar1, ar1.length);
//        System.arraycopy(ar1, 0, ar2, 0, ar1.length);
//        ar1[0][0] = 9;
////        ar1[0] = new int[]{8, 9};
//        for (int[] array : ar2) {
//            for (int val : array) {
//                System.out.print(val + " ");
//            }
//            System.out.println();
//        }

//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        pq.add(6);
//        pq.add(3);
//        pq.add(2);
//        while (!pq.isEmpty())
//            System.out.println(pq.poll());
        String a = "hi";
        String b = "hello";
        String c = a;
        a = "new";
        System.out.println(b.substring(1));

        StringBuilder sb = new StringBuilder(b);
//        sb.setCharAt();
//        LinkedList
//        ArrayDeque
    }



    public static <T> void printStuffs(T... values) {
        for (T val : values) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}

enum Hi {
    HELLO(1);
    final int a;


    Hi(int a) {
        this.a = a;
    }
}

interface Inter1<T> {
    T hello(T a);
}