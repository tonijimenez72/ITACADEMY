package prova.entity;

public class ChanceGame extends Game {
    public ChanceGame(String id, String name, int difficulty, double price, int inventory) {
        super(id, name, difficulty, price, inventory);
    }

    @Override
    public String getCategory() {
        return "Chance";
    }
}