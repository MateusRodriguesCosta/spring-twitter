package myspringapp.springtwitter.mappers;

import myspringapp.springtwitter.dto.TweetCommentsDTO;
import myspringapp.springtwitter.dto.TweetDTO;
import myspringapp.springtwitter.entities.TweetEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface TweetMapper {

    TweetEntity toTweetEntity(TweetDTO tweet);

    TweetDTO toTweetDTO(TweetEntity tweet);

    TweetCommentsDTO toTweetCommentsDTO(TweetEntity tweet);

    List<TweetDTO> toTweetDTO(Iterable<TweetEntity> list);

}
