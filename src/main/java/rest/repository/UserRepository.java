package rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rest.entity.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByUserNameAndPassword(String username, String password);

}
