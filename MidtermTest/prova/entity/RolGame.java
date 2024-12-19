package prova.entity;

public class RolGame extends Game {
    public RolGame(String id, String name, int difficulty, double price, int inventory) {
        super(id, name, difficulty, price, inventory);
    }

    @Override
    public String getCategory() {
        return "Rol";
    }
}