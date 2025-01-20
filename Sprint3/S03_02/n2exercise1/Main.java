package n2exercise1;

import n2exercise1.model.Pizza;
import n2exercise1.model.PizzaType;

public class Main {
    public static void main(String[] args) {
        Pizza pizza1 = Pizza.builder(PizzaType.HAWAIIAN)
                .setSize("Large")
                .setDough("American")
                .build();

        Pizza pizza2 = Pizza.builder(PizzaType.VEGETARIAN)
                .setSize("Small")
                .setDough("Roman")
                .setExtraToppings("garlic", "mushroom")
                .build();

        System.out.println(pizza1.toString());
        System.out.println(pizza2.toString());
    }
}