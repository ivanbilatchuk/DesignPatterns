package behavioral.observer;

public class ObserverPattern {
    public interface Observer { void update(String message); }

    public static class UserSubscriber implements Observer {
        private String name;
        public UserSubscriber(String name) { this.name = name; }
        public void update(String message) { System.out.println("Subscriber " + name + " received: " + message); }
    }

    public static class NotificationPublisher {
        private java.util.List<Observer> subscribers = new java.util.ArrayList<>();
        public void subscribe(Observer obs) { subscribers.add(obs); }
        public void unsubscribe(Observer obs) { subscribers.remove(obs); }
        public void notifySubscribers(String message) {
            for(Observer obs : subscribers) obs.update(message);
        }
    }
}
