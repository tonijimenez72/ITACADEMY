package n3exercise1.news;

import n3exercise1.journalist.Journalist;

public abstract class News {
    private int score;
    private double price;
    private String headline;
    private String body;
    private Journalist journalist;

    public News(Journalist journalist, String headline, String body) {
        this.journalist = journalist;
        this.headline = headline;
        this.body = body;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Journalist getJournalist() {
        return journalist;
    }

    public void setJournalist(Journalist journalist) {
        this.journalist = journalist;
    }

    public abstract int calculateScore();
    public abstract double calculatePrice();

    @Override
    public String toString() {
        return headline + "\n"
                + body + "\n";
    }
    // "Price: " + calculatePrice() + "\n"
    // "Score: " + calculateScore() + "\n

}