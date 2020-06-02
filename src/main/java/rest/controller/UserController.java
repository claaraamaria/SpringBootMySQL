package rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import rest.entity.User;
import rest.repository.UserRepository;

@Controller
@RequestMapping(path = "/users")
public class UserController {
    @Autowired
    private UserRepository usersRepository;

    @PostMapping
    public @ResponseBody
    String addNewUser(@RequestParam String userName, @RequestParam String password) {
        User newUser = new User();
        newUser.setUserName(userName);
        newUser.setPassword(password);
        usersRepository.save(newUser);
        return "User Saved";
    }

    @GetMapping
    public @ResponseBody
    Iterable<User> list() {
        return usersRepository.findAll();
    }

    @PutMapping
    public @ResponseBody
    void update(@RequestBody User user) {
        User savedUser = usersRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody
    void delete(@PathVariable("id") int id) {
        usersRepository.deleteById(id);
    }
}



