package hello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import rest.RestServerApp;
import rest.entity.User;
import rest.repository.UserRepository;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.springframework.data.jpa.domain.Specification.where;

@SpringBootTest(classes = RestServerApp.class)
@TestPropertySource(locations = "classpath:application.properties")
public class SpecsTest {
    @Autowired
    UserRepository userRepository;

    @Test
    public void testSpecifications() {
        Iterable<User> users = userRepository.findByUserNameAndPassword("mama","pass1");
        assertTrue(users.iterator().hasNext());
    }
}
