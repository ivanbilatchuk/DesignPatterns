package creational.abstract_factory;

public record NotificationPackage(PushIcon icon, AlertSound sound) {
    public static class FactoryMaker {
        public static OSFactory makeFactory(SystemType type) {
            return switch (type) {
                case ANDROID -> new AndroidFactory();
                case IOS -> new IOSFactory();
            };
        }
    }
}
