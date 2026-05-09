package behavioral.command;

import java.util.ArrayList;
import java.util.List;

public class Invoker {
    private List<Command> commands = new ArrayList<>();
    
    public void addCommand(Command c) { 
        commands.add(c); 
    }
    
    public void executeCommands() {
        for(Command c : commands) {
            c.execute();
        }
        commands.clear();
    }
}
