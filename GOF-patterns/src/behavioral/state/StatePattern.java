package behavioral.state;

public class StatePattern {
    public interface MessageState { void doAction(MessageContext context); }

    public static class MessageContext {
        private MessageState state;
        public void setState(MessageState state) { this.state = state; }
        public MessageState getState() { return state; }
    }

    public static class DraftState implements MessageState {
        public void doAction(MessageContext context) {
            System.out.println("State changed: Message is in DRAFT state.");
            context.setState(this);
        }
    }

    public static class SentState implements MessageState {
        public void doAction(MessageContext context) {
            System.out.println("State changed: Message is in SENT state.");
            context.setState(this);
        }
    }
}
