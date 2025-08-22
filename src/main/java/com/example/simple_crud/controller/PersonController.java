package com.example.simple_crud.controller;

import com.example.simple_crud.model.Person;
import com.example.simple_crud.repository.PersonRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private final PersonRepository personRepo;

    public PersonController(PersonRepository personRepo) {
        this.personRepo = personRepo;
    }

    // ==============================
    // 1️⃣ Browser GET request with query params
    // Example: http://localhost:8080/addPerson?name=Andrew&email=andrew@example.com
    // ==============================
    @GetMapping("/addPerson")
    public String addPersonViaGet(@RequestParam String name, @RequestParam String email) {
        Person p = new Person();
        p.setName(name);
        p.setEmail(email);
        personRepo.save(p);
        return "Person added via GET: " + name;
    }

    // ==============================
    // 2️⃣ Postman / Frontend POST request with JSON body
    // Example POST: http://localhost:8080/api/persons/add
    // Body (raw JSON):
    // { "name": "Andrew", "email": "andrew@example.com" }
    // ==============================
    @PostMapping("/add")
    public Person addPersonViaPost(@RequestBody Person person) {
        return personRepo.save(person);
    }

    // ==============================
    // Extra: Get all persons (for testing)
    // Example GET: http://localhost:8080/api/persons/all
    // ==============================
    @GetMapping("/all")
    public List<Person> getAllPersons() {
        return personRepo.findAll();
    }
}
