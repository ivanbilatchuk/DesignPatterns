package behavioral.strategy;

import java.util.function.Consumer;

public class StrategyPattern {

    public static final Consumer<String> emailDelivery = message -> 
        System.out.println("Strategy executed: Delivering via Email -> " + message);

    public static final Consumer<String> smsDelivery = message -> 
        System.out.println("Strategy executed: Delivering via SMS -> " + message);

    public static class NotificationSender {
        private final Consumer<String> strategy;
        
        public NotificationSender(Consumer<String> strategy) { 
            this.strategy = strategy; 
        }
        
        public void executeStrategy(String message) { 
            strategy.accept(message); 
        }
    }
}
