package myspringapp.springtwitter.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import myspringapp.springtwitter.dto.UserCommentsDTO;
import myspringapp.springtwitter.dto.UserDTO;
import myspringapp.springtwitter.dto.UserNotificationsDTO;
import myspringapp.springtwitter.dto.UserTweetsDTO;
import myspringapp.springtwitter.mappers.TweetMapper;
import myspringapp.springtwitter.mappers.UserMapper;
import myspringapp.springtwitter.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Transactional
    public UserDTO createUser(UserDTO user) {
        var _user = userRepository.save(userMapper.toUserEntity(user));
        return userMapper.toUserDTO(_user);
    }

    public UserDTO getUserById(String id) {
        var userEntity = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return userMapper.toUserDTO(userEntity);
    }

    public UserTweetsDTO getUserTweetsById(String id) {
        var userEntity = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return userMapper.toUserTweetsDTO(userEntity);
    }

    public UserNotificationsDTO getUserNotificationsById(String id) {
        var userEntity = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return userMapper.toUserNotificationsDTO(userEntity);
    }

    public UserCommentsDTO getUserCommentsById(String id) {
        var userEntity = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return userMapper.toUserCommentsDTO(userEntity);
    }

    public void deleteUserById(String id) {
        userRepository.deleteById(id);
    }

    public List<UserDTO> getAllUsers() {
        var usersEntity = userRepository.findAll();
        return userMapper.toUserDTO(usersEntity);
    }

}
