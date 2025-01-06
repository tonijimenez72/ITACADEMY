package cat.itacademy.s04.t02.n02.services;

import cat.itacademy.s04.t02.n02.exception.FruitAlreadyExistsException;
import cat.itacademy.s04.t02.n02.exception.FruitNotExistsException;
import cat.itacademy.s04.t02.n02.model.Fruit;
import cat.itacademy.s04.t02.n02.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FruitServiceImpl {
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
                        new FruitNotExistsException("Fruit with ID " + fruit.getName()  + " doesn't exist in our database.")
                );
        return fruitRepository.save(fruit);
    }

    public void deleteFruitById(int id){
        fruitRepository.findById(id)
                .orElseThrow(() ->
                        new FruitNotExistsException("Fruit with ID " + id  + " doesn't exist in our database.")
                );
        fruitRepository.deleteById(id);
    }
}
