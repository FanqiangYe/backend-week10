package com.example.TechItEasy.services;

import com.example.TechItEasy.DTOS.TelevisionDto;
import com.example.TechItEasy.DTOS.TelevisionInputDto;
import com.example.TechItEasy.exceptions.RecordNotFoundException;
import com.example.TechItEasy.models.Television;
import com.example.TechItEasy.repositories.TelevisionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TelevisionService {

    private final TelevisionRepository televisionRepository;


    public TelevisionService(TelevisionRepository televisionRepository) {
        this.televisionRepository = televisionRepository;
    }

    public List<TelevisionDto> getTelevisions()
    {
        List <Television> televisions = televisionRepository.findAll();
        List <TelevisionDto> televisionDtos = new ArrayList<>();

        for (Television television : televisions){
            TelevisionDto dto = toDto(television);

            televisionDtos.add(dto);
        }
        return televisionDtos;
    }

    public TelevisionDto getTelevision(Long id) {
        Optional<Television> optionalTelevision = televisionRepository.findById(id);
        if (optionalTelevision.isEmpty()) {
            throw new RecordNotFoundException("Television with id " + id + " not found");
        } else {
            return toDto(optionalTelevision.get());
        }
    }

    public void saveTelevision(TelevisionInputDto dto) {
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

    public void updateTelevision(Long id, TelevisionInputDto updatedTelevision) {
        Optional<Television> optionalTelevision = televisionRepository.findById(id);

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

            Television updatedTelevisionEntity = televisionRepository.save(existingTelevision);

        } else {
            throw new RecordNotFoundException("Television not found with id: " + id);
        }
    }

    public void removeTelevision(Long id) {
        Optional<Television> optionalTelevision = televisionRepository.findById(id);
        if (optionalTelevision.isPresent()) {
            televisionRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("Television not found with id: " + id);
        }
    }

    public static TelevisionDto toTelevisionDto(Television television) {
        TelevisionDto televisionDto = new TelevisionDto();

        televisionDto.setId(television.getId());
        televisionDto.setBrand(television.getBrand());
        televisionDto.setName(television.getName());
        televisionDto.setPrice(television.getPrice());
        televisionDto.setAvailableSize(television.getAvailableSize());
        televisionDto.setRefreshRate(television.getRefreshRate());
        televisionDto.setScreenType(television.getScreenType());
        televisionDto.setScreenQuality(television.getScreenQuality());
        televisionDto.setSmartTv(television.getSmartTv());
        televisionDto.setWifi(television.getWifi());
        televisionDto.setVoiceControl(television.getVoiceControl());
        televisionDto.setHdr(television.getHdr());
        televisionDto.setBluetooth(television.getBluetooth());
        televisionDto.setAmbiLight(television.getAmbiLight());

        return televisionDto;
    }

    public Television toTelevision(TelevisionInputDto dto) {
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

        return television;
    }

    private TelevisionDto toDto(Television television){
        TelevisionDto dto = new TelevisionDto();
        dto.setBrand(television.getBrand());
        dto.setName(television.getName());
        dto.setPrice(television.getPrice());
        dto.setAvailableSize(television.getAvailableSize());
        dto.setRefreshRate(television.getRefreshRate());
        dto.setScreenType(television.getScreenType());
        dto.setScreenQuality(television.getScreenQuality());
        dto.setSmartTv(television.getSmartTv());
        dto.setWifi(television.getWifi());
        dto.setVoiceControl(television.getVoiceControl());
        dto.setHdr(television.getHdr());
        dto.setBluetooth(television.getBluetooth());
        dto.setAmbiLight(television.getAmbiLight());

        return dto;
    }

}


