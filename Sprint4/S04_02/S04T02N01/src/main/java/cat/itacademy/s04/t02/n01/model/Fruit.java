package cat.itacademy.s04.t02.n01.model;

import jakarta.persistence.*;

@Entity
@Table(name="fruits")
public class Fruit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 20)
    private String name;

    @Column(name = "weight_in_kilograms")
    private double weightInKilograms;

    protected Fruit() {
    }

    public Fruit(String name, double weightInKilograms) {
        this.name = name;
        this.weightInKilograms = weightInKilograms;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getWeightInKilograms() {
        return weightInKilograms;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeightInKilograms(double weightInKilograms) {
        this.weightInKilograms = weightInKilograms;
    }
}