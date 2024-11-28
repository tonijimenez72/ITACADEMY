package n3exercise1.sport;

import n3exercise1.journalist.Journalist;
import n3exercise1.news.News;

public class Tennis extends News {
    // Definir constantes para los valores hardcoded
    private static final double BASE_PRICE = 150;
    private static final double PLAYER_BONUS = 100;
    private static final String FEDERER = "Federer";
    private static final String NADAL = "Nadal";
    private static final String DJOKOVIC = "Djokovic";
    private static final String BENZEMA = "Benzema";
    private static final int BASE_SCORE = 4;
    private static final int PLAYER_SCORE_BONUS = 3;
    private static final int NO_BONUS = 0;

    private String competition;
    private String player;

    public Tennis(Journalist journalist, String headline, String body, String competition, String player) {
        super(journalist, headline, body);
        this.competition = competition;
        this.player = player;
    }

    public String getCompetition() {
        return competition;
    }

    public void setCompetition(String competition) {
        this.competition = competition;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    @Override
    public double calculatePrice() {
        double finalPrice = BASE_PRICE;

        finalPrice += (player.equalsIgnoreCase(FEDERER) ||
                player.equalsIgnoreCase(NADAL) ||
                player.equalsIgnoreCase(DJOKOVIC))
                ? PLAYER_BONUS : NO_BONUS;

        return finalPrice;
    }

    @Override
    public int calculateScore() {
        int finalScore = BASE_SCORE;

        finalScore += (player.equalsIgnoreCase(FEDERER) ||
                player.equalsIgnoreCase(NADAL) ||
                player.equalsIgnoreCase(BENZEMA))
                ? PLAYER_SCORE_BONUS : NO_BONUS;

        return finalScore;
    }
}
