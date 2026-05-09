package behavioral.command;

public class SendSmsCommand implements Command {
    private Receiver receiver;
    private String text;
    
    public SendSmsCommand(Receiver r, String t) { 
        this.receiver = r; 
        this.text = t; 
    }
    
    @Override
    public void execute() { 
        receiver.sendSms(text); 
    }
}
