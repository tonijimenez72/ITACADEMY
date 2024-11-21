package n2exercise2.sampleData;

import n2exercise2.restaurant.Restaurant;

import n2exercise2.restaurant.Restaurant;
import java.util.Set;
import java.util.TreeSet;

public class SampleData {

    public static Set<Restaurant> getRestaurants() {
        Set<Restaurant> restaurants = new TreeSet<>();

        Restaurant restaurant1 = new Restaurant("Restaurant One", 5);
        Restaurant restaurant2 = new Restaurant("Restaurant One", 5);
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

