package behavioral.memento;

public class MessageEditor {
    private String text;
    
    public void setText(String text) { 
        this.text = text; 
    }
    
    public String getText() { 
        return text; 
    }
    
    public Draft save() { 
        return new Draft(text); 
    }
    
    public void restore(Draft draft) { 
        this.text = draft.getState(); 
    }
}
