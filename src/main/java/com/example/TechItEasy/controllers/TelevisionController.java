package com.example.TechItEasy.controllers;

import com.example.TechItEasy.DTOS.TelevisionDto;
import com.example.TechItEasy.DTOS.TelevisionInputDto;
import com.example.TechItEasy.models.Television;
import com.example.TechItEasy.services.TelevisionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/televisions")
public class TelevisionController {

    private final TelevisionService televisionService;

    public TelevisionController(TelevisionService televisionService)
    {
        this.televisionService = televisionService;
    }


    @GetMapping
    public ResponseEntity<List<TelevisionDto>> getTelevisions() {
        return ResponseEntity.ok(televisionService.getTelevisions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TelevisionDto> getTelevision(@PathVariable long id) {
        TelevisionDto television = televisionService.getTelevision(id);

        return ResponseEntity.ok(television);
    }

    @PostMapping
    public ResponseEntity<Void> addTelevision(@RequestBody TelevisionInputDto television) {
        televisionService.saveTelevision(television);
        return ResponseEntity.created(null).build();
    }


    @PutMapping("/{id}")
    public ResponseEntity<Void> updateTelevision(@PathVariable long id, @RequestBody TelevisionInputDto updatedTelevision) {
        televisionService.updateTelevision(id, updatedTelevision);
        return ResponseEntity.noContent().build();
    }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteTelevision ( @PathVariable long id){
        televisionService.removeTelevision(id);
        return ResponseEntity.noContent().build();
        }
    }

