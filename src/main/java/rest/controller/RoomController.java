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
import rest.entity.Room;
import rest.repository.RoomRepository;

import java.util.List;

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
    List<Room> list(@RequestParam(required = false) String roomName) {
        if (roomName == null) {
            return roomRepository.findAll(Sort.unsorted());
        } else {
            return roomRepository.findByRoomName(roomName);
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
