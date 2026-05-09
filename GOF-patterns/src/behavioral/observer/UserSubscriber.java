package behavioral.observer;

public class UserSubscriber implements Observer {
    private String name;
    
    public UserSubscriber(String name) { 
        this.name = name; 
    }
    
    @Override
    public void update(String message) { 
        System.out.println("Subscriber " + name + " received: " + message); 
    }
}
