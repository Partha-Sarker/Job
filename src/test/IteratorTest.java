package test;

import java.util.*;

public class IteratorTest {
    public static void main(String[] args) {
//        List list = new ArrayList();
//        list.add("hello");
//        list.add(5);
//        System.out.println(list.toString());
//        Iterator it = list.iterator();
//        while (it.hasNext()) {
//            System.out.println(it.next().getClass());
//        }
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
//        priorityQueue.add(5);
//        priorityQueue.add(6);
//        priorityQueue.add(9);
//        Iterator<Integer> itPQ = priorityQueue.iterator();
//        while (!priorityQueue.isEmpty()) {
//            System.out.println(priorityQueue.poll());
//        }

//        PriorityQueue<CustomObject> pq = new PriorityQueue<>(new Comparator<CustomObject>() {
//
//            @Override
//            public int compare(CustomObject o1, CustomObject o2) {
//                return o1.a - o2.a;
//            }
//        });
//        pq.add(new CustomObject(1, 2));
//        pq.add(new CustomObject(1, 3));
//        pq.add(new CustomObject(2, -2));
//        pq.add(new CustomObject(-1, 3));
//        pq.add(new CustomObject(3, 3));
//        pq.add(new CustomObject(4, 3));
//        while(!pq.isEmpty())
//            System.out.println(pq.poll());
//        Map<String, Integer> map = new TreeMap<>();
//        map.put("Hello", 2);
//        map.put("E", 9);
//        map.put("A", 7);
//        Iterator it = map.entrySet().iterator();
//        while (it.hasNext()) {
//            System.out.println(it.next());
//        }
        HashMap<Integer, Integer> hm = new HashMap<>();
        Integer ans = hm.get(3);
        if (ans == null) {
            System.out.println("null!");
        }
    }
}
//
//class CustomObject implements Comparable<CustomObject> {
//    int a, b;
//    public CustomObject(int a, int b) {
//        this.a = a;
//        this.b = b;
//    }
//
//    @Override
//    public String toString() {
//        return a + " " + b;
//    }
//
//    @Override
//    public int compareTo(CustomObject o) {
//        return this.b - o.b;
//    }
//}
