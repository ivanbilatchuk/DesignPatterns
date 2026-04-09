package structural.decorator;

public class EncryptionDecorator  extends MessageDecorator{
    public EncryptionDecorator(Message m) {
        super(m);
    }
    @Override
    public String getContent() {
        return wrapper.getContent() + " (encrypted)";
    }
}
