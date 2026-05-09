package behavioral.command;

public class CommandPattern {
    public interface Command { void execute(); }

    public static class Receiver {
        public void sendEmail(String text) { System.out.println("Sending Email via receiver: " + text); }
        public void sendSms(String text) { System.out.println("Sending SMS via receiver: " + text); }
    }

    public static class SendEmailCommand implements Command {
        private Receiver receiver;
        private String text;
        public SendEmailCommand(Receiver r, String t) { this.receiver = r; this.text = t; }
        public void execute() { receiver.sendEmail(text); }
    }

    public static class SendSmsCommand implements Command {
        private Receiver receiver;
        private String text;
        public SendSmsCommand(Receiver r, String t) { this.receiver = r; this.text = t; }
        public void execute() { receiver.sendSms(text); }
    }

    public static class Invoker {
        private java.util.List<Command> commands = new java.util.ArrayList<>();
        public void addCommand(Command c) { commands.add(c); }
        public void executeCommands() {
            for(Command c : commands) c.execute();
            commands.clear();
        }
    }
}
