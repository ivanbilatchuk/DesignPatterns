package creational.abstract_factory;

public class IOSFactory implements OSFactory {
    public PushIcon createIcon() { return new IOSIcon(); }
    public AlertSound createSound() { return new IOSSound(); }
}