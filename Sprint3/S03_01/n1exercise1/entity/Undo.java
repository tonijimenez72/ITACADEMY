package n1exercise1.entity;

import java.util.ArrayList;
import java.util.List;

public class Undo {
    private static Undo instance;
    private List<String> commands;

    private Undo() {
        commands = new ArrayList<>();
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
            commands.remove(commands.removeLast());
        }
    }

    public List<String> listCommandHistory() {
        return new ArrayList<>(commands);
    }
}
