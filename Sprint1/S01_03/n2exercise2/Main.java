package n2exercise2;

import n2exercise2.sampleData.SampleData;
import n2exercise2.restaurant.Restaurant;

import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Set<Restaurant> restaurants = SampleData.getRestaurants();

        System.out.println("""
        The exercise statement demands:
        Sorted by name and by score in ASCENDING order.
        There cannot be restaurants with same name and same score.
        """);

        for (Restaurant restaurant : restaurants) {
            System.out.println("Restaurant: " + restaurant.getName() + ", Score: " + restaurant.getScore());
        }
    }
}
