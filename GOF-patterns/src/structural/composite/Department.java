package structural.composite;

import java.util.ArrayList;
import java.util.List;

public class Department implements Recipient {
    private List<Recipient> members = new ArrayList<>();
    public void add(Recipient member) {
        members.add(member);
    }
    public void receive(String msg) {
        for (Recipient m : members) {
            m.receive(msg);
        }
    }

}
