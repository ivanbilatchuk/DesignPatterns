package structural.decorator;

abstract class MessageDecorator implements Message{
    protected Message wrapper;
    MessageDecorator(Message m) {
        this.wrapper = m;
    }
}
