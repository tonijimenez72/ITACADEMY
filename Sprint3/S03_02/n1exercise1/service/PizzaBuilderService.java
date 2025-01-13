package n1exercise1.service;

import n1exercise1.entity.PizzaType;

public class PizzaBuilderService {
    public static PizzaBuilder builder (PizzaType type) {
        return switch (type) {
            case HAWAIIAN -> new HawaiianPizzaBuilder();
            case VEGETARIAN -> new VegetarianPizzaBuilder();
            default -> throw new IllegalArgumentException("Invalid PizzaType: " + type);
        };
    }
}