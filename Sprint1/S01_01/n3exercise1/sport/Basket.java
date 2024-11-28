package n3exercise1.sport;

import n3exercise1.journalist.Journalist;
import n3exercise1.news.News;

public class Basket extends News {
    private static final double BASE_PRICE = 250;
    private static final double EUROLEAGUE_BONUS = 75;
    private static final double TEAM_BONUS = 75;
    private static final String EUROLEAGUE_COMPETITION = "Euroleague";
    private static final String ACB_COMPETITION = "ACB";
    private static final String FC_BARCELONA_TEAM = "FC Barcelona";
    private static final String REAL_MADRID_TEAM = "Real Madrid";
    private static final int BASE_SCORE = 4;
    private static final int EUROLEAGUE_SCORE = 3;
    private static final int ACB_SCORE = 2;
    private static final int TEAM_SCORE = 1;
    private static final int NO_BONUS = 0;

    private String competition;
    private String team;

    public Basket(Journalist journalist, String headline, String body, String competition, String team) {
        super(journalist, headline, body);
        this.competition = competition;
        this.team = team;
    }

    public String getCompetition() {
        return competition;
    }

    public void setCompetition(String competition) {
        this.competition = competition;
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

        totalPrice += (competition.equalsIgnoreCase(EUROLEAGUE_COMPETITION) ? EUROLEAGUE_BONUS : NO_BONUS);
        totalPrice += (team.equalsIgnoreCase(FC_BARCELONA_TEAM)
                || team.equalsIgnoreCase(REAL_MADRID_TEAM))
                ? TEAM_BONUS : NO_BONUS;

        return totalPrice;
    }

    @Override
    public int calculateScore() {
        int totalScore = BASE_SCORE;

        totalScore += (competition.equalsIgnoreCase(EUROLEAGUE_COMPETITION)) ? EUROLEAGUE_SCORE : NO_BONUS;
        totalScore += (competition.equalsIgnoreCase(ACB_COMPETITION)) ? ACB_SCORE : NO_BONUS;

        totalScore += (team.equalsIgnoreCase(FC_BARCELONA_TEAM)
                || team.equalsIgnoreCase(REAL_MADRID_TEAM))
                ? TEAM_SCORE : NO_BONUS;
        return totalScore;
    }
}