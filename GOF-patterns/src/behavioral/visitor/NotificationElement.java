package behavioral.visitor;

public interface NotificationElement {
    void accept(NotificationVisitor visitor);
}
