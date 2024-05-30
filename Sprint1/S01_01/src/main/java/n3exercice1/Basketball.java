package n3exercice1;

public class Basketball extends News {
    private String competition;
    private String team;

    public Basketball(Journalist journalist, String headline, String competition, String team) {
        super(journalist, headline);
        this.competition = competition;
        this.team = team;
    }

    public String getCompetition() {
        return competition;
    }
    public String getTeam() {
        return team;
    }

    public void setTeam(String club) {
        this.team = team;
    }
    public void setCompetition(String competition) {
        this.competition = competition;
    }

    @Override
    public double calculatePrice() {
        double price = 250;
        if (competition.equalsIgnoreCase("Euroleague")){
            price += 75;
        }
        if (team.equalsIgnoreCase("FC Barcelona") || team.equalsIgnoreCase("Real Madrid")){
            price += 75;
        }
        return price;
    }

    @Override
    public int calculateScore() {
        int score = 4;
        if (competition.equalsIgnoreCase("Euroleague")){
            score += 3;
        }
        if (competition.equalsIgnoreCase("ACB")){
            score += 2;
        }
        if (team.equalsIgnoreCase("FC Barcelona") || team.equalsIgnoreCase("Real Madrid")) {
            score += 1;
        }
        return score;
    }
}