package cat.itacademy.s04.t02.n01.services;

import cat.itacademy.s04.t02.n01.model.Fruit;
import cat.itacademy.s04.t02.n01.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitService {

    @Autowired
    private FruitRepository fruitRepository;

    public List<Fruit> getAllFruits() {
        return fruitRepository.findAll();
    }

    public Optional<Fruit> getFruitById(int id) {
        return fruitRepository.findById(id);
    }

    public Fruit addFruit(Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    public Fruit updateFruit(int id, Fruit fruitDetails) {
        Optional<Fruit> fruitOptional = fruitRepository.findById(id);

        if (fruitOptional.isPresent()) {
            Fruit fruit = fruitOptional.get();
            fruit.setName(fruitDetails.getName());
            fruit.setWeightInKg(fruitDetails.getWeightInKg());
            return fruitRepository.save(fruit);
        } else {
            return null;
        }
    }

    public void deleteFruit(int id) {
        fruitRepository.deleteById(id);
    }
}