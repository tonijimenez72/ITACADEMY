package cat.itacademy.s04.t02.n01.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Fruit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int weightInKg;

    public Fruit() {}

    public Fruit(String name, int weightInKg) {
        this.name = name;
        this.weightInKg = weightInKg;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getWeightInKg() {
        return weightInKg;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setWeightInKg(int weightInKg) {
        this.weightInKg = weightInKg;
    }
}