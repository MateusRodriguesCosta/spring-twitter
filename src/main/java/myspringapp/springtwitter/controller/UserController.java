package myspringapp.springtwitter.controller;

import lombok.AllArgsConstructor;
import myspringapp.springtwitter.dto.UserCommentsDTO;
import myspringapp.springtwitter.dto.UserDTO;
import myspringapp.springtwitter.dto.UserNotificationsDTO;
import myspringapp.springtwitter.dto.UserTweetsDTO;
import myspringapp.springtwitter.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @GetMapping("/")
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable("id") String id) {
        return userService.getUserById(id);
    }

    @GetMapping("/tweets/{id}")
    public UserTweetsDTO getUserTweetsById(@PathVariable("id") String id) {
        return userService.getUserTweetsById(id);
    }

    @GetMapping("/notifications/{id}")
    public UserNotificationsDTO getUserNotificationsById(@PathVariable("id") String id) {
        return userService.getUserNotificationsById(id);
    }

    @GetMapping("/comments/{id}")
    public UserCommentsDTO getUserCommentsById(@PathVariable("id") String id) {
        return userService.getUserCommentsById(id);
    }

    @PostMapping("/")
    public UserDTO createUser(@RequestBody UserDTO user) {
        return userService.createUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable("id") String id) {
        userService.deleteUserById(id);
    }



}
