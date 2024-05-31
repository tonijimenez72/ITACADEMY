package n3exercise1;

public class Tennis extends News {
    private String player;

    public Tennis(Journalist journalist, String headline, String player) {
        super(journalist, headline);
        this.player = player;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    @Override
    public double calculatePrice() {
        double price = 150;
        if (player.equalsIgnoreCase("Federer") || player.equalsIgnoreCase("Nadal") || player.equalsIgnoreCase("Djokovic")) {
            price += 100;
        }
        return price;
    }

    @Override
    public int calculateScore() {
        int score = 5;
        if (player.equalsIgnoreCase("Federer") || player.equalsIgnoreCase("Nadal") || player.equalsIgnoreCase("Djokovic")) {
            score += 3;
        }
        return score;
    }
}