package behavioral.strategy;

public class StrategyPattern {
    public interface DeliveryStrategy { void deliver(String message); }

    public static class EmailDelivery implements DeliveryStrategy {
        public void deliver(String message) { System.out.println("Strategy executed: Delivering via Email -> " + message); }
    }

    public static class SmsDelivery implements DeliveryStrategy {
        public void deliver(String message) { System.out.println("Strategy executed: Delivering via SMS -> " + message); }
    }

    public static class NotificationSender {
        private DeliveryStrategy strategy;
        public NotificationSender(DeliveryStrategy strategy) { this.strategy = strategy; }
        public void executeStrategy(String message) { strategy.deliver(message); }
    }
}
