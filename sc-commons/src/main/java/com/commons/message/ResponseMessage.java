package com.commons.message;

import com.commons.utils.StringUtils;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller层返回UI层类型定义
 * @author zhoubo
 * @date 2017/2/10
 */
@ApiModel(value = "ResponseMessage", description = "Controller层返回UI层类型定义")
public class ResponseMessage implements Serializable {
    /**
     * 正常
     */
	@ApiModelProperty(hidden = true)
    public static final int OK=0;
    /**
     * 正常错误
     */
    public static final int ERROR=1;
    /**
     * 异常错误 try 捕获到的Exception
     */
	public static final int GLOBAL_EXCEPTION=-1;

    /**
     * 默认总数
     */
    private static final int TOTAL_DEFAULT=-1;

    /**
     * 默认数据条数
     */
    private static final int TOTAL=0;


    private static final long serialVersionUID = 8992436576262574064L;
    /**
     * 响应码
     */
	@ApiModelProperty(value = "响应码(0：正常，1：错误)",name = "code",dataType = "int")
    private int code;
    /**
     * 反馈信息
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
	@ApiModelProperty(value = "错误信息",name = "message",dataType = "String")
    private transient String message;
    /**
     * 反馈数据
     */
	@ApiModelProperty(value = "具体返回数据对象",name = "data",dataType = "Object")
	private Object data;

    /**
     * 列表总行数
     */
	@ApiModelProperty(value = "列表总行数",name = "total",dataType = "long")
	private long total=TOTAL_DEFAULT;

    public ResponseMessage(int code, String message, int total, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.total = total;
    }

    public ResponseMessage() {
    }

    protected ResponseMessage(String message) {
        this(ERROR,message,TOTAL_DEFAULT,"");
    }
    protected ResponseMessage(int code,String message) {
        this(code,message,TOTAL_DEFAULT,"");
    }
    protected ResponseMessage(int code,String message, long total, Object data) {
        this.code = code;
        this.message=message;
        this.data=data;
        this.total=total;
    }
    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }


    public long getTotal() {
        return total;
    }

    public static ResponseMessage ok() {
        return new ResponseMessage(OK,"success");
    }

    /**
      * @Description(功能描述): 操作对象结果，直接判断返回ok or error对象
      * @author(作者): lrfalse<wangliyou>
      * @date(开发日期): 2018/7/27 16:41
	 * @param resultMessage : 操作对象结果
      **/
	public static ResponseMessage result(ResultMessage resultMessage){
		if(resultMessage.isOK()){
			if(null!=resultMessage.getData()){
				return ResponseMessage.ok(resultMessage.getData());
			}else{
				return ResponseMessage.ok();
			}
		}else {
			if(StringUtils.isNotEmpty(resultMessage.getMessage()))
				return ResponseMessage.error(resultMessage.getMessage());
			else
				return ResponseMessage.error();
		}
	}
    public static ResponseMessage okObject(Object data){
        if(data==null){
            return new ResponseMessage(OK,"success",TOTAL, "没有找到可用对象");
        }else{
            return ResponseMessage.ok(data);
        }
    }

    public static ResponseMessage ok(Object data) {
        if(data==null){
            return error("查询对象为空");
        }else{
            if(data instanceof List<?>){
                List _obj = (List)data;
                if(_obj.size()<=0){
                    return new ResponseMessage(OK,"success",TOTAL, new ArrayList<>());
                }else{
                    return new ResponseMessage(OK,"success",((List) data).size(), data);
                }
            }
            return new ResponseMessage(OK,"success",1, data);
        }
    }
    public static ResponseMessage ok(long total,Object data) {
        if(data==null){
            return error("查询对象为空");
        }else{
            if(data instanceof List<?>){
                List _obj = (List)data;
                if(_obj.size()<=0){
                    return new ResponseMessage(OK,"success",0, new ArrayList<>());
                }
            }
            return new ResponseMessage(OK,"success",total, data);
        }
    }

    public static ResponseMessage error(String message) {
        return new ResponseMessage(message);
    }

    public static ResponseMessage error() {
        return new ResponseMessage(GLOBAL_EXCEPTION,"系统错误！",TOTAL,null);
    }

    public static ResponseMessage error(int code,String message) {
        return new ResponseMessage(code,message);
    }

    public static ResponseMessage error(int code,String message, Object object) {
        return new ResponseMessage(code,message,TOTAL_DEFAULT,object);
    }


}
