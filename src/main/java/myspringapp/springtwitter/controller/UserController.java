package myspringapp.springtwitter.controller;

import lombok.AllArgsConstructor;
import myspringapp.springtwitter.dto.*;
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

    @GetMapping("/following/{id}")
    public UserFollowingDTO getUserFollowingById(@PathVariable("id") String id) {
        return userService.getUserFollowingById(id);
    }

    @GetMapping("/followers/{id}")
    public UserFollowersDTO getUserFollowersById(@PathVariable("id") String id) {
        return userService.getUserFollowersById(id);
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
