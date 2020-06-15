package rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import rest.entity.Game;
import rest.entity.Room;
import rest.entity.User;
import rest.repository.GameRepository;

import static org.springframework.data.jpa.domain.Specification.where;
import static rest.repository.GameSpecification.isGameName;

@Controller
@RequestMapping(path = "/games")
public class GameController {
    @Autowired
    private GameRepository gameRepository;

    @PostMapping(consumes = "application/json")
    public @ResponseBody
    String addNewGame(@RequestBody Game game) {
        gameRepository.save(game);
        return "Game Saved";
    }

    @GetMapping
    public @ResponseBody
    Iterable<Game> list(@RequestParam(required = false) String gameName) {
        if (gameName == null) {
            return gameRepository.findAll();
        } else {
            return gameRepository.findAll(where(isGameName(gameName)));
        }
    }

    @PutMapping
    public @ResponseBody
    void update(@RequestBody Game game) {
        Game savedGame = gameRepository.save(game);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody
    void delete(@PathVariable("id") int id) {
        gameRepository.deleteById(id);
    }
}
