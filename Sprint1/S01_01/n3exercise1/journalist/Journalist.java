package n3exercise1.journalist;

import n3exercise1.news.News;

import java.util.ArrayList;

public class Journalist {
    private static final double BASESALARY = 1500;
    private String name;
    private final String idCard;
    private ArrayList<News> newsByJournalist;

    public Journalist(String name, String idCard) {
        this.name = name;
        this.idCard = idCard;
        this.newsByJournalist = new ArrayList<>();
    }

    public double getBASESALARY() {
        return BASESALARY;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public ArrayList<News> getNewsByJournalist() {
        return newsByJournalist;
    }

    public void setNewsByJournalist(ArrayList<News> newsByJournalist) {
        this.newsByJournalist = newsByJournalist;
    }

    @Override
    public String toString() {
        return name + " with ID Card " + idCard + ". Base salary: " + BASESALARY;
    }
}