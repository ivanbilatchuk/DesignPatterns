package behavioral.strategy;

public class NotificationSender {
    private DeliveryStrategy strategy;
    
    public NotificationSender(DeliveryStrategy strategy) { 
        this.strategy = strategy; 
    }
    
    public void executeStrategy(String message) { 
        strategy.deliver(message); 
    }
}
