package n2exercise1.service;

import n2exercise1.model.Pizza;

public interface PizzaBuilder {
    PizzaBuilder setSize (String size);
    PizzaBuilder setDough (String dough);
    PizzaBuilder setToppings (String... toppings);
    PizzaBuilder setExtraToppings (String... extraToppings);
    Pizza build();
}