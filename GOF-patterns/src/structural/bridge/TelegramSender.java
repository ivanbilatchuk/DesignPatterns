package structural.bridge;

public class TelegramSender implements MessageSender{
    public void sendMessage(String t) {
        System.out.println("Telegram: " + t);
    }
}
