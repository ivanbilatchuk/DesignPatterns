package behavioral.visitor;

public interface NotificationVisitor {
    void visit(TextNotification textNode);
    void visit(HtmlNotification htmlNode);
}
