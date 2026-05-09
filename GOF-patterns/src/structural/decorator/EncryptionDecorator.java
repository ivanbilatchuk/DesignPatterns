package structural.decorator;

import java.util.function.Function;

public class EncryptionDecorator {
    // A decorator is just a function that takes a String and returns a String
    public static final Function<String, String> encrypt = msg -> msg + " (encrypted)";
    
    // We can add more decorators easily
    public static final Function<String, String> addHeader = msg -> "[CONFIDENTIAL] " + msg;
}
