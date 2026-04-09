package structural.flyweight;

public class SmsNotification implements Notification{
    private final String provider = "SMS";
    @Override
    public void display(String timeStamp, String recipient) {
        System.out.println(provider + " notification sent to " + recipient + " at " + timeStamp);
    }
}
