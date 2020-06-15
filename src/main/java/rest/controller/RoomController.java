package rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import rest.entity.Game;
import rest.entity.Room;
import rest.repository.RoomRepository;

import static org.springframework.data.jpa.domain.Specification.where;
import static rest.repository.RoomSpecification.isRoomName;

@Controller

@RequestMapping(path = "/rooms")
public class RoomController {
    @Autowired
    private RoomRepository roomRepository;

    @PostMapping(consumes = "application/json")
    public @ResponseBody
    String addNewRoom(@RequestBody Room room) {
        roomRepository.save(room);
        return "Room Saved";
    }

    @GetMapping
    public @ResponseBody
    Iterable<Room> list(@RequestParam(required = false) String roomName) {
        if (roomName == null) {
            return roomRepository.findAll();
        } else {
            return roomRepository.findAll(where(isRoomName(roomName)));
        }
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
