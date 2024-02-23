package com.example.TechItEasy.services;

import com.example.TechItEasy.exceptions.RecordNotFoundException;
import com.example.TechItEasy.models.Television;
import com.example.TechItEasy.repositories.TelevisionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TelevisionService {

    private final TelevisionRepository televisionRepository;


    public TelevisionService(TelevisionRepository televisionRepository) {
        this.televisionRepository = televisionRepository;
    }

    public List<Television> getTelevisions() {
        return televisionRepository.findAll();
    }

    public Television getTelevision(Long id){
        Optional<Television> optionalTelevision = televisionRepository.findById(id);
        if (optionalTelevision.isEmpty()){
            throw new RecordNotFoundException();
        } else {
            return optionalTelevision.get();
        }
    }

    public void saveTelevision(Television television){
        televisionRepository.save(television);
    }
}
