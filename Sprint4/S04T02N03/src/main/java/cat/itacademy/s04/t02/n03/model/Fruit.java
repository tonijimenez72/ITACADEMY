package cat.itacademy.s04.t02.n03.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "fruits")
public class Fruit {

    @Id
    private String id;

    private String name;
    private double weightInKilograms;

    public Fruit() {}

    public Fruit(String name, double weightInKilograms) {
        this.name = name;
        this.weightInKilograms = weightInKilograms;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getWeightInKilograms() {
        return weightInKilograms;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeightInKilograms(double weightInKilograms) {
        this.weightInKilograms = weightInKilograms;
    }
}
