package n3exercise1.sports;

import n3exercise1.journalist.Journalist;
import n3exercise1.news.News;

public class Tennis extends News {
    private String competition;
    private String player;

    public Tennis(Journalist journalist, String headline, String body, String competition, String player) {
        super(journalist, headline, body);
        this.competition = competition;
        this.player = player;
    }

    @Override
    public double calculatePrice() {
        double price = 150;

        price += (player.equalsIgnoreCase("Federer")
                || player.equalsIgnoreCase("Nadal")
                || player.equalsIgnoreCase("Djokovic")
                ? 100 : 0);

        return price;
    }

    @Override
    public int calculateScore() {
        int score = 4;

        score += (player.equalsIgnoreCase("Federer")
                || player.equalsIgnoreCase("Nadal")
                || player.equalsIgnoreCase("Benzema"))
                ? 3 : 0;

        return score;
    }
}
