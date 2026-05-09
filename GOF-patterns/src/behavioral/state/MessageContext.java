package behavioral.state;

public class MessageContext {
    private MessageState state;
    
    public void setState(MessageState state) { 
        this.state = state; 
    }
    
    public MessageState getState() { 
        return state; 
    }
}
