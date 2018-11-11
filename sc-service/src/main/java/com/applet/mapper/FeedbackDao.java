package com.applet.mapper;

import com.commons.config.MyMapper;
import com.commons.dto.applet.feedback.FeedbackListDTO;
import com.commons.entity.Feedback;

import java.util.List;

public interface FeedbackDao extends MyMapper<Feedback>{

	List<Feedback> findFeedbacks(FeedbackListDTO feedbackListDTO);

}