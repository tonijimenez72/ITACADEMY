package n2exercise1.service;

import n2exercise1.model.PizzaType;

public class PizzaBuilderService {
    public static PizzaBuilder builder (PizzaType type) {
        return switch (type) {
            case HAWAIIAN -> new HawaiianPizzaBuilder();
            case VEGETARIAN -> new VegetarianPizzaBuilder();
            default -> throw new IllegalArgumentException("Invalid PizzaType: " + type);
        };
    }
}