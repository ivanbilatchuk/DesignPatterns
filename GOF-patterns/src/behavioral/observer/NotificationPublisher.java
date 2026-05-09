package behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class NotificationPublisher {
    private List<Observer> subscribers = new ArrayList<>();
    
    public void subscribe(Observer obs) { 
        subscribers.add(obs); 
    }
    
    public void unsubscribe(Observer obs) { 
        subscribers.remove(obs); 
    }
    
    public void notifySubscribers(String message) {
        for(Observer obs : subscribers) {
            obs.update(message);
        }
    }
}
