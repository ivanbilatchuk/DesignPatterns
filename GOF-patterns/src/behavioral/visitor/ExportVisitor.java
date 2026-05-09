package behavioral.visitor;

public class ExportVisitor implements NotificationVisitor {
    @Override
    public void visit(TextNotification textNode) { 
        System.out.println("Visitor: Exporting Text Notification to XML format."); 
    }
    
    @Override
    public void visit(HtmlNotification htmlNode) { 
        System.out.println("Visitor: Exporting HTML Notification to XML format."); 
    }
}
