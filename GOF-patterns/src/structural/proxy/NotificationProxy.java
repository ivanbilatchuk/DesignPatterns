package structural.proxy;

public class NotificationProxy implements ServiceAccess{
    private RealNotificationService realService = new RealNotificationService();

    public void execute(String user) {
        if ("ADMIN".equalsIgnoreCase(user)) {
            realService.execute(user);
        } else {
            System.out.println("Proxy: Access Denied! User '" + user + "' is not Admin.");
        }
    }
}
