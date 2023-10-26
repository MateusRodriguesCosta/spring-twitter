package myspringapp.springtwitter.database;

import myspringapp.springtwitter.dto.MessageDTO;
import myspringapp.springtwitter.entities.*;
import myspringapp.springtwitter.repositories.*;
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

    @Autowired
    private MessageRepository messageRepository;

    private ArrayList<UserEntity> userList = new ArrayList<>();
    private ArrayList<TweetEntity> tweetList = new ArrayList<>();


    public void initializeUsers() {
        for (int i = 0; i < 10; i++) {
            UserEntity user = new UserEntity();
            user.setName(dataGenerator.generateRandomString());
            user.setEmail(dataGenerator.generateRandomString() + "@gmail.com");
            user.setPassword(dataGenerator.generateRandomString());
            user.setAddress(dataGenerator.generateRandomString());
            user.setPhone(dataGenerator.generateRandomString());
            user.setBio(dataGenerator.generateRandomString(80));
            user.setJoinedDate(dataGenerator.generateRandomDateString());
            user.setVerifiedAccount(dataGenerator.generateRandomInt() % 2 == 0);
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
            tweet.setValue(dataGenerator.generateRandomString(80));
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

    public void initializeFollowing() {
        UserEntity userFollowed;
        UserEntity userFollowing;
        for (int i = 0; i < 10; i++) {
            var followingList = new ArrayList<UserEntity>();
            for (int j = 0; j < userList.size(); j++) {
                if (i != j) {
                    userFollowing = userList.get(j);
                    followingList.add(userFollowing);
                }
            }

            userFollowed = userList.get(i);
            userFollowed.setFollowing(followingList);
            userRepository.save(userFollowed);

        }
    }

    public void initializeMessages() {
        for (int i = 0; i < 10; i++) {
            UserEntity user = userList.get(i);
            var messages = new ArrayList<MessageEntity>();
            for (int j = 0; j < 10; j++) {
                if (i != j) {
                    var message = new MessageEntity();
                    message.setValue(dataGenerator.generateRandomString());
                    message.setDateTime(dataGenerator.generateRandomDateString());
                    if(dataGenerator.generateRandomInt() % 2 == 0) {
                        message.setFrom(user);
                        message.setTo(userList.get(j));
                    } else {
                        message.setFrom(userList.get(j));
                        message.setTo(user);
                    }
                    messageRepository.save(message);
                }
            }
            user.setMessages(messages);
            userRepository.save(user);
        }
    }
}
