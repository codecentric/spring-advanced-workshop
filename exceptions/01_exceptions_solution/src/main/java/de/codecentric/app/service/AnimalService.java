package de.codecentric.app.service;

import de.codecentric.app.exception.AnimalNotFoundException;
import de.codecentric.app.exception.InvalidAnimalDataException;
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

    // Lösung 1.1
    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    public Animal getAnimalById(Long id) {
        // Lösung 1.2
        return animalRepository.findById(id).orElseThrow(() -> new AnimalNotFoundException("Animal not found with id " + id));
    }

    public Animal saveAnimal(Animal animal) {
        // Lösung Bonus.1
        if (animal.getName() == null || animal.getName().isEmpty()) {
            throw new InvalidAnimalDataException("Animal name must not be empty.");
        }
        return animalRepository.save(animal);
    }

    public void deleteAnimal(Long id) {
        // Lösung 1.3
        if (!animalRepository.existsById(id)) {
            throw new AnimalNotFoundException("Animal not found with id " + id);
        }
        animalRepository.deleteById(id);
    }
}
