package com.alumind.alumindfeedbacksprojectllm.common.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FeedbackResponseDTO {
    private Long id;
    private String sentiment;
    private List<RequestedFeatureDTO> requestedFeatures;
}
