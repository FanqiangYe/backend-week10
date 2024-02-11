package com.example.TechItEasy.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TelevisionController {

    @RequestMapping("/televisions")

    @GetMapping("/televisions")
    public ResponseEntity<String> getAllTelevisions(){
        return ResponseEntity.ok("televisions");
    }

    @GetMapping("/televisions/{id}")
    public ResponseEntity<Object> getTelevision(@PathVariable long id){
        return ResponseEntity.ok("televisions with id: " + id);
    }

    @PostMapping("/televisions")
    public ResponseEntity<Object> addTelevision(@RequestBody String television){
        return ResponseEntity.created(null).body("Television");
    }

    @PutMapping("televisions/{id}")
    public ResponseEntity<Void> updateTelevision(@PathVariable long id, @RequestBody String television){
       return ResponseEntity.noContent().build();
    }

    @DeleteMapping("televisions/{id}")
    public ResponseEntity<Void> deleteTelevision(@PathVariable long id){
        return ResponseEntity.noContent().build();
    }



}
