package com.alumind.alumindfeedbacksprojectllm.dataprovider.feedback;

import com.alumind.alumindfeedbacksprojectllm.model.feedback.RequestedFeature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRequestedFeatureRepository extends JpaRepository<RequestedFeature, Long> {

}
