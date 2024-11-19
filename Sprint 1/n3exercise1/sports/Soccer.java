package n3exercise1.sports;

import n3exercise1.journalist.Journalist;
import n3exercise1.news.News;

public class Soccer extends News {
    private String competition;
    private String team;
    private String player;

    public Soccer(Journalist journalist, String headline, String body, String competition, String team, String player) {
        super(journalist, headline, body);
        this.competition = competition;
        this.team = team;
        this.player = player;
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

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    @Override
    public double calculatePrice() {
        double price = 300;

        price += (competition.equalsIgnoreCase("Champions League")
                || team.equalsIgnoreCase("FC Barcelona")
                || team.equalsIgnoreCase("Real Madrid"))
                ? 100 : 0;

        price += (player.equalsIgnoreCase("Fernando Torres")
                || player.equalsIgnoreCase("Benzema"))
                ? 50 : 0;

        return price;
    }

    @Override
    public int calculateScore() {
        int score = 5;

        score += (competition.equalsIgnoreCase("Champions League")) ? 3 : 0;
        score += (competition.equalsIgnoreCase("League")) ? 2 : 0;

        score += (team.equalsIgnoreCase("FC Barcelona")
                || team.equalsIgnoreCase("Real Madrid")
                || player.equalsIgnoreCase("Fernando Torres")
                || player.equalsIgnoreCase("Benzema"))
                ? 1 : 0;

        return score;
    }
}
