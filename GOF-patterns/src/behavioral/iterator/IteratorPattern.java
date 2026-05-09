package behavioral.iterator;

public class IteratorPattern {
    public interface Iterator {
        boolean hasNext();
        Object next();
    }

    public interface Container {
        Iterator getIterator();
    }

    public static class MessageHistory implements Container {
        public String[] messages = {"Login Warning", "Weekly Digest", "Subscription Expiring"};

        public Iterator getIterator() { return new MessageIterator(); }

        private class MessageIterator implements Iterator {
            int index = 0;
            public boolean hasNext() { return index < messages.length; }
            public Object next() {
                if (this.hasNext()) return messages[index++];
                return null;
            }
        }
    }
}
