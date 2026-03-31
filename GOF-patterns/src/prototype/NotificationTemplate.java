package prototype;

import java.util.Objects;

public class NotificationTemplate implements Prototype {
    private final String name;
    private final String text;
    public NotificationTemplate(String name, String text) {
        this.name = name;
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotificationTemplate that = (NotificationTemplate) o;
        return Objects.equals(name, that.name) && Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, text);
    }

    @Override
    public Prototype doClone() {
        return new NotificationTemplate(name, text);
    }

    public void print() {
        System.out.println("[" + name + "]: " + text);
    }
}