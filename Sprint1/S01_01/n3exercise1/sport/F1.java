package n3exercise1.sport;

import n3exercise1.journalist.Journalist;
import n3exercise1.news.News;

public class F1 extends News {
    private static final double BASE_PRICE = 100;
    private static final double TEAM_BONUS = 50;
    private static final String FERRARI_TEAM = "Ferrari";
    private static final String MERCEDES_TEAM = "Mercedes";
    private static final int BASE_SCORE = 4;
    private static final int TEAM_SCORE = 2;
    private static final int NO_BONUS = 0;


    private String team;

    public F1(Journalist journalist, String headline, String body, String team) {
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
        double finalPrice = BASE_PRICE;

        finalPrice += (team.equalsIgnoreCase(FERRARI_TEAM)
                || team.equalsIgnoreCase(MERCEDES_TEAM)) ? TEAM_BONUS : NO_BONUS;

        return finalPrice;
    }

    @Override
    public int calculateScore() {
        int finalScore = BASE_SCORE;

         finalScore += (team.equalsIgnoreCase(FERRARI_TEAM)
                || team.equalsIgnoreCase(MERCEDES_TEAM))
                ? TEAM_SCORE : NO_BONUS;

        return finalScore;
    }
}