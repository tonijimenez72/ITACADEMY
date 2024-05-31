package n3exercise1;

public class Soccer extends News{
    private String competition;
    private String team;
    private String player;

    public Soccer(Journalist journalist, String headline, String competition, String team, String player) {
        super(journalist, headline);
        this.competition = competition;
        this.team = team;
        this.player = player;
    }

    public String getCompetition() {
        return competition;
    }
    public String getTeam() {
        return team;
    }
    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }
    public void setTeam(String club) {
        this.team = team;
    }
    public void setCompetition(String competition) {
        this.competition = competition;
    }

    @Override
    public double calculatePrice() {
        double price = 300;
        if (competition.equalsIgnoreCase("Champions League")){
            price += 100;
        }
        if (team.equalsIgnoreCase("FC Barcelona") || team.equalsIgnoreCase("Real Madrid")) {
            price += 100;
        }
        if (player.equalsIgnoreCase("Fernando Torres") || player.equalsIgnoreCase("Benzema")) {
            price += 50;
        }
        return price;
    }

    @Override
    public int calculateScore() {
        int score = 5;
        if (competition.equalsIgnoreCase("Champions League")) {
            score += 3;
        }
        if (competition.equalsIgnoreCase("League")) {
            score += 2;
        }
        if (team.equalsIgnoreCase("FC Barcelona") || team.equalsIgnoreCase("Real Madrid")) {
            score += 1;
        }
        if (player.equalsIgnoreCase("Fernando Torres") || player.equalsIgnoreCase("Benzema")) {
            score += 1;
        }
        return score;
    }
}
