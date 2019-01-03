package com.commons.message;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * 用于Dao 和 Service层之间数据状态交换
 * @author zhoubo
 * @date 2017/2/10
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultMessage implements Serializable {

    /**
     * 正常
     */
    public static final int OK=0;
    /**
     * 正常错误
     */
    public static final int ERROR=1;

    private int code;
    private String message="";
    private Object data;
    private Object extraData;

    public ResultMessage() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getExtraData() {
        return extraData;
    }

    public void setExtraData(Object extraData) {
        this.extraData = extraData;
    }

    protected ResultMessage(int code){
        this.code=code;
    }

    protected ResultMessage(int code,String message){
        this.code=code;
        this.message=message;
    }

    protected ResultMessage(int code,String message,Object data){
        this.code=code;
        this.message=message;
        this.data=data;
    }

    protected ResultMessage(int code, String message, Object data, Object extraData) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.extraData = extraData;
    }

    public boolean isOK(){
        if(this.getCode()==OK){
            return true;
        }else{
            return false;
        }
    }

    /**
      * @Description(功能描述): 结果构造，result>0成功 else 失败 or数据对象类型
      * @author(作者): lrfalse<wangliyou>
      * @date(开发日期): 2018/7/27 14:30
      **/
	public static ResultMessage build(Object result){
		if(result.getClass().getTypeName().indexOf("Integer")>0){
			if((int)result>0){
				return buildOK();
			}else{
				return buildError("系统处理异常，操作失败！");
			}
		}else{
			return buildOK(result);
		}
	}
    public static ResultMessage buildOK(){
        return new ResultMessage(OK);
    }

    public static ResultMessage buildOK(Object data){
        return new ResultMessage(OK,"",data);
    }

    public static ResultMessage buildOK(Object data,Object extraData){
        return new ResultMessage(OK,"",data,extraData);
    }

    public static ResultMessage buildError(String msg){
        return new ResultMessage(ERROR,msg);
    }

    public static ResultMessage buildError(int code,String msg){
        return new ResultMessage(code,msg);
    }
    public static ResultMessage buildError(int code,String msg,Object data){
        return new ResultMessage(code,msg,data);
    }
}
