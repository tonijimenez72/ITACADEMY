package n2exercise1;

import n2exercise1.restaurant.Restaurant;
import n2exercise1.sampleData.SampleData;

import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        SampleData sampleData = new SampleData();
        HashSet<Restaurant> restaurants = sampleData.getRestaurants();

        for (Restaurant restaurant : restaurants) {
            System.out.println("Restaurant: " + restaurant.getName() + ", Score: " + restaurant.getScore());
        }
    }
}