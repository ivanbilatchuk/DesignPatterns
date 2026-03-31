package builder;

public class Message {
    public final String text;
    public final String recipient;

    Message(MessageBuilder builder) {
        this.text = builder.text;
        this.recipient = builder.recipient;
    }
}