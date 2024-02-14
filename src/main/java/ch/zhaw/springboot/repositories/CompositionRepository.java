package ch.zhaw.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zhaw.springboot.entities.Composition;

public interface CompositionRepository extends JpaRepository<Composition, Long> {
    
}
