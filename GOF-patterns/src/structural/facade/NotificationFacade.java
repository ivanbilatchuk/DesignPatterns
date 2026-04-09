package structural.facade;

public class NotificationFacade {
    private AuthSystem authSystem = new AuthSystem();
    private ConnectionManager connectionManager = new ConnectionManager();
    private JsonFormatter jsonFormatter = new JsonFormatter();
    private DatabaseLogger databaseLogger = new DatabaseLogger();
    public void sendNotification(String title, String message, String apiKey) {
        System.out.println("NotificationFacade: starting notification process...");
        authSystem.login(apiKey);
        if (connectionManager.checkConnection()) {
            String json = jsonFormatter.format(title, message);
            databaseLogger.logTransaction(json);
            System.out.println("NotificationFacade: notification sent successfully!");
        }
        System.out.println("NotificationFacade: process completed.");
    }
}
