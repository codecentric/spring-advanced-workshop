package de.codecentric.app;

import de.codecentric.app.model.Animal;
import de.codecentric.app.model.Type;
import de.codecentric.app.repository.AnimalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AnimalRepository animalRepository;

    @BeforeEach
    public void setup() {
        animalRepository.deleteAll();

        Animal cow = new Animal();
        cow.setName("Cow");
        cow.setType(Type.MAMMAL);
        animalRepository.save(cow);

        Animal chicken = new Animal();
        chicken.setName("Chicken");
        chicken.setType(Type.BIRD);
        animalRepository.save(chicken);
    }

    @Test
    public void testGetAllAnimals() throws Exception {
        mockMvc.perform(get("/animals"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name", is("Cow")))
                .andExpect(jsonPath("$[1].name", is("Chicken")));
    }

    @Test
    public void testGetAnimalById() throws Exception {
        List<Animal> animals = animalRepository.findAll();
        Animal savedAnimal = animals.get(0);

        mockMvc.perform(get("/animals/" + savedAnimal.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("Cow")));
    }

    @Test
    public void testGetAnimalByIdNotFound() throws Exception {
        mockMvc.perform(get("/animals/999"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$", is("Animal not found with id 999")));
    }

    @Test
    public void testCreateAnimal() throws Exception {
        String animalJson = "{ \"name\": \"Horse\", \"type\": \"MAMMAL\" }";

        mockMvc.perform(post("/animals")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(animalJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name", is("Horse")));
    }

    @Test
    public void testDeleteAnimal() throws Exception {
        List<Animal> animals = animalRepository.findAll();
        Animal savedAnimal = animals.get(0);

        mockMvc.perform(delete("/animals/" + savedAnimal.getId()))
                .andExpect(status().isNoContent());
    }

    @Test
    public void testDeleteAnimalNotFound() throws Exception {
        mockMvc.perform(delete("/animals/999"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$", is("Animal not found with id 999")));
    }

    @Test
    public void testInvalidAnimalData() throws Exception {
        // TODO Bonusaufgabe
    }
}

