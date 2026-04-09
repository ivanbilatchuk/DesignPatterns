package structural.decorator;

public class BaseMessage implements Message{
    private String text;
    public BaseMessage(String text) {
        this.text = text;
    }
    public String getContent() {
        return text;
    }
}
