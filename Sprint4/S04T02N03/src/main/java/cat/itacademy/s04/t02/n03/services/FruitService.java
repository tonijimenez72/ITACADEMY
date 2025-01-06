package cat.itacademy.s04.t02.n03.services;

import cat.itacademy.s04.t02.n03.model.Fruit;

import java.util.List;
import java.util.Optional;

public interface FruitService {
    Fruit addFruit(Fruit fruit);
    Fruit updateFruit(String id, Fruit fruit);
    void deleteFruit(String id);
    Optional<Fruit> getFruitById(String id);
    List<Fruit> getAllFruits();
}