package com.alumind.alumindfeedbacksprojectllm.common.utils;

import com.alumind.alumindfeedbacksprojectllm.model.FeedbackResponse;
import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
public class RequestedFeatures {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;
    private String reason;

    @ManyToOne
    @JoinColumn(name = "feedback_response_id")
    private FeedbackResponse feedbackResponse;
}
