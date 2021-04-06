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
//        HashMap<Integer, Integer> hm = new HashMap<>();
//        Integer ans = hm.get(3);
//        if (ans == null) {
//            System.out.println("null!");
//        }

        Product products[] = new Product[3];
        products[0] = new Product(2, 8);
        products[1] = new Product(3, 6);
        products[2] = new Product(4, 12);
        Comparator<Product> customComparator = (p1, p2) -> (int) (p2.getRatio() - p1.getRatio());
        Arrays.sort(products);
        for (Product p : products)
            System.out.println(p);
    }
}

class Product implements Comparable<Product>{
    int weight, value;
    Product(int w, int v) {
        weight = w;
        value = v;
    }
    public double getRatio() {
        return (double) value / (double) weight;
    }

    @Override
    public String toString() {
        return String.format("weight: %d, value: %d, ratio: %f", weight, value, getRatio());
    }

    @Override
    public int compareTo(Product o) {
        return (int) (o.getRatio() - getRatio());
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
