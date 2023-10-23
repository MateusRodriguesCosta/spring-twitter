package myspringapp.springtwitter.mappers;

import myspringapp.springtwitter.dto.*;
import myspringapp.springtwitter.entities.TweetEntity;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface TweetMapper {

    TweetEntity toTweetEntity(TweetDTO tweet);

    @Named("toTweetDTO")
    TweetDTO toTweetDTO(TweetEntity tweet);

    @IterableMapping(qualifiedByName = "toTweetDTO")
    List<TweetDTO> toTweetDTO(Iterable<TweetEntity> list);

}
