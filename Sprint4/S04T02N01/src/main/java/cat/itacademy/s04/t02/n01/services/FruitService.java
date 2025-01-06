package cat.itacademy.s04.t02.n01.services;

import cat.itacademy.s04.t02.n01.model.Fruit;

import java.util.List;
import java.util.Optional;

public interface FruitService {
    Fruit addFruit(Fruit fruit);
    Fruit updateFruit(int id, Fruit fruit);
    void deleteFruit(int id);
    Optional<Fruit> getFruitById(int id);
    List<Fruit> getAllFruits();
}