package uz.fazo.felice.service;

import uz.fazo.felice.payload.FeedBackDto;

import java.util.List;

public interface FeedBackService {


    List<FeedBackDto> getFeedBacks();

    FeedBackDto getFeedBackById(Long id);

    FeedBackDto saveFeedBack(FeedBackDto feedBack);

    void deleteFeedBackById(Long id);

    FeedBackDto updateFeedBack(FeedBackDto feedBack);


}
