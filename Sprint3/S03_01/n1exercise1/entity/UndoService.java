package n1exercise1.entity;

import java.util.ArrayList;
import java.util.List;

public class UndoService {
    private List<String> commands;

    public UndoService() {
        this.commands = new ArrayList<>();
    }

    public void addCommand(String command) {
        commands.add(command);
    }

    public void removeLastCommand() {
        if (!commands.isEmpty()) {
            commands.remove(commands.removeLast());
        }
    }

    public List<String> listCommandHistory() {
        return new ArrayList<>(commands);
    }
}
