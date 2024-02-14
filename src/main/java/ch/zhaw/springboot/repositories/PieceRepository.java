package ch.zhaw.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zhaw.springboot.entities.Piece;

public interface PieceRepository extends JpaRepository<Piece, Long> {
    
}
