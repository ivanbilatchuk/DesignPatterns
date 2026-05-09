package behavioral.state;

public class SentState implements MessageState {
    @Override
    public void doAction(MessageContext context) {
        System.out.println("State changed: Message is in SENT state.");
        context.setState(this);
    }
}
