package designpattern;

public class Singleton {
    private static Singleton instance;

    private Singleton() {
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public static Singleton getInstance() {
        if (instance == null) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        new Thread(() -> {
            Singleton s1 = Singleton.getInstance();
            System.out.println(System.identityHashCode(s1));
        }).start();
        new Thread(() -> {
            Singleton s1 = Singleton.getInstance();
            System.out.println(System.identityHashCode(s1));
        }).start();
    }

}
