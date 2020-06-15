package rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import rest.entity.User;
import rest.repository.UserRepository;

import static org.springframework.data.jpa.domain.Specification.where;
import static org.springframework.util.StringUtils.isEmpty;
import static rest.repository.UserSpecification.isPassword;
import static rest.repository.UserSpecification.isUserName;

@Controller
@RequestMapping(path = "/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public @ResponseBody
    String addNewUser(@RequestBody User user) {
        userRepository.save(user);
        return "User Saved";
    }

    @GetMapping
    public @ResponseBody
    Iterable<User> searchBy(@RequestParam(required = false) String userName, @RequestParam(required = false) String password) {
        if (isEmpty(userName) && isEmpty(password)) {
            return userRepository.findAll();
        } else {
            return userRepository.findAll(where(isUserName(userName)).and(isPassword(password)));
        }
    }

    @PutMapping(consumes = "application/json")
    public @ResponseBody
    void update(@RequestBody User user) {
        User savedUser = userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody
    void delete(@PathVariable("id") int id) {
        userRepository.deleteById(id);
    }
}



