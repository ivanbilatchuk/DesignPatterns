package structural.bridge;

public class EmailSender implements MessageSender{
    public void sendMessage(String t) {
        System.out.println("Email: " + t);
    }
}
