package rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rest.entity.Room;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Integer> {
    List<Room> findByRoomName(String roomName);
}
