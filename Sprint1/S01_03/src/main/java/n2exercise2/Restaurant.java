package n2exercise2;

import java.util.Objects;

public class Restaurant implements Comparable<Restaurant> {
    private String name;
    private int score;

    public Restaurant(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public boolean equals(Object restaurant) {
        if (this == restaurant)
            return true;
        if (restaurant == null || getClass() != restaurant.getClass())
            return false;
        Restaurant other = (Restaurant) restaurant;
        return score == other.score && Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score);
    }

    @Override
    public int compareTo(Restaurant other) {
        int nameComparison = this.name.compareTo(other.name);
        if (nameComparison != 0) {
            return nameComparison;
        }
        return Integer.compare(this.score, other.score);
    }
}