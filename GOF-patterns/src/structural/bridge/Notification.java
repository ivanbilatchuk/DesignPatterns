package structural.bridge;

abstract class Notification {
    protected MessageSender sender;
    protected Notification(MessageSender sender) {
        this.sender = sender;
    }
    public abstract void notify(String msg);
}
