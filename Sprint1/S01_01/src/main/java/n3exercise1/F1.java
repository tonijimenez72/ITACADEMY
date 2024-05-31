package n3exercise1;

public class F1 extends News{
    private String team;

    public F1(Journalist journalist, String headline, String team) {
        super(journalist, headline);
        this.team = team;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String club) {
        this.team = team;
    }

    @Override
    public double calculatePrice() {
        double price = 100;
        if (team.equalsIgnoreCase("Ferrari") || team.equalsIgnoreCase("Mercedes")){
            price += 50;
        }
        return price;
    }

    @Override
    public int calculateScore() {
        int score = 4;
        if (team.equalsIgnoreCase("Ferrari") || team.equalsIgnoreCase("Mercedes")){
            score += 2;
        }
       return score;
    }
}
