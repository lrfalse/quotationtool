package com.applet.controller;

import com.commons.dto.applet.feedback.FeedbackDTO;
import com.commons.dto.applet.feedback.FeedbackListDTO;
import com.commons.message.ResponseMessage;
import com.applet.service.FeedbackService;
import com.commons.entity.Feedback;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
  * @Description(功能描述): 消息反馈
  * @author(作者): lrfalse<wangliyou>
  * @date (开发日期): 2018/10/10 22:19
  **/
@RestController
@RequestMapping("feedback")
@Api(tags ="用户反馈")
public class FeedbackController {

	@Autowired
	protected FeedbackService feedbackService;

	@ApiOperation(value = "问题反馈")
	@ResponseBody
	@PatchMapping(value = "/addFeedback")
	public ResponseMessage addFeedback(FeedbackDTO feedback) {
		Feedback feedback2=new Feedback();
		BeanUtils.copyProperties(feedback,feedback2);
		return ResponseMessage.result(feedbackService.saveFeedback(feedback2));
	}
	@ApiOperation(value = "问题反馈列表")
	@ResponseBody
	@GetMapping(value = "/feedbackList")
	public ResponseMessage feedbackList(FeedbackListDTO feedbackListDTO) {
		PageHelper.startPage(feedbackListDTO.getPageNum(),feedbackListDTO.getPageSize());
		return ResponseMessage.result(feedbackService.findFeedbacks(feedbackListDTO));
	}
}
