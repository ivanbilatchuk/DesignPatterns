package abstract_factory;

public interface OSFactory {
    PushIcon createIcon();
    AlertSound createSound();
}
