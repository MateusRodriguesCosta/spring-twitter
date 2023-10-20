package myspringapp.springtwitter.controller;

import lombok.AllArgsConstructor;
import myspringapp.springtwitter.dto.TweetDTO;
import myspringapp.springtwitter.services.TweetService;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/tweets")
public class TweetController {

    private TweetService tweetService;


    @GetMapping("/")
    public List<TweetDTO> getAllTweets() {
        return tweetService.getAllTweets();
    }

    @GetMapping("/{id}")
    public TweetDTO getTweetById(@PathVariable("id") String id) {
        return tweetService.getTweetById(id);
    }

    @GetMapping("/user/{id}")
    public List<TweetDTO> getTweetsByUserId(@PathVariable("id") String id, Pageable pageable) {
        return tweetService.getTweetsByUserId(id, pageable);
    }

    @GetMapping("/user-feed/{id}")
    public List<TweetDTO> getUserFeed(@PathVariable("id") String id) {
        return tweetService.getUserFeed(id);
    }

    @PostMapping("/")
    public TweetDTO createTweet(@RequestBody TweetDTO tweet) {
        return tweetService.createTweet(tweet);
    }

    @DeleteMapping("/{id}")
    public void deleteTweetById(@PathVariable("id") String id) {
        tweetService.deleteTweetById(id);
    }
}
