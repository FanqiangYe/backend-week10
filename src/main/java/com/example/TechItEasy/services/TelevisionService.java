package com.example.TechItEasy.services;

import com.example.TechItEasy.DTOS.RequestTelevisionDto;
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

    public void saveTelevision(RequestTelevisionDto dto){
        Television television = new Television();
        television.setBrand(dto.getBrand());
        television.setName(dto.getName());
        television.setPrice(dto.getPrice());
        television.setAvailableSize(dto.getAvailableSize());
        television.setRefreshRate(dto.getRefreshRate());
        television.setScreenType(dto.getScreenType());
        television.setScreenQuality(dto.getScreenQuality());
        television.setSmartTv(dto.getSmartTv());
        television.setWifi(dto.getWifi());
        television.setVoiceControl(dto.getVoiceControl());
        television.setHdr(dto.getHdr());
        television.setBluetooth(dto.getBluetooth());
        television.setAmbiLight(dto.getAmbiLight());
        television.setOriginalStock(dto.getOriginalStock());
        television.setSold(dto.getSold());
    televisionRepository.save(television);
    }
}
