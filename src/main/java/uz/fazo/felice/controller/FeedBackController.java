package uz.fazo.felice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.fazo.felice.payload.FeedBackDto;
import uz.fazo.felice.service.FeedBackService;

import java.util.List;

@RestController
@RequestMapping("/api/feedbacks")
public class FeedBackController {

    private final FeedBackService feedBackService;

    public FeedBackController(FeedBackService feedBackService) {
        this.feedBackService = feedBackService;
    }

    @GetMapping
    public ResponseEntity<List<FeedBackDto>> getAllFeedBacks() {
        List<FeedBackDto> feedbacks = feedBackService.getFeedBacks();
        return ResponseEntity.ok(feedbacks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FeedBackDto> getFeedBackById(@PathVariable Long id) {
        FeedBackDto feedbackDto = feedBackService.getFeedBackById(id);
        return ResponseEntity.ok(feedbackDto);
    }

    @PostMapping
    public ResponseEntity<FeedBackDto> addFeedBack(@RequestBody FeedBackDto feedBackDto) {
        FeedBackDto savedFeedBack = feedBackService.saveFeedBack(feedBackDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedFeedBack);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FeedBackDto> updateFeedBack(@PathVariable Long id, @RequestBody FeedBackDto feedBackDto) {
        feedBackDto.setId(id); // Ensure ID consistency
        FeedBackDto updatedFeedBack = feedBackService.saveFeedBack(feedBackDto);
        return ResponseEntity.ok(updatedFeedBack);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeedBack(@PathVariable Long id) {
        feedBackService.deleteFeedBackById(id);
        return ResponseEntity.noContent().build();
    }
}
