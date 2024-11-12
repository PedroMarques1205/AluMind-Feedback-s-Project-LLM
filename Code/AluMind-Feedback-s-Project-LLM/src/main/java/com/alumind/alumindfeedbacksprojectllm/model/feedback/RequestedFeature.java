package com.alumind.alumindfeedbacksprojectllm.model.feedback;

import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class RequestedFeature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;
    private String reason;

    @ManyToOne
    @JoinColumn(name = "feedback_response_id")
    private FeedbackResponse feedbackResponse;

    public RequestedFeature(String code, String reason) {
        this.code = code;
        this.reason = reason;
    }
}
