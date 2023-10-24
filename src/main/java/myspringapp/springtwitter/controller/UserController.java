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

    @GetMapping("/{id}/tweets")
    public UserTweetsDTO getUserTweetsById(@PathVariable("id") String id) {
        return userService.getUserTweetsById(id);
    }

    @GetMapping("/{id}/notifications")
    public UserNotificationsDTO getUserNotificationsById(@PathVariable("id") String id) {
        return userService.getUserNotificationsById(id);
    }

    @GetMapping("/{id}/comments")
    public UserCommentsDTO getUserCommentsById(@PathVariable("id") String id) {
        return userService.getUserCommentsById(id);
    }

    @GetMapping("/{id}/following")
    public UserFollowingDTO getUserFollowingById(@PathVariable("id") String id) {
        return userService.getUserFollowingById(id);
    }

    @GetMapping("/{id}/followers")
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
