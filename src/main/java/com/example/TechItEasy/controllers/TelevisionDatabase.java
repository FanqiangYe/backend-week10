package com.example.TechItEasy.controllers;

import com.example.TechItEasy.exceptions.RecordNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = ("/database"))
public class TelevisionDatabase {

    private static final List<String> televisionDatabase = new ArrayList<>();

    @GetMapping("/televisions")
    public ResponseEntity<List<String>> getTelevisionDatabase() {
        return ResponseEntity.ok(televisionDatabase);
    }


    @GetMapping("/televisions/{id}")
    public ResponseEntity<Object> getTelevision(@PathVariable int id) {
        return ResponseEntity.ok(televisionDatabase.get(id));
    }

    @PostMapping("/televisions")
    public ResponseEntity<Object> addTelevision(@RequestBody String television) {
        televisionDatabase.add(television);
        return ResponseEntity.created(null).body(television);
    }


    @DeleteMapping("/televisions/{id}")
    public ResponseEntity<Object> deleteTelevision(@PathVariable int id) {
        televisionDatabase.set(id, null);
        return ResponseEntity.noContent().build();
    }


        @PutMapping("/televisions/{id}")
        public ResponseEntity<Object> updateTelevision ( @PathVariable int id, @RequestBody String television){
            if (televisionDatabase.isEmpty() || id > televisionDatabase.size()) {
                throw new RecordNotFoundException("Record met id: " + id + " niet gevonden in de database.");
            } else {

                televisionDatabase.set(id, television);

                return ResponseEntity.noContent().build();
            }

        }

    }

    // Waarom ontvang ik lege array in localhost 8080
