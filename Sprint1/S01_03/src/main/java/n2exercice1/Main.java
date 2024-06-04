package n2exercice1;

import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        HashSet<Restaurant> restaurants = PopulateRestaurant.getRestaurants();

        for (Restaurant restaurant : restaurants) {
            System.out.println("Restaurant: " + restaurant.getName() + ", Score: " + restaurant.getScore());
        }
    }
}