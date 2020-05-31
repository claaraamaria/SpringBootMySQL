package rest.repository;

import org.springframework.data.repository.CrudRepository;
import rest.entity.Game;

public interface GameRepository extends CrudRepository<Game, Integer> {
}