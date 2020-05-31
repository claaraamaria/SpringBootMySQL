package rest.repository;

import org.springframework.data.repository.CrudRepository;
import rest.entity.Room;

public interface RoomRepository extends CrudRepository<Room, Integer> {
}
