package ch.zhaw.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zhaw.springboot.entities.Airing;

public interface AiringRepository extends JpaRepository<Airing, Long> {
    
}
