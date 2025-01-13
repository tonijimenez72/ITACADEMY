package n1exercise1.service;

import n1exercise1.entity.Pizza;
import n1exercise1.entity.PizzaType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HawaiianPizzaBuilder implements PizzaBuilder {
    private final PizzaType type = PizzaType.HAWAIIAN;
    private String size;
    private String dough;
    private List<String> toppings = Arrays.asList("ham", "pineapple");
    private List<String> extraToppings = new ArrayList<>();

    public PizzaType getType() {
        return type;
    }

    public String getSize() {
        return size;
    }

    public String getDough() {
        return dough;
    }

    public List<String> getToppings() {
        return toppings;
    }

    private List<String> getExtraToppings() {
        return extraToppings;
    }

    @Override
    public PizzaBuilder setSize(String size) {
        this.size = size;
        return this;
    }

    @Override
    public PizzaBuilder setDough(String dough) {
        this.dough = dough;
        return this;
    }

    @Override
    public PizzaBuilder setExtraToppings(String... extraToppings) {
        this.extraToppings = Arrays.asList(extraToppings);
        return this;
    }

    @Override
    public PizzaBuilder setToppings(String... toppings) {
        if (toppings!=null) {
            this.toppings=Arrays.asList(toppings);
        }
        return this;
    }

    @Override
    public Pizza build() {
        Pizza pizza = new Pizza();
        pizza.setType(getType());
        pizza.setToppings(getToppings());
        pizza.setSize(getSize());
        pizza.setDough(getDough());
        pizza.setExtraToppings(getExtraToppings());
        return pizza;
    }
}