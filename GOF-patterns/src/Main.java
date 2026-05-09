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
                        OSfactory.createSound());
        System.out.print("Action: ");
        androidPackage.icon().show();
        System.out.print("Action: ");
        androidPackage.sound().play();

        System.out.println("\n--- Testing Static Factory---");
        creational.factory.Notification staticMail = creational.factory.NotificationFactory
                        .createNotification(NotificationType.EMAIL);
        System.out.println("[Static Factory] Details: " + staticMail.getDetails());

        System.out.println("\nSTRUCTURAL DESIGN PATTERNS DEMONSTRATION\n");

        System.out.println("[Adapter] Testing SMS Adapter:");
        structural.adapter.Notification adapter = new structural.adapter.SmsAdapter();
        adapter.send("Alert", "System overload!");

        System.out.println("\n[Bridge] Testing Urgent Notification via Email:");
        structural.bridge.UrgentNotification bridgeNotif = new structural.bridge.UrgentNotification(
                        new structural.bridge.EmailSender());
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

        System.out.println("\nBEHAVIORAL DESIGN PATTERNS DEMONSTRATION\n");

        System.out.println("[Chain of Responsibility] Testing Handlers:");
        behavioral.chain.ChainPattern.NotificationHandler infoHandler = new behavioral.chain.ChainPattern.InfoHandler();
        behavioral.chain.ChainPattern.NotificationHandler warningHandler = new behavioral.chain.ChainPattern.WarningHandler();
        behavioral.chain.ChainPattern.NotificationHandler errorHandler = new behavioral.chain.ChainPattern.ErrorHandler();
        infoHandler.setNext(warningHandler);
        warningHandler.setNext(errorHandler);
        infoHandler.handle("Everything is OK.", 1);
        infoHandler.handle("Low disk space.", 2);
        infoHandler.handle("System crash!", 3);

        System.out.println("\n[Command] Testing Command Invoker:");
        behavioral.command.CommandPattern.Receiver receiver = new behavioral.command.CommandPattern.Receiver();
        behavioral.command.CommandPattern.Command emailCmd = new behavioral.command.CommandPattern.SendEmailCommand(receiver, "Hello!");
        behavioral.command.CommandPattern.Command smsCmd = new behavioral.command.CommandPattern.SendSmsCommand(receiver, "Wake up!");
        behavioral.command.CommandPattern.Invoker invoker = new behavioral.command.CommandPattern.Invoker();
        invoker.addCommand(emailCmd);
        invoker.addCommand(smsCmd);
        invoker.executeCommands();

        System.out.println("\n[Iterator] Testing Message Iterator:");
        behavioral.iterator.IteratorPattern.MessageHistory msgHistory = new behavioral.iterator.IteratorPattern.MessageHistory();
        for (behavioral.iterator.IteratorPattern.Iterator iter = msgHistory.getIterator(); iter.hasNext(); ) {
            System.out.println("Iterator retrieved: " + iter.next());
        }

        System.out.println("\n[Mediator] Testing Chat Room:");
        behavioral.mediator.MediatorPattern.User userA = new behavioral.mediator.MediatorPattern.User("Alice");
        behavioral.mediator.MediatorPattern.User userB = new behavioral.mediator.MediatorPattern.User("Bob");
        userA.sendMessage("Hi Bob!");
        userB.sendMessage("Hello Alice!");

        System.out.println("\n[Memento] Testing State Restoration:");
        behavioral.memento.MementoPattern.MessageEditor editor = new behavioral.memento.MementoPattern.MessageEditor();
        behavioral.memento.MementoPattern.History mementoHistory = new behavioral.memento.MementoPattern.History();
        editor.setText("State 1: Hello");
        mementoHistory.add(editor.save());
        editor.setText("State 2: Hello World");
        mementoHistory.add(editor.save());
        editor.setText("State 3: Hello World!");
        System.out.println("Current Text: " + editor.getText());
        editor.restore(mementoHistory.get(0));
        System.out.println("Restored to State 1: " + editor.getText());

        System.out.println("\n[Observer] Testing Notification Publisher:");
        behavioral.observer.ObserverPattern.NotificationPublisher publisher = new behavioral.observer.ObserverPattern.NotificationPublisher();
        behavioral.observer.ObserverPattern.Observer sub1 = new behavioral.observer.ObserverPattern.UserSubscriber("Sub1");
        behavioral.observer.ObserverPattern.Observer sub2 = new behavioral.observer.ObserverPattern.UserSubscriber("Sub2");
        publisher.subscribe(sub1);
        publisher.subscribe(sub2);
        publisher.notifySubscribers("New update available!");

        System.out.println("\n[State] Testing Message State Context:");
        behavioral.state.StatePattern.MessageContext context = new behavioral.state.StatePattern.MessageContext();
        behavioral.state.StatePattern.DraftState draft = new behavioral.state.StatePattern.DraftState();
        draft.doAction(context);
        behavioral.state.StatePattern.SentState sent = new behavioral.state.StatePattern.SentState();
        sent.doAction(context);

        System.out.println("\n[Strategy] Testing Delivery Strategies:");
        behavioral.strategy.StrategyPattern.NotificationSender senderEmail = new behavioral.strategy.StrategyPattern.NotificationSender(new behavioral.strategy.StrategyPattern.EmailDelivery());
        senderEmail.executeStrategy("Report is ready.");
        behavioral.strategy.StrategyPattern.NotificationSender senderSms = new behavioral.strategy.StrategyPattern.NotificationSender(new behavioral.strategy.StrategyPattern.SmsDelivery());
        senderSms.executeStrategy("Report is ready.");

        System.out.println("\n[Template] Testing Notification Processes:");
        behavioral.template.TemplatePattern.NotificationProcess pushProcess = new behavioral.template.TemplatePattern.PushNotification();
        pushProcess.send();
        behavioral.template.TemplatePattern.NotificationProcess emailProcess = new behavioral.template.TemplatePattern.EmailNotification();
        emailProcess.send();

        System.out.println("\n[Visitor] Testing Export Visitor:");
        behavioral.visitor.VisitorPattern.NotificationElement textNode = new behavioral.visitor.VisitorPattern.TextNotification();
        behavioral.visitor.VisitorPattern.NotificationElement htmlNode = new behavioral.visitor.VisitorPattern.HtmlNotification();
        behavioral.visitor.VisitorPattern.NotificationVisitor exportVisitor = new behavioral.visitor.VisitorPattern.ExportVisitor();
        textNode.accept(exportVisitor);
        htmlNode.accept(exportVisitor);
}
