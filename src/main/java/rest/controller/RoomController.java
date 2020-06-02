package rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import rest.entity.Game;
import rest.entity.Room;
import rest.repository.RoomRepository;

@Controller

@RequestMapping(path = "/rooms")
public class RoomController {
    @Autowired
    private RoomRepository roomRepository;

    @PostMapping
    public @ResponseBody
    String addNewRoom(@RequestParam String roomName, @RequestParam Integer gameId, @RequestParam Integer userId) {
        Room newRoom = new Room();
        newRoom.setRoomName(roomName);
        newRoom.setGameId(gameId);
        newRoom.setUserId(userId);
        roomRepository.save(newRoom);
        return "Room Saved";
    }

    @GetMapping
    public @ResponseBody
    Iterable<Room> list() {
        return roomRepository.findAll();
    }

    @PutMapping
    public @ResponseBody
    void update(@RequestBody Room room) {
        Room savedRoom = roomRepository.save(room);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody
    void delete(@PathVariable("id") int id) {
        roomRepository.deleteById(id);
    }
}
