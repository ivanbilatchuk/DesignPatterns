package behavioral.strategy;

public class EmailDelivery implements DeliveryStrategy {
    @Override
    public void deliver(String message) { 
        System.out.println("Strategy executed: Delivering via Email -> " + message); 
    }
}
