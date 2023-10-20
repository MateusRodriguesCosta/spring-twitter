package myspringapp.springtwitter.services;

import lombok.AllArgsConstructor;
import myspringapp.springtwitter.dto.TweetDTO;
import myspringapp.springtwitter.dto.UserDTO;
import myspringapp.springtwitter.repositories.TweetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TweetService {
    private final TweetRepository tweetRepository;

    public TweetDTO createTweet(TweetDTO tweet) {
        TweetDTO tweetEntity = TweetDTO.builder()
                .user(UserDTO.builder()
                        .id(tweet.getUser().getId())
                        .name(tweet.getUser().getName())
                        .email(tweet.getUser().getEmail())
                        .password(tweet.getUser().getPassword())
                        .address(tweet.getUser().getAddress())
                        .build())
                .value(tweet.getValue())
                .date(tweet.getDate())
                .likes(tweet.getLikes())
                .build();
        tweetRepository.save(tweetEntity);
        return tweet;
    }

    public TweetDTO getTweetById(Long id) {
        return tweetRepository.findById(id).orElseThrow(() -> new RuntimeException("Tweet not found"));
    }

    public void deleteTweetById(Long id) {
        tweetRepository.deleteById(id);
    }

    public List<TweetDTO> getAllTweets() {
        return tweetRepository.findAll();
    }

    public List<TweetDTO> getTweetsByUserId(Long id) {
        return tweetRepository.findByUserId(id);
    }

    public List<TweetDTO> getUserFeed(Long id) {
        return tweetRepository.findUserFeed(id);
    }

}
