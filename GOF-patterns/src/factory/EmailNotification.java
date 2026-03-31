package factory;

public class EmailNotification implements Notification {
    @Override
    public String getDetails() {
        return "Email Notification";
    }
}
