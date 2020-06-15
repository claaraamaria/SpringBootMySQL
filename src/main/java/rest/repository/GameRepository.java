package rest.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import rest.entity.Game;

public interface GameRepository extends CrudRepository<Game, Integer>, JpaSpecificationExecutor<Game> {
}