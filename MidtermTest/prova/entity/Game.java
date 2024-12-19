package prova.entity;

public abstract class Game {

    private final String id;
    private final String name;
    private final int difficulty;
    private final double price;
    private int inventory;

    public Game(String id, String name, int difficulty, double price, int inventory) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        if (difficulty < 0) {
            throw new IllegalArgumentException("Category type cannot be negative.");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }

        this.id = id;
        this.name = name;
        this.difficulty = difficulty;
        this.price = price;
        this.inventory = inventory;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public double getPriceWithTax() {
        return price * 1.10;
    }

    public int getInventory() {
        return inventory;
    }

    public void updateInventory(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        this.inventory = quantity;
    }

    public abstract String getCategory();

    @Override
    public String toString() {
        return "\nGame{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", difficulty=" + difficulty +
                ", price=" + price +
                ", inventory=" + inventory +
                '}';
    }
}



