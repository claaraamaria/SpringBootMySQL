package rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import rest.entity.User;
import rest.repository.UserRepository;
import rest.repository.UserSpecification;

import static org.springframework.data.jpa.domain.Specification.where;
import static org.springframework.util.StringUtils.isEmpty;
import static rest.repository.UserSpecification.isPassword;
import static rest.repository.UserSpecification.isUserName;

@Controller
@RequestMapping(path = "/users")
public class UserController {
    @Autowired
    private UserRepository usersRepository;

    @PostMapping
    public @ResponseBody
    String addNewUser(@RequestParam String userName, @RequestParam String password, @RequestParam String name, @RequestParam String email, @RequestParam int telephone) {
        User newUser = new User();
        newUser.setUserName(userName);
        newUser.setPassword(password);
        newUser.setName(name);
        newUser.setEmail(email);
        newUser.setTelephone(telephone);
        usersRepository.save(newUser);
        return "User Saved";
    }

    @GetMapping
    public @ResponseBody
    Iterable<User> searchBy(@RequestParam String userName, @RequestParam String password) {
        if (isEmpty(userName) && isEmpty(password)) {
            return usersRepository.findAll();
        } else {
            return usersRepository.findAll(where(isUserName(userName)).and(isPassword(password)));
        }
    }

   /* @GetMapping("/")
    public @ResponseBody
    Iterable<User> list() {
        return usersRepository.findAll(); //TODO: figure out how to call just /users without params
    }*/

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



