package behavioral.template;

public class EmailNotification extends NotificationProcess {
    @Override
    void initialize() { 
        System.out.println("Template Email: Connecting to SMTP server."); 
    }
    
    @Override
    void startSend() { 
        System.out.println("Template Email: Sending byte stream."); 
    }
    
    @Override
    void endSend() { 
        System.out.println("Template Email: Disconnecting SMTP."); 
    }
}
