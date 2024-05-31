package n3exercise1;

public class MotoRacing extends News{
    private String team;

    public MotoRacing(Journalist journalist, String headline, String team) {
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
        if (team.equalsIgnoreCase("Honda") || team.equalsIgnoreCase("Yamaha")){
            price += 50;
        }
        return price;
    }

    @Override
    public int calculateScore() {
        int score = 3;
        if (team.equalsIgnoreCase("Honda") || team.equalsIgnoreCase("Yamaha")){
            score += 3;
        }
        return score;
    }
}
