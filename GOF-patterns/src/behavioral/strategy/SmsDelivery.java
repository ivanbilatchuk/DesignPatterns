package behavioral.strategy;

public class SmsDelivery implements DeliveryStrategy {
    @Override
    public void deliver(String message) { 
        System.out.println("Strategy executed: Delivering via SMS -> " + message); 
    }
}
