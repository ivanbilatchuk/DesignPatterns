package behavioral.memento;

import java.util.ArrayList;
import java.util.List;

public class History {
    private List<Draft> mementoList = new ArrayList<>();
    
    public void add(Draft state) { 
        mementoList.add(state); 
    }
    
    public Draft get(int index) { 
        return mementoList.get(index); 
    }
}
