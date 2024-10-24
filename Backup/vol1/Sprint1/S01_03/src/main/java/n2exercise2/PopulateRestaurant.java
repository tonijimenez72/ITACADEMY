package n2exercise2;

import java.util.Set;
import java.util.TreeSet;

public class PopulateRestaurant {

    public static Set<Restaurant> getRestaurants() {
        Set<Restaurant> restaurants = new TreeSet<>();

        Restaurant restaurant1 = new Restaurant("La Mestressa", 4);
        Restaurant restaurant2 = new Restaurant("La Mestressa", 5);
        Restaurant restaurant3 = new Restaurant("Bodega Montferry", 5);
        Restaurant restaurant4 = new Restaurant("Bodega Montferry", 5);
        Restaurant restaurant5 = new Restaurant("Bodega Montferry", 3);

        restaurants.add(restaurant1);
        restaurants.add(restaurant2);
        restaurants.add(restaurant3);
        restaurants.add(restaurant4);
        restaurants.add(restaurant5);

        return restaurants;
    }
}

