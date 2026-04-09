package creational.builder;

public class MessageBuilder {
    String text;
    String recipient;

    public MessageBuilder setText(String t) { this.text = t; return this; }
    public MessageBuilder setRecipient(String r) { this.recipient = r; return this; }

    public Message build() {
        if (recipient == null) throw new IllegalStateException("Recipient is required!");
        return new Message(this);
    }
}