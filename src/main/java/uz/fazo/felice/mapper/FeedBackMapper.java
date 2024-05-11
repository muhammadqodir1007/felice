package uz.fazo.felice.mapper;

import org.mapstruct.Mapper;
import uz.fazo.felice.entity.FeedBack;
import uz.fazo.felice.payload.FeedBackDto;

@Mapper
public interface FeedBackMapper {

    FeedBackDto feedBackToDto(FeedBack feedBack);
    FeedBack feedBackDtoToFeedBack(FeedBackDto feedBackDto);


}
