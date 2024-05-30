package n3exercice1;

import java.util.ArrayList;

public class Journalist {
    private final double BASESALARY;
    private String name;
    private final String idCard;
    private ArrayList<News> newsByJournalist = new ArrayList<>();

    public Journalist(String name, String idCard) {
        this.name = name;
        this.idCard = idCard;
        this.BASESALARY = 1500;
        this.newsByJournalist = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public String getIdCard() {
        return idCard;
    }
    public double getBASESALARY() {
        return BASESALARY;
    }
    public ArrayList<News> getNewsByJournalist() {
        return newsByJournalist;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + "with ID Card " + idCard + ". Base salary: " + BASESALARY + "\n";
    }
}
