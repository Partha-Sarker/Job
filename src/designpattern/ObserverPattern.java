package designpattern;

import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {
    public static void main(String[] args) {
        Station station = new Station();
        Listener l1 = new Listener();
        Listener l2 = new Listener();
        station.addSubscriber(l1);
        station.addSubscriber(l2);
        station.uploadVideo();
        station.removeSubscriber(l1);
        station.uploadVideo();
    }
}

class Station implements Subject {
    List<Subscriber> subscribers;

    public Station() {
        subscribers = new ArrayList<>();
    }

    @Override
    public void addSubscriber(Subscriber s) {
        subscribers.add(s);
    }

    @Override
    public void removeSubscriber(Subscriber s) {
        subscribers.remove(s);
    }

    @Override
    public void broadcastSomething() {
        for (Subscriber s : subscribers)
            s.receiveBroadcast("New video is uploaded");
    }

    public void uploadVideo() {
        broadcastSomething();
    }
}

interface Subject {
    void addSubscriber(Subscriber s);
    void removeSubscriber(Subscriber s);
    void broadcastSomething();
}

interface Subscriber {
    void receiveBroadcast(String data);
}

class Listener implements Subscriber {
    @Override
    public void receiveBroadcast(String data) {
        System.out.println(System.identityHashCode(this) + " has received the following information: " + data);
    }
}
