package myspringapp.springtwitter.database;

import myspringapp.springtwitter.entities.CommentEntity;
import myspringapp.springtwitter.entities.NotificationEntity;
import myspringapp.springtwitter.entities.TweetEntity;
import myspringapp.springtwitter.entities.UserEntity;
import myspringapp.springtwitter.repositories.CommentRepository;
import myspringapp.springtwitter.repositories.NotificationRepository;
import myspringapp.springtwitter.repositories.TweetRepository;
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

    @Autowired
    private TweetRepository tweetRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private NotificationRepository notificationRepository;

    private ArrayList<UserEntity> userList = new ArrayList<>();
    private ArrayList<TweetEntity> tweetList = new ArrayList<>();


    public void initializeUsers() {
        for (int i = 0; i < 10; i++) {
            UserEntity user = new UserEntity();
            user.setName(dataGenerator.generateRandomString());
            user.setEmail(dataGenerator.generateRandomString() + "@gmail.com");
            user.setPassword(dataGenerator.generateRandomString());
            user.setAddress(dataGenerator.generateRandomString());
            user.setTweets(new ArrayList<>());

            userList.add(userRepository.save(user));
        }
    }

    public void initializeTweets() {
        for (int i = 0; i < 10; i++) {
            TweetEntity tweet = new TweetEntity();
            tweet.setUser(userList.get(i));
            tweet.setLikes(dataGenerator.generateRandomInt());
            tweet.setDate(dataGenerator.generateRandomDateString());
            tweet.setValue(dataGenerator.generateRandomString());
            tweet.setComments(new ArrayList<>());

            tweetList.add(tweetRepository.save(tweet));
        }
    }

    public void initializeComments() {
        for (int i = 0; i < 10; i++) {
            CommentEntity comment = new CommentEntity();
            comment.setUser(userList.get(i));
            comment.setLikes(dataGenerator.generateRandomInt());
            comment.setDate(dataGenerator.generateRandomDateString());
            comment.setValue(dataGenerator.generateRandomString());
            comment.setTweet(tweetList.get(i));
            commentRepository.save(comment);
        }
    }

    public void initializeNotifications() {
        for (int i = 0; i < 10; i++) {
            NotificationEntity notification = new NotificationEntity();
            notification.setUser(userList.get(i));
            notification.setType(dataGenerator.generateRandomString());
            notification.setDateTime(dataGenerator.generateRandomDateString());
            notificationRepository.save(notification);
        }
    }
}
