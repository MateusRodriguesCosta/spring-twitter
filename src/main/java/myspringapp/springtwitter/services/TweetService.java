package myspringapp.springtwitter.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import myspringapp.springtwitter.dto.TweetCommentsDTO;
import myspringapp.springtwitter.dto.TweetDTO;
import myspringapp.springtwitter.mappers.TweetMapper;
import myspringapp.springtwitter.repositories.TweetRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TweetService {
    private final TweetRepository tweetRepository;
    private final TweetMapper tweetMapper;

    @Transactional
    public TweetDTO createTweet(TweetDTO tweet) {
        var tweetEntity = tweetRepository.save(tweetMapper.toTweetEntity(tweet));
        return tweetMapper.toTweetDTO(tweetEntity);
    }

    public TweetDTO getTweetById(String id) {
        var tweetEntity = tweetRepository.findById(id).orElseThrow(() -> new RuntimeException("Tweet not found"));
        return tweetMapper.toTweetDTO(tweetEntity);
    }

    public void deleteTweetById(String id) {
        tweetRepository.deleteById(id);
    }

    public TweetDTO likeTweet(String id) {
        var tweetEntity = tweetRepository.findById(id).orElseThrow(() -> new RuntimeException("Tweet not found"));
        tweetEntity.setLikes(tweetEntity.getLikes() + 1);
        tweetRepository.save(tweetEntity);
        return tweetMapper.toTweetDTO(tweetEntity);
    }

    public TweetDTO dislikeTweet(String id) {
        var tweetEntity = tweetRepository.findById(id).orElseThrow(() -> new RuntimeException("Tweet not found"));
        tweetEntity.setLikes(tweetEntity.getLikes() - 1);
        tweetRepository.save(tweetEntity);
        return tweetMapper.toTweetDTO(tweetEntity);
    }

    public List<TweetDTO> getAllTweets() {
        var tweetsEntity = tweetRepository.findAll();
        return tweetMapper.toTweetDTO(tweetsEntity);
    }

    public List<TweetDTO> getTweetsByUserId(String id, Pageable pageable) {
        var tweetsEntity = tweetRepository.findAllByUserId(id, pageable);
        return tweetMapper.toTweetDTO(tweetsEntity);
    }

    public TweetCommentsDTO getTweetCommentsById(String id) {
        var tweetEntity = tweetRepository.findById(id).orElseThrow(() -> new RuntimeException("Tweet not found"));
        return tweetMapper.toTweetCommentsDTO(tweetEntity);
    }

    public List<TweetDTO> getUserFeed(String id) {
        var tweetsEntity = tweetRepository.findUserFeed(id, Pageable.unpaged());
        return tweetMapper.toTweetDTO(tweetsEntity);
    }

}
