package rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
import rest.entity.User;
import rest.repository.UserRepository;

import java.util.List;

import static org.springframework.util.StringUtils.isEmpty;

@Controller
@RequestMapping(path = "/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping(consumes = "application/json")
    public @ResponseBody
    String addNewUser(@RequestBody User user) {
        userRepository.save(user);
        return "User Saved";
    }

    @GetMapping
    public @ResponseBody
    List<User> searchBy(@RequestParam(required = false) String userName, @RequestParam(required = false) String password) {
        List<User> users;
        if (isEmpty(userName) && isEmpty(password)) {
            return userRepository.findAll();
        } else {
            users = userRepository.findByUserNameAndPassword(userName, password);
        }
        return users;
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



