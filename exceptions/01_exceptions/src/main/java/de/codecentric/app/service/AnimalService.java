package de.codecentric.app.service;

import de.codecentric.app.model.Animal;
import de.codecentric.app.repository.AnimalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    // TODO
    public List<Animal> getAllAnimals() {
        return null;
    }

    public Animal getAnimalById(Long id) {
        return null;
    }

    public Animal saveAnimal(Animal animal) {
        return null;
    }

    public void deleteAnimal(Long id) {

    }
}
