import creational.factory.NotificationType;
import creational.singleton.Settings;
import creational.prototype.NotificationTemplate;
import creational.factory_method.*;
import creational.abstract_factory.*;
import structural.adapter.SmsAdapter;

public static void main(String[] args) {
    System.out.println("CREATIONAL DESIGN PATTERNS DEMONSTRATION\n");

    Settings settings = Settings.getInstance();
    System.out.println("[Singleton] Server URL: " + settings.getServer());

    NotificationTemplate original = new NotificationTemplate("Welcome", "Hello, user!");
    NotificationTemplate clone = (NotificationTemplate) original.doClone();
    System.out.print("[Prototype] Cloned Template: ");
    clone.print();

    System.out.println("\n[Factory Method] Testing multiple providers:");
    NotificationFactory emailFactory = new EmailFactory();
    emailFactory.create().send();

    NotificationFactory smsFactory = new SmsFactory();
    smsFactory.create().send();

    System.out.println("[Builder] Builder Construction:");
    creational.builder.MessageBuilder messageBuilder = new creational.builder.MessageBuilder();
    creational.builder.Message message = messageBuilder
            .setRecipient("admin@chnu.edu.ua")
            .setText("System update successful")
            .build();
    System.out.println("    Recipient: " + message.recipient);
    System.out.println("    Content: " + message.text);

    System.out.println("[Abstract Factory] Initializing UI for Android...");
    OSFactory OSfactory = NotificationPackage.FactoryMaker.makeFactory(SystemType.ANDROID);
    NotificationPackage androidPackage = new NotificationPackage(
            OSfactory.createIcon(),
            OSfactory.createSound()
    );
    System.out.print("Action: ");
    androidPackage.icon().show();
    System.out.print("Action: ");
    androidPackage.sound().play();

    System.out.println("\n--- Testing Static Factory---");
    creational.factory.Notification staticMail = creational.factory.NotificationFactory.createNotification(NotificationType.EMAIL);
    System.out.println("[Static Factory] Details: " + staticMail.getDetails());

    System.out.println("\nSTRUCTURAL DESIGN PATTERNS DEMONSTRATION\n");

    System.out.println("[Adapter] Testing SMS Adapter:");
    structural.adapter.Notification adapter = new structural.adapter.SmsAdapter();
    adapter.send("Alert", "System overload!");

    System.out.println("\n[Bridge] Testing Urgent Notification via Email:");
    structural.bridge.UrgentNotification bridgeNotif = new structural.bridge.UrgentNotification(new structural.bridge.EmailSender());
    bridgeNotif.notify("Server down!");

    System.out.println("\n[Composite] Testing Department Notifications:");
    structural.composite.Department itDept = new structural.composite.Department();
    itDept.add(new structural.composite.User("Alice "));
    itDept.add(new structural.composite.User("Bob "));
    itDept.receive("Meeting at 5 PM.");

    System.out.println("\n[Decorator] Testing Encrypted Message:");
    structural.decorator.Message msg = new structural.decorator.BaseMessage("Secret data");
    structural.decorator.Message encryptedMsg = new structural.decorator.EncryptionDecorator(msg);
    System.out.println("Original: " + msg.getContent());
    System.out.println("Decorated: " + encryptedMsg.getContent());

    System.out.println("\n[Facade] Testing Notification Facade:");
    structural.facade.NotificationFacade facade = new structural.facade.NotificationFacade();
    facade.sendNotification("Welcome", "Hello new user!", "api-key-123");

    System.out.println("\n[Flyweight] Testing Notification History:");
    structural.flyweight.NotificationFactory fwFactory = new structural.flyweight.NotificationFactory();
    structural.flyweight.NotificationHistory history = new structural.flyweight.NotificationHistory(fwFactory);
    history.record(structural.flyweight.NotificationType.EMAIL, "10:00", "User1");
    history.record(structural.flyweight.NotificationType.EMAIL, "10:05", "User2");

    System.out.println("\n[Proxy] Testing Notification Proxy:");
    structural.proxy.ServiceAccess proxy = new structural.proxy.NotificationProxy();
    proxy.execute("GUEST");
    proxy.execute("ADMIN");
}
