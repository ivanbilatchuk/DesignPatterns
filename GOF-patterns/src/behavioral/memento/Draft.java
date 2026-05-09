package behavioral.memento;

public class Draft {
    private String state;
    
    public Draft(String state) { 
        this.state = state; 
    }
    
    public String getState() { 
        return state; 
    }
}
