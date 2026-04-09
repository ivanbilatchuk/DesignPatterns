package structural.facade;

public class DatabaseLogger {
    public void logTransaction(String data) {
        System.out.println("DatabaseLogger: " + data);
    }
}
