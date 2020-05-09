package accessingdatamysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/")
public class MainController {
    @Autowired // This means to get the bean called Repositories
    // Which are auto-generated by Spring, we will use it to handle the data
    private UserRepository usersRepository;
    @Autowired private RoomRepository roomRepository;
    @Autowired private GameRepository gameRepository;

    @PostMapping(path = "/users")
    public @ResponseBody
    String addNewUser(@RequestParam String userName, @RequestParam String password) {
        User newUser = new User();
        newUser.setUserName(userName);
        newUser.setPassword(password);
        usersRepository.save(newUser);
        return "User Saved";
    }

    @PostMapping(path = "/games")
    public @ResponseBody
    String addNewGame(@RequestParam String gameName) {
        Game newGame = new Game();
        newGame.setGameName(gameName);
        gameRepository.save(newGame);
        return "Game created";
    }


    @PostMapping(path = "/rooms")
    public @ResponseBody
    String addNewRoom(@RequestParam String roomName, @RequestParam Integer gameId, @RequestParam Integer userId) {
        Room newRoom = new Room();
        newRoom.setRoomName(roomName);
        newRoom.setGameId(gameId);
        newRoom.setUserId(userId);
        roomRepository.save(newRoom);
        return "Room Created";
    }

    @GetMapping(path = "/users")
    public @ResponseBody
    Iterable<User> getAllUsers() {
        return usersRepository.findAll();
    }

    @GetMapping(path = "/games")
    public @ResponseBody
    Iterable<Game> getAllGames() {
        return gameRepository.findAll();
    }

    @GetMapping(path = "/rooms")
    public @ResponseBody
    Iterable<Room> getAllRooms() {
        return roomRepository.findAll();
    }
}



