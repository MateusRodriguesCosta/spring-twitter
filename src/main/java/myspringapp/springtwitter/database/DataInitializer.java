package myspringapp.springtwitter.database;

import myspringapp.springtwitter.entities.UserEntity;
import myspringapp.springtwitter.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class DataInitializer {

    @Autowired
    private DataGenerator dataGenerator;

    @Autowired
    private UserRepository userRepository;

    public void initializeUsers() {
        for (int i = 0; i < 10; i++) {
            UserEntity user = new UserEntity();
            user.setName(dataGenerator.generateRandomString());
            user.setEmail(dataGenerator.generateRandomString());
            user.setPassword(dataGenerator.generateRandomString());
            user.setAddress(dataGenerator.generateRandomString());
            user.setTweets(new ArrayList<>());

            userRepository.save(user);
        }
    }
}
