package rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import rest.entity.Room;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Integer> {
    @Query("select u from Room u" )
    List<Room> findAll();

    List<Room> findByRoomName(String roomName);
}
