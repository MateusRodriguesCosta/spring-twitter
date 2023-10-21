package myspringapp.springtwitter.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import myspringapp.springtwitter.dto.UserDTO;
import myspringapp.springtwitter.mappers.TwitterMapper;
import myspringapp.springtwitter.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final TwitterMapper twitterMapper;

    @Transactional
    public UserDTO createUser(UserDTO user) {
        var _user = userRepository.save(twitterMapper.toUserEntity(user));
        return twitterMapper.toUserDTO(_user);
    }

    public UserDTO getUserById(String id) {
        var userEntity = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return twitterMapper.toUserDTO(userEntity);
    }

    public void deleteUserById(String id) {
        userRepository.deleteById(id);
    }

    public List<UserDTO> getAllUsers() {
        var usersEntity = userRepository.findAll();
        return twitterMapper.toUserDTO(usersEntity);
    }

}
