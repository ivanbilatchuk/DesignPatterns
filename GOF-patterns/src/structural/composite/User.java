package structural.composite;

public class User implements Recipient{
    private String name;
    public User(String name) {
        this.name = name;
    }
    public void receive(String msg) {
        System.out.println(name + "received: " + msg);
    }
}
