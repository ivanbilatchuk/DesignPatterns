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

}



