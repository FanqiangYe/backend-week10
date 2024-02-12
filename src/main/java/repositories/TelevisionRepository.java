package repositories;

import com.example.TechItEasy.models.Television;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TelevisionRepository extends JpaRepository <Television, Long> {
    Optional<Television> findByNameIgnoreCase(String Name);
}


