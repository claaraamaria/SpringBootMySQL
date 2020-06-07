package rest.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import rest.entity.User;

public interface UserRepository extends CrudRepository<User, Integer>, JpaSpecificationExecutor<User>{

}
