package behavioral.chain;

public abstract class NotificationHandler {
    protected NotificationHandler next;
    
    public void setNext(NotificationHandler next) { 
        this.next = next; 
    }
    
    public void handle(String message, int severity) {
        if (next != null) {
            next.handle(message, severity);
        }
    }
}
