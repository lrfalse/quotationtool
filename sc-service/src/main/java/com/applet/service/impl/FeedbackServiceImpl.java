package com.applet.service.impl;


import com.commons.dto.applet.feedback.FeedbackListDTO;
import com.commons.message.ResultMessage;
import com.applet.mapper.FeedbackDao;
import com.applet.service.FeedbackService;
import com.commons.entity.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
	private FeedbackDao feedbackDao;
	@Override
	public ResultMessage saveFeedback(Feedback feedback) {
		return ResultMessage.build(feedbackDao.insert(feedback));
	}

	@Override
	public ResultMessage findFeedbacks(FeedbackListDTO feedbackListDTO) {
		return ResultMessage.build(feedbackDao.findFeedbacks(feedbackListDTO));
	}
}