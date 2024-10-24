package n2exercice1;

import java.util.HashSet;

public class PopulateRestaurant {

    public static HashSet<Restaurant> getRestaurants() {
        HashSet<Restaurant> restaurants = new HashSet<>();

        Restaurant restaurant1 = new Restaurant("Bodega Montferry", 5);
        Restaurant restaurant2 = new Restaurant("Bodega Montferry", 5);
        Restaurant restaurant3 = new Restaurant("La Mestressa", 4);
        Restaurant restaurant4 = new Restaurant("La Mestressa", 5);

        restaurants.add(restaurant1);
        restaurants.add(restaurant2);
        restaurants.add(restaurant3);
        restaurants.add(restaurant4);

        return restaurants;
    }
}