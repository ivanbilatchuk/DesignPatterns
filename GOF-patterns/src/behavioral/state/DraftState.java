package behavioral.state;

public class DraftState implements MessageState {
    @Override
    public void doAction(MessageContext context) {
        System.out.println("State changed: Message is in DRAFT state.");
        context.setState(this);
    }
}
