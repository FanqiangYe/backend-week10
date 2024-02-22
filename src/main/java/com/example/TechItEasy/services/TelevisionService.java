package com.example.TechItEasy.services;

import com.example.TechItEasy.models.Television;
import com.example.TechItEasy.repositories.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelevisionService {

    private final TelevisionRepository televisionRepository;

    @Autowired
    public TelevisionService(TelevisionRepository televisionRepository) {
        this.televisionRepository = televisionRepository;
    }

    public List<Television> getTelevisions() {
        return televisionRepository.findAll();
    }

    public Television getTelevision(){
        Television televisionFound == getTelevisions(id);
    }
}
