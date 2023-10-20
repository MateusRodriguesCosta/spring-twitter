package myspringapp.springtwitter.mappers;

import myspringapp.springtwitter.dto.TweetDTO;
import myspringapp.springtwitter.entities.TweetEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.MappingInheritanceStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_ALL_FROM_CONFIG,
        builder = @Builder(disableBuilder = true))
public interface TwitterMapper {

    TweetDTO map(TweetEntity tweet);

    TweetEntity map(TweetDTO tweet);

    default List<TweetDTO> map(Iterable<TweetEntity> list) {
        return StreamSupport.stream(list.spliterator(), false).map(this::map).collect(toList());
    }
}
