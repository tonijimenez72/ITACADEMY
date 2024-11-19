package n3exercise1.sports;

import n3exercise1.journalist.Journalist;
import n3exercise1.news.News;

public class F1 extends News {
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
        double price = 100;

        price += (team.equalsIgnoreCase("Ferrari")
                || team.equalsIgnoreCase("Mercedes")) ? 50 : 0;

        return price;
    }

    @Override
    public int calculateScore() {
        int score = 4;

        score += (team.equalsIgnoreCase("Ferrari")
                || team.equalsIgnoreCase("Mercedes"))
                ? 2 : 0;

        return score;
    }
}