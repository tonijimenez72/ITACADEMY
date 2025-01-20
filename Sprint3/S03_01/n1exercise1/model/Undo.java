package n1exercise1.model;

import java.util.ArrayList;
import java.util.List;

public class Undo {
    private static Undo instance;
    private List<String> commands;

    private Undo() {
        this.commands = new ArrayList<>();
    }

    public static Undo getInstance() {
        if (instance == null) {
            instance = new Undo();
        }
        return instance;
    }

    public void addCommand(String command) {
        commands.add(command);
    }

    public void removeLastCommand() {
        if (!commands.isEmpty()) {
            commands.remove(commands.size() - 1);
        }
    }

    public List<String> listCommandHistory() {
        return new ArrayList<>(commands);
    }
}
