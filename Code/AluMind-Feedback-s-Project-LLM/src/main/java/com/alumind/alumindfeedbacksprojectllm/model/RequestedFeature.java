package com.alumind.alumindfeedbacksprojectllm.model;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
public class RequestedFeature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;
    private String reason;

    @ManyToOne
    @JoinColumn(name = "feedback_response_id")
    private FeedbackResponse feedbackResponse;
}
