package behavioral.visitor;

public class VisitorPattern {
    public interface NotificationVisitor {
        void visit(TextNotification textNode);
        void visit(HtmlNotification htmlNode);
    }

    public interface NotificationElement {
        void accept(NotificationVisitor visitor);
    }

    public static class TextNotification implements NotificationElement {
        public void accept(NotificationVisitor visitor) { visitor.visit(this); }
    }

    public static class HtmlNotification implements NotificationElement {
        public void accept(NotificationVisitor visitor) { visitor.visit(this); }
    }

    public static class ExportVisitor implements NotificationVisitor {
        public void visit(TextNotification textNode) { System.out.println("Visitor: Exporting Text Notification to XML format."); }
        public void visit(HtmlNotification htmlNode) { System.out.println("Visitor: Exporting HTML Notification to XML format."); }
    }
}
