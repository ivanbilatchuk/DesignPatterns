import factory.NotificationType;
import singleton.Settings;
import prototype.NotificationTemplate;
import factory_method.*;
import builder.*;
import abstract_factory.*;

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
    builder.MessageBuilder messageBuilder = new builder.MessageBuilder();
    builder.Message message = messageBuilder
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
    factory.Notification staticMail = factory.NotificationFactory.createNotification(NotificationType.EMAIL);
    System.out.println("[Static Factory] Details: " + staticMail.getDetails());


}
