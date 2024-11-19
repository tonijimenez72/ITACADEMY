package n3exercise1.sports;

import n3exercise1.journalist.Journalist;
import n3exercise1.news.News;

public class Moto extends News {
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
        double price = 100;

        price += (team.equalsIgnoreCase("Honda")
                || team.equalsIgnoreCase("Yamaha")) ? 50 : 0;

        return price;
    }

    @Override
    public int calculateScore() {
        int score = 3;

        score += (team.equalsIgnoreCase("Honda")
                || team.equalsIgnoreCase("Yamaha"))
                ?  3 : 0;

        return score;
    }
}