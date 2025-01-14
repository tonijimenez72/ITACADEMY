package cat.itacademy.s04.t02.n01.services;

import cat.itacademy.s04.t02.n01.model.Fruit;

import java.util.List;

public interface FruitService {
    Fruit addFruit(Fruit fruit);
    Fruit getFruitById(int id);
    List<Fruit> getAllFruits();
    Fruit updateFruit(Fruit fruit);
    void deleteFruit(int id);
}