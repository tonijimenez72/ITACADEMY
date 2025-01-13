package n1exercise1.entity;

import n1exercise1.service.PizzaBuilder;
import n1exercise1.service.PizzaBuilderService;

import java.util.List;

public class Pizza {
    private PizzaType type;
    private String size;
    private String dough;
    private List<String> toppings;
    private List<String> extraToppings;

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

    public List<String> getExtraToppings() {
        return extraToppings;
    }

    public void setType(PizzaType type) {
        this.type = type;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setDough(String dough) {
        this.dough = dough;
    }

    public void setToppings(List<String> toppings) {
        this.toppings = toppings;
    }

    public void setExtraToppings(List<String> extraToppings) {
        this.extraToppings = extraToppings;
    }

    public static PizzaBuilder builder (PizzaType type) {
        return PizzaBuilderService.builder(type);
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "type=" + type +
                ", size='" + size + '\'' +
                ", dough='" + dough + '\'' +
                ", toppings=" + toppings +
                ", extraToppings=" + extraToppings +
                '}';
    }
}
