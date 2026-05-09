package behavioral.template;

public abstract class NotificationProcess {
    abstract void initialize();
    abstract void startSend();
    abstract void endSend();

    public final void send() {
        initialize();
        startSend();
        endSend();
    }
}
