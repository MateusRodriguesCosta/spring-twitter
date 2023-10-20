package myspringapp.springtwitter.mappers;

import myspringapp.springtwitter.dto.TweetDTO;
import myspringapp.springtwitter.entities.TweetEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;

@Component
@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface TwitterMapper {

    TweetDTO map(TweetEntity tweet);

    TweetEntity map(TweetDTO tweet);

    default List<TweetDTO> map(Iterable<TweetEntity> list) {
        return StreamSupport.stream(list.spliterator(), false).map(this::map).collect(toList());
    }
}
