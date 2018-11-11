package com.applet.service;

import com.commons.dto.applet.feedback.FeedbackListDTO;
import com.commons.message.ResultMessage;
import com.commons.entity.Feedback;

public interface FeedbackService {

	ResultMessage saveFeedback(Feedback feedback);
	ResultMessage findFeedbacks(FeedbackListDTO feedbackListDTO);
}