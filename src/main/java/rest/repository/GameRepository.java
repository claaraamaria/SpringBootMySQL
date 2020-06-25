package rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import rest.entity.Game;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Integer> {
    @Query("select u from Game u" )
    List<Game> findAll();

    List<Game> findByGameName(String gameName);
}