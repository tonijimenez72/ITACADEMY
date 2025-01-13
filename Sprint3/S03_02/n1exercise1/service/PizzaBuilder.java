package n1exercise1.service;

import n1exercise1.entity.Pizza;

public interface PizzaBuilder {
    PizzaBuilder setSize (String size);
    PizzaBuilder setDough (String dough);
    PizzaBuilder setToppings (String... toppings);
    PizzaBuilder setExtraToppings (String... extraToppings);
    Pizza build();
}