package rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rest.entity.Game;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Integer> {
    List<Game> findByGameName(String gameName);
}