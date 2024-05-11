package uz.fazo.felice.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uz.fazo.felice.entity.FeedBack;
import uz.fazo.felice.mapper.FeedBackMapper;
import uz.fazo.felice.payload.FeedBackDto;
import uz.fazo.felice.repository.FeedBackRepository;
import uz.fazo.felice.telegram.SenderTelegramBot;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FeedBackServiceImpl implements FeedBackService {

    private final FeedBackRepository feedBackRepository;
    private final FeedBackMapper feedBackMapper;
    private final SenderTelegramBot telegramBot;

    @Override
    public List<FeedBackDto> getFeedBacks() {
        return feedBackRepository.findAll().stream().map(feedBackMapper::feedBackToDto).collect(Collectors.toList());
    }

    @Override
    public FeedBackDto getFeedBackById(Long id) {
        return feedBackMapper.feedBackToDto(feedBackRepository.findById(id).orElseThrow(NullPointerException::new));
    }

    @Override
    public FeedBackDto saveFeedBack(FeedBackDto feedBack) {

        FeedBack save = feedBackRepository.save(feedBackMapper.feedBackDtoToFeedBack(feedBack));
        telegramBot.sendContact(feedBack);
        return feedBackMapper.feedBackToDto(save);

    }

    @Override
    public void deleteFeedBackById(Long id) {
        feedBackRepository.deleteById(id);

    }

    @Override
    public FeedBackDto updateFeedBack(FeedBackDto feedBack) {
        return null;
    }
}
