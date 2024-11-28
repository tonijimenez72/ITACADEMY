package n3exercise1.sport;

import n3exercise1.journalist.Journalist;
import n3exercise1.news.News;

public class Soccer extends News {

    private static final double BASE_PRICE = 300;
    private static final double CHAMPIONS_LEAGUE_BONUS = 100;
    private static final double TEAM_BONUS = 100;
    private static final double PLAYER_BONUS = 50;
    private static final String CHAMPIONS_LEAGUE = "Champions League";
    private static final String LEAGUE = "League";
    private static final String FC_BARCELONA = "FC Barcelona";
    private static final String REAL_MADRID = "Real Madrid";
    private static final String FERNANDO_TORRES = "Fernando Torres";
    private static final String BENZEMA = "Benzema";
    private static final int BASE_SCORE = 5;
    private static final int CHAMPIONS_LEAGUE_SCORE = 3;
    private static final int LEAGUE_SCORE = 2;
    private static final int TEAM_SCORE = 1;
    private static final int PLAYER_SCORE = 1;
    private static final int NO_BONUS = 0;

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
        double totalPrice = BASE_PRICE;

        totalPrice += (competition.equalsIgnoreCase(CHAMPIONS_LEAGUE) ? CHAMPIONS_LEAGUE_BONUS : NO_BONUS);

        totalPrice += (team.equalsIgnoreCase(FC_BARCELONA) ||
                team.equalsIgnoreCase(REAL_MADRID))
                ? TEAM_BONUS : NO_BONUS;

        totalPrice += (player.equalsIgnoreCase(FERNANDO_TORRES) || player.equalsIgnoreCase(BENZEMA))
                ? PLAYER_BONUS : NO_BONUS;

        return totalPrice;
    }

    @Override
    public int calculateScore() {
        int totalScore = BASE_SCORE;

        totalScore += (competition.equalsIgnoreCase(CHAMPIONS_LEAGUE)) ? CHAMPIONS_LEAGUE_SCORE : NO_BONUS;
        totalScore += (competition.equalsIgnoreCase(LEAGUE)) ? LEAGUE_SCORE : NO_BONUS;

        totalScore += (team.equalsIgnoreCase(FC_BARCELONA) ||
                team.equalsIgnoreCase(REAL_MADRID)) ? TEAM_SCORE : NO_BONUS;

        totalScore += (player.equalsIgnoreCase(FERNANDO_TORRES) ||
                player.equalsIgnoreCase(BENZEMA)) ? PLAYER_SCORE : NO_BONUS;

        return totalScore;
    }
}
