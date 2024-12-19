package prova.entity;

public class StrategyGame extends Game {
    public StrategyGame(String id, String name, int difficulty, double price, int inventory) {
        super(id, name, difficulty, price, inventory);
    }

    @Override
    public String getCategory() {
        return "Strategy";
    }
}