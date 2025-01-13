package cat.itacademy.s04.t02.n03.services;

import cat.itacademy.s04.t02.n03.exception.FruitAlreadyExistsException;
import cat.itacademy.s04.t02.n03.exception.FruitNotExistsException;
import cat.itacademy.s04.t02.n03.model.Fruit;
import cat.itacademy.s04.t02.n03.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FruitServiceImpl implements FruitService {
    @Autowired
    private FruitRepository fruitRepository;

    public Fruit addFruit(Fruit fruit){
        fruitRepository.findByName(fruit.getName())
                .ifPresent(fruitAlreadySaved -> {
                    throw new FruitAlreadyExistsException(fruit.getName() + "' already exists in our database.");
                });
        return fruitRepository.save(fruit);
    }

    public Fruit getFruitById(int id) {
        return fruitRepository.findById(id)
                .orElseThrow(() ->
                        new FruitNotExistsException("Fruit with ID " + id  + " doesn't exist in our database.")
                );
    }

    public List<Fruit> getAllFruits() {
        return fruitRepository.findAll();
    }

    public Fruit updateFruit(Fruit fruit) {
        fruitRepository.findById(fruit.getId())
                .orElseThrow(() ->
                        new FruitNotExistsException(
                                String.format("Fruit with ID %d doesn't exist in our database.", fruit.getId()))
                );
        fruitRepository.findByName(fruit.getName())
                .filter(existingFruit -> existingFruit.getId() != fruit.getId())
                .ifPresent(existingFruit -> {
                    throw new FruitAlreadyExistsException(
                            String.format("A fruit with the name '%s' already exists in our database.", fruit.getName()));
                });
        return fruitRepository.save(fruit);
    }

    public void deleteFruit(int id){
        fruitRepository.findById(id)
                .orElseThrow(() ->
                        new FruitNotExistsException("Fruit with ID " + id  + " doesn't exist in our database.")
                );
        fruitRepository.deleteById(id);
    }
}