package de.codecentric.fieldservice.controller;

import de.codecentric.fieldservice.model.Field;
import de.codecentric.fieldservice.repository.FieldRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fields")
public class FieldController {

    private final FieldRepository fieldRepository;

    public FieldController(FieldRepository fieldRepository) {
        this.fieldRepository = fieldRepository;
    }

    // Lösung 2.1
    @GetMapping
    public List<Field> getAllFields() {
        return fieldRepository.findAll();
    }

    @GetMapping("/{id}")
    public Field getFieldById(@PathVariable Long id) {
        return fieldRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Field createField(@RequestBody Field field) {
        return fieldRepository.save(field);
    }
}
