package rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import rest.entity.Game;
import rest.repository.GameRepository;

import java.util.List;

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
    List<Game> list(@RequestParam(required = false) String gameName) {
        if (gameName == null) {
            return gameRepository.findAll(Sort.unsorted());
        } else {
            return gameRepository.findByGameName(gameName);
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
