package com.example.TechItEasy.repositories;

import com.example.TechItEasy.models.Television;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TelevisionRepository extends JpaRepository <Television, Long> {
    List<Television> findByBrand(String Brand);
}


