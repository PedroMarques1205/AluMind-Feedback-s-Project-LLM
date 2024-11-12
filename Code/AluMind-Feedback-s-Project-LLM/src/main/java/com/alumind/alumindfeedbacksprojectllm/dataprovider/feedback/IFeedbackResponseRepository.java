package com.alumind.alumindfeedbacksprojectllm.dataprovider.feedback;

import com.alumind.alumindfeedbacksprojectllm.model.feedback.FeedbackResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFeedbackResponseRepository extends JpaRepository<FeedbackResponse, Long> {

}
