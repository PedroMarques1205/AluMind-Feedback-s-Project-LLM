package com.alumind.alumindfeedbacksprojectllm.common.utils;

import lombok.Data;

import java.util.List;

@Data
public class FeedbackResponseDTO {
    private Long id;
    private String sentiment;
    private List<RequestedFeatureDTO> requestedFeatures;
}
