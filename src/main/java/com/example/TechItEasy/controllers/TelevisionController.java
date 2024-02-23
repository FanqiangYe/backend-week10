package com.example.TechItEasy.controllers;

import com.example.TechItEasy.exceptions.RecordNotFoundException;
import com.example.TechItEasy.models.Television;
import com.example.TechItEasy.services.TelevisionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/televisions")
public class TelevisionController {

    private final TelevisionService televisionService;

    public TelevisionController(TelevisionService televisionService) {
        this.televisionService = televisionService;
    }


    @GetMapping
    public ResponseEntity<List<Television>> getAllTelevisions() {
        return ResponseEntity.ok(televisionService.getTelevisions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getTelevision(@PathVariable long id) {
        Television television = televisionService.getTelevision(id);
            return ResponseEntity.ok(television);
    }

    @PostMapping
    public ResponseEntity<Void> addTelevision(@RequestBody Television television) {
        televisionService.saveTelevision(television);
        return ResponseEntity.created(null).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Television> updateTelevision(@PathVariable long id, @RequestBody Television updatedTelevision) {
        Optional<Television> optionalTelevision = televisionService.findById(id);

        if (optionalTelevision.isPresent()) {
            Television existingTelevision = optionalTelevision.get();
            existingTelevision.setBrand(updatedTelevision.getBrand());
            existingTelevision.setName(updatedTelevision.getName());
            existingTelevision.setPrice(updatedTelevision.getPrice());
            existingTelevision.setAvailableSize(updatedTelevision.getAvailableSize());
            existingTelevision.setRefreshRate(updatedTelevision.getRefreshRate());
            existingTelevision.setScreenType(updatedTelevision.getScreenType());
            existingTelevision.setScreenQuality(updatedTelevision.getScreenQuality());
            existingTelevision.setSmartTv(updatedTelevision.getSmartTv());
            existingTelevision.setWifi(updatedTelevision.getWifi());
            existingTelevision.setVoiceControl(updatedTelevision.getVoiceControl());
            existingTelevision.setHdr(updatedTelevision.getHdr());
            existingTelevision.setBluetooth(updatedTelevision.getBluetooth());
            existingTelevision.setAmbiLight(updatedTelevision.getAmbiLight());
            existingTelevision.setOriginalStock(updatedTelevision.getOriginalStock());
            existingTelevision.setSold(updatedTelevision.getSold());

            Television updatedTelevisionEntity = televisionService.save(existingTelevision);

            return ResponseEntity.ok(updatedTelevisionEntity);
        } else {
            throw new RecordNotFoundException("Television not found with id: " + id);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTelevision(@PathVariable long id) {
        Optional<Television> optionalTelevision = televisionService.findById(id);
        if (optionalTelevision.isPresent()) {
            televisionService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            throw new RecordNotFoundException("Television not found with id: " + id);
        }
    }
}
