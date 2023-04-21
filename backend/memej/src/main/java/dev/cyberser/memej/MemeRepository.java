package dev.cyberser.memej;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface MemeRepository extends JpaRepository<Meme, Long> {
    
}
