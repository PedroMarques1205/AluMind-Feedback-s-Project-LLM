package com.alumind.alumindfeedbacksprojectllm.usecase.feedback;

import com.alumind.alumindfeedbacksprojectllm.common.utils.FeedbackResponseDTO;
import com.alumind.alumindfeedbacksprojectllm.core.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SendFeedbackUsecase {

    @Autowired
    private FeedbackService feedbackService;

    public FeedbackResponseDTO sendFeedback(String feedback) {
        return feedbackService.analyzeFeedback(feedback);
    }
}
