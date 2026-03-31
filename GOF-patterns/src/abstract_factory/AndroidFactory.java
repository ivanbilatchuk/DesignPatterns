package abstract_factory;

public class AndroidFactory implements OSFactory {
    public PushIcon createIcon() { return new AndroidIcon(); }
    public AlertSound createSound() { return new AndroidSound(); }
}