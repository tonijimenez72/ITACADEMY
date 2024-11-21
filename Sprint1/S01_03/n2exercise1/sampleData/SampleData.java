package n2exercise1.sampleData;

import n2exercise1.restaurant.Restaurant;

import java.util.HashSet;

public class SampleData {
    public static HashSet<Restaurant> getRestaurants() {
        HashSet<Restaurant> restaurants = new HashSet<>();

        Restaurant restaurant1 = new Restaurant("Restaurant One", 5);
        Restaurant restaurant2 = new Restaurant("Restaurant One", 5);  // Duplicado por nombre y puntaje
        Restaurant restaurant3 = new Restaurant("Restaurant Two", 4);
        Restaurant restaurant4 = new Restaurant("Restaurant Two", 5);
        Restaurant restaurant5 = new Restaurant("Restaurant Three", 3);

        restaurants.add(restaurant1);
        restaurants.add(restaurant2);
        restaurants.add(restaurant3);
        restaurants.add(restaurant4);
        restaurants.add(restaurant5);

        return restaurants;
    }
}