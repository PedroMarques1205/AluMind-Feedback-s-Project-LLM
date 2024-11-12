package com.alumind.alumindfeedbacksprojectllm.entrypoint;

import com.alumind.alumindfeedbacksprojectllm.common.utils.FeedbackResponseDTO;
import com.alumind.alumindfeedbacksprojectllm.core.FeedbackService;
import com.alumind.alumindfeedbacksprojectllm.usecase.feedback.SendFeedbackUsecase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

    @Autowired
    private SendFeedbackUsecase sendFeedbackUsecase;

    @PostMapping("/feedbacks")
    public ResponseEntity<FeedbackResponseDTO> analyzeFeedback(@RequestParam String feedbackRequest) {
        return ResponseEntity.ok(sendFeedbackUsecase.sendFeedback(feedbackRequest));
    }
}
