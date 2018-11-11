package com.commons.exception;

import com.commons.message.ResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Notes: 全局异常处理
 * @Author: At
 * @Date: 2018/3/22
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler extends RuntimeException {

    /**
     * 日志对象
     */
    Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	/**
	 * @Description(功能描述): 全局运行时异常拦截
	 * @author(作者): lrfalse<wangliyou>
	 * @date(开发日期): 2018/7/27 18:43
	 **/
	@ExceptionHandler(RuntimeException.class)
	public ResponseMessage handle(Exception e){
		if(e instanceof BusinessException){
			BusinessException exception=(BusinessException)e;
            logger.error("【系统处理异常】：{}",e.getMessage());
            e.printStackTrace();
			return ResponseMessage.error(exception.getStatus(),exception.getMessage());
		}else if(e instanceof TokenValidationException){
			TokenValidationException exception=(TokenValidationException)e;
			logger.error("【非法请求】：{}",e.getMessage());
			e.printStackTrace();
			return ResponseMessage.error(ResponseMessage.GLOBAL_EXCEPTION,exception.getMessage());
		}
		else{
			logger.error("【系统内部异常】：{}",e.getMessage());
			e.printStackTrace();
			return ResponseMessage.error();
		}
	}

    /**
     * 校验参数
     * @param ex MethodArgumentNotValidException 异常
     * @return
     */
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseMessage handlerMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        return ResponseMessage.error(ResponseMessage.GLOBAL_EXCEPTION,fieldErrors.get(0).getDefaultMessage());
    }

    @ExceptionHandler({MissingServletRequestParameterException.class})
    public ResponseMessage handlerMissingServletRequestParameterException(MissingServletRequestParameterException ex) {
        return ResponseMessage.error(ResponseMessage.GLOBAL_EXCEPTION,"参数"+ex.getParameterName()+"不能为空");
    }

    /**
     * 校验参数
     * @param ex BindException 异常
     * @return
     */
    @ExceptionHandler({BindException.class})
    public ResponseMessage handlerBindException(BindException ex) {
        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        return ResponseMessage.error(ResponseMessage.GLOBAL_EXCEPTION,fieldErrors.get(0).getDefaultMessage());
    }

    /**
     *  处理 IllegalArgumentException
     * @param ex
     * @return
     */
    @ExceptionHandler({IllegalArgumentException.class})
    public ResponseMessage handlerIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseMessage.error(ResponseMessage.GLOBAL_EXCEPTION,ex.getMessage());
    }



    @ExceptionHandler({HttpMessageNotReadableException.class})
    public ResponseMessage handlerHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        return ResponseMessage.error(ResponseMessage.GLOBAL_EXCEPTION,"请求参数错误!",ex.getMessage());
    }

    /**
     * 全局控制器异常处理
     * @param ex
     * @return
     */
    @ExceptionHandler({ControllerException.class})
    public ResponseMessage handlerException(ControllerException ex) {
        logger.error(ex.getMessage(),ex);
        return ResponseMessage.error(ResponseMessage.GLOBAL_EXCEPTION,ex.getMessage(),ex);
    }


}
