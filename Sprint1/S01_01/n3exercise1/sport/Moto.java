package n3exercise1.sport;

import n3exercise1.journalist.Journalist;
import n3exercise1.news.News;

public class Moto extends News {
    private static final double BASE_PRICE = 100;
    private static final double TEAM_BONUS = 50;
    private static final String HONDA_TEAM = "Honda";
    private static final String YAMAHA_TEAM = "Yamaha";
    private static final int BASE_SCORE = 4;
    private static final int TEAM_SCORE = 3;
    private static final int NO_BONUS = 0;

    private String team;

    public Moto(Journalist journalist, String headline, String body, String team) {
        super(journalist, headline, body);
        this.team = team;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    @Override
    public double calculatePrice() {
        double totalPrice = BASE_PRICE;

        totalPrice += (team.equalsIgnoreCase(HONDA_TEAM) || team.equalsIgnoreCase(YAMAHA_TEAM))
                ? TEAM_BONUS : NO_BONUS;

        return totalPrice;
    }

    @Override
    public int calculateScore() {
        int totalScore = BASE_SCORE;

        totalScore += (team.equalsIgnoreCase(HONDA_TEAM) || team.equalsIgnoreCase(YAMAHA_TEAM))
                ? TEAM_SCORE : NO_BONUS;

        return totalScore;
    }
}
