package behavioral.template;

public class PushNotification extends NotificationProcess {
    @Override
    void initialize() { 
        System.out.println("Template Push: Checking device token."); 
    }
    
    @Override
    void startSend() { 
        System.out.println("Template Push: Sending payload."); 
    }
    
    @Override
    void endSend() { 
        System.out.println("Template Push: Delivery confirmed."); 
    }
}
