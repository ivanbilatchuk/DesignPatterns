package behavioral.visitor;

public class HtmlNotification implements NotificationElement {
    @Override
    public void accept(NotificationVisitor visitor) { 
        visitor.visit(this); 
    }
}
