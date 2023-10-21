package myspringapp.springtwitter.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import myspringapp.springtwitter.dto.TweetDTO;
import myspringapp.springtwitter.mappers.TwitterMapper;
import myspringapp.springtwitter.repositories.TweetRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TweetService {
    private final TweetRepository tweetRepository;
    private final TwitterMapper twitterMapper;

    @Transactional
    public TweetDTO createTweet(TweetDTO tweet) {
        tweetRepository.save(twitterMapper.toTweetEntity(tweet));
        return tweet;
    }

    public TweetDTO getTweetById(String id) {
        var tweetEntity = tweetRepository.findById(id).orElseThrow(() -> new RuntimeException("Tweet not found"));
        return twitterMapper.toTweetDTO(tweetEntity);
    }

    public void deleteTweetById(String id) {
        tweetRepository.deleteById(id);
    }

    public List<TweetDTO> getAllTweets() {
        var tweetsEntity = tweetRepository.findAll();
        return twitterMapper.toTweetDTO(tweetsEntity);
    }

    public List<TweetDTO> getTweetsByUserId(String id, Pageable pageable) {
        var tweetsEntity = tweetRepository.findAllByUserId(id, pageable);
        return twitterMapper.toTweetDTO(tweetsEntity);
    }

    public List<TweetDTO> getUserFeed(String id) {
        var tweetsEntity = tweetRepository.findUserFeed(id, Pageable.unpaged());
        return twitterMapper.toTweetDTO(tweetsEntity);
    }

}
