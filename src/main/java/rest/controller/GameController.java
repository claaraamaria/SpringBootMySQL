package rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import rest.entity.Game;
import rest.entity.Room;
import rest.entity.User;
import rest.repository.GameRepository;

@Controller
@RequestMapping(path = "/games")
public class GameController {
    @Autowired
    private GameRepository gameRepository;

    @PostMapping
    public @ResponseBody
    String addNewGame(@RequestParam String gameName) {
        Game newGame = new Game();
        newGame.setGameName(gameName);
        gameRepository.save(newGame);
        return "Game Saved";
    }

    @GetMapping
    public @ResponseBody
    Iterable<Game> list() {
        return gameRepository.findAll();
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
