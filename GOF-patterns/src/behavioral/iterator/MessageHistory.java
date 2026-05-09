package behavioral.iterator;

public class MessageHistory implements Container {
    public String[] messages = {"Login Warning", "Weekly Digest", "Subscription Expiring"};

    @Override
    public Iterator getIterator() { 
        return new MessageIterator(); 
    }

    private class MessageIterator implements Iterator {
        int index = 0;
        
        @Override
        public boolean hasNext() { 
            return index < messages.length; 
        }
        
        @Override
        public Object next() {
            if (this.hasNext()) {
                return messages[index++];
            }
            return null;
        }
    }
}
