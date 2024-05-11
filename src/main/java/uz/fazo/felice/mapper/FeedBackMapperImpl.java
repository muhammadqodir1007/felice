package uz.fazo.felice.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uz.fazo.felice.entity.FeedBack;
import uz.fazo.felice.payload.FeedBackDto;

@Service
@AllArgsConstructor
public class FeedBackMapperImpl implements FeedBackMapper {
    @Override
    public FeedBackDto feedBackToDto(FeedBack feedBack) {
        if (feedBack == null) return null;
        FeedBackDto feedBackDto = new FeedBackDto();
        feedBackDto.setId(feedBack.getId());
        feedBackDto.setEmail(feedBack.getEmail());
        feedBackDto.setMessage(feedBack.getMessage());
        return feedBackDto;
    }

    @Override
    public FeedBack feedBackDtoToFeedBack(FeedBackDto feedBackDto) {
        if (feedBackDto == null) return null;
        FeedBack feedBack = new FeedBack();
        feedBack.setEmail(feedBackDto.getEmail());
        feedBack.setMessage(feedBackDto.getMessage());
        return feedBack;
    }
}
