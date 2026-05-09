package behavioral.mediator;

public class MediatorPattern {
    public static class ChatRoom {
        public static void showMessage(User user, String message) {
            System.out.println("[" + user.getName() + "]: " + message);
        }
    }

    public static class User {
        private String name;
        public User(String name) { this.name = name; }
        public String getName() { return name; }
        public void sendMessage(String message) { ChatRoom.showMessage(this, message); }
    }
}
