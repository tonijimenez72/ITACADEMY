package n3exercise1.sports;

import n3exercise1.journalist.Journalist;
import n3exercise1.news.News;

public class Basket extends News {
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
        double price = 250;

        price += (competition.equalsIgnoreCase("Euroleague")
                || team.equalsIgnoreCase("FC Barcelona")
                || team.equalsIgnoreCase("Real Madrid"))
                ? 75 : 0;

        return price;
    }

    @Override
    public int calculateScore() {
        int score = 4;

        score += (competition.equalsIgnoreCase("Euroleague")) ? 3 : 0;
        score += (competition.equalsIgnoreCase("ACB")) ? 2 : 0;

        score += (team.equalsIgnoreCase("FC Barcelona")
                || team.equalsIgnoreCase("Real Madrid"))
                ? 1 :  0;

        return score;
    }
}