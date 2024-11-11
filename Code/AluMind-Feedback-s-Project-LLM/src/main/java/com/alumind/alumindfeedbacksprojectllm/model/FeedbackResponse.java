package com.alumind.alumindfeedbacksprojectllm.model;

import com.alumind.alumindfeedbacksprojectllm.common.enums.Sentiment;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "FeedBack_Responses")
public class FeedbackResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Enumerated(EnumType.STRING)
    private Sentiment sentiment;

    @OneToMany(mappedBy = "feedbackResponse", cascade = CascadeType.ALL)
    private List<RequestedFeature> requestedFeatures;
}
