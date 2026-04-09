package structural.proxy;

public class RealNotificationService implements ServiceAccess{
    public void execute(String user) {
        System.out.println("Sending notification to " + user);
    }
}
