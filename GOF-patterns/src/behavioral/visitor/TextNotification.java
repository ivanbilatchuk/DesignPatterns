package behavioral.visitor;

public class TextNotification implements NotificationElement {
    @Override
    public void accept(NotificationVisitor visitor) { 
        visitor.visit(this); 
    }
}
