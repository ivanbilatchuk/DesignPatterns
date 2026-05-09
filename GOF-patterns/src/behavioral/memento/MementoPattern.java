package behavioral.memento;

public class MementoPattern {
    public static class Draft {
        private String state;
        public Draft(String state) { this.state = state; }
        public String getState() { return state; }
    }

    public static class MessageEditor {
        private String text;
        public void setText(String text) { this.text = text; }
        public String getText() { return text; }
        public Draft save() { return new Draft(text); }
        public void restore(Draft draft) { this.text = draft.getState(); }
    }

    public static class History {
        private java.util.List<Draft> mementoList = new java.util.ArrayList<>();
        public void add(Draft state) { mementoList.add(state); }
        public Draft get(int index) { return mementoList.get(index); }
    }
}
