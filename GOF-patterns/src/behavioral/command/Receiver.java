package behavioral.command;

public class Receiver {
    public void sendEmail(String text) { 
        System.out.println("Sending Email via receiver: " + text); 
    }
    public void sendSms(String text) { 
        System.out.println("Sending SMS via receiver: " + text); 
    }
}
