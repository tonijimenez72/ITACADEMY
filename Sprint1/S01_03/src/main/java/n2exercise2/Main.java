package n2exercise2;

import java.util.Set;

public class Main {
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {
        Set<Restaurant> restaurants = PopulateRestaurant.getRestaurants();
        System.out.println(ANSI_YELLOW + "The exercise statement asks:\n"  + ANSI_RESET
                + "Sorted by name and by score in ASCENDING order.\n");
        for (Restaurant restaurant : restaurants) {
            System.out.println("Restaurant: " + restaurant.getName() + ", Score: " + restaurant.getScore());
        }
    }
}
