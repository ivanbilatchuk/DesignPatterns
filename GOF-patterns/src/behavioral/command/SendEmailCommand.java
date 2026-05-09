package behavioral.command;

public class SendEmailCommand implements Command {
    private Receiver receiver;
    private String text;
    
    public SendEmailCommand(Receiver r, String t) { 
        this.receiver = r; 
        this.text = t; 
    }
    
    @Override
    public void execute() { 
        receiver.sendEmail(text); 
    }
}
