package rest.repository;

import org.springframework.data.jpa.domain.Specification;
import rest.entity.Game;

public class GameSpecification {//implements Specification<Game> {

    public static Specification<Game> isGameName(String gameName) {
        return (Specification<Game>) (game, query, criteriaBuilder) -> criteriaBuilder.equal(game.get("gameName"), gameName);
    }

    public static Specification<Game> isPassword(String password) {
        return (game, query, criteriaBuilder) -> criteriaBuilder.equal(game.get("password"), password);
    }
}
