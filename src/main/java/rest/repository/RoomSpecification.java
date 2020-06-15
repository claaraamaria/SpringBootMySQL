package rest.repository;

import org.springframework.data.jpa.domain.Specification;
import rest.entity.Room;

public class RoomSpecification {//implements Specification<Room> {

    public static Specification<Room> isRoomName(String roomName) {
        return (Specification<Room>) (room, query, criteriaBuilder) -> criteriaBuilder.equal(room.get("roomName"), roomName);
    }
}
