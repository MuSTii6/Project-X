package ch.zhaw.springboot.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ch.zhaw.springboot.entities.Concert;

public interface ConcertRepository extends JpaRepository<Concert, Long> {
    @Query("SELECT id, name FROM Concert")
    public List<Concert> findAllWithoutLocation();

    @Query("SELECT p1.concert, p2.concert FROM Airing p1, Airing p2 WHERE p1.music = p2.music AND p1.concert <> p2.concert")
    public List<Arrays> findConcertPairedByMusic();
}
