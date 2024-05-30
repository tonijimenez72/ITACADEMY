package n3exercice1;

abstract class News {
    private Journalist journalist;//revisar
    private String headline;
    private String body;
    private int score;
    private double price;

    public News(Journalist journalist, String headline) {
        this.journalist = journalist;
        this.headline = headline;
    }

    public Journalist getJournalist() {
        return journalist;
    }
    public String getHeadline() {
        return headline;
    }
    public String getBody() {
        return body;
    }
    public int getScore() {
        return score;
    }
    public double getPrice() {
        return price;
    }

    public void setJournalist(Journalist journalist) {
        this.journalist = journalist;
    }
    public void setHeadline(String headline) {
        this.headline = headline;
    }
    public void setBody(String body) {
        this.body = body;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public abstract int calculateScore();
    public abstract double calculatePrice();
}


