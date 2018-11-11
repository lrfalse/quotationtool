package com.commons.message;

import com.alibaba.fastjson.JSON;
import com.commons.exception.BusinessException;
import com.commons.utils.DateTimeUtils;
import com.commons.utils.StringUtils;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.*;

/**
 * Controller层返回UI层类型定义
 * @author zhoubo
 * @date 2017/2/10
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseMessage implements Serializable {
    /**
     * 正常
     */
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
	 * feign连接超时或者异常错误
	 */
	public static final int FEIGN_EXCEPTION=-3;

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
    private int code;
    /**
     * 反馈信息
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private transient String message;
    /**
     * 反馈数据
     */
    private Object data;

    private Object extraData;
    private String token;
    /**
     * 列表总行数
     */
    private long total=TOTAL_DEFAULT;
    /**
     * 过滤字段：指定需要序列化的字段
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private transient Map<Class<?>, Set<String>> includes;
    /**
     * 过滤字段：指定不需要序列化的字段
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private transient Map<Class<?>, Set<String>> excludes;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private transient String callback;

    public ResponseMessage(int code, String message, int total, Object data, Object extraData) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.extraData = extraData;
        this.total = total;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        if (data != null) {
            map.put("data", this.getData());
        }
        if (message != null) {
            map.put("message", this.getMessage());
        }
        map.put("code", this.getCode());
        map.put("total", this.getTotal());
        return map;
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
    protected ResponseMessage(int code,String message, long total, Object data,String token) {
        this.code = code;
        this.message=message;
        this.data=data;
        this.total=total;
        this.token=token;
    }

    public ResponseMessage(int code, String message, Object data, Object extraData, long total) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.extraData = extraData;
        this.total = total;
    }

    public boolean isOK(){
        if(this.getCode()==OK){
            return true;
        }else{
            return false;
        }
    }
    /**
      * @Description(功能描述): feign 接口请求资源判断是否异常
      * @author(作者): lrfalse<wangliyou>
      * @date(开发日期): 2018/8/19 17:48
      **/
    public boolean isFeignOK(){
    	if(this.getCode()==-2){
    		throw new BusinessException(this.message);
		}
        if(this.getCode()==OK){
            return true;
        }else{
            return false;
        }
    }
    public ResponseMessage include(Class<?> type, String... fields) {
        return include(type, Arrays.asList(fields));
    }

    public ResponseMessage include(Class<?> type, Collection<String> fields) {
        if (includes == null) {
            includes = new HashMap<>();
        }
        if (fields == null || fields.isEmpty()) {return this;}
        fields.forEach(field -> {
            if (field.contains(".")) {
                String tmp[] = field.split("[.]", 2);
                try {
                    Field field1 = type.getDeclaredField(tmp[0]);
                    if (field1 != null) {
                        include(field1.getType(), tmp[1]);
                    }
                } catch (Throwable e) {
                }
            } else {
                getStringListFormMap(includes, type).add(field);
            }
        });
        return this;
    }

    public ResponseMessage exclude(Class type, Collection<String> fields) {
        if (excludes == null) {
            excludes = new HashMap<>();
        }
        if (fields == null || fields.isEmpty()){
            return this;
        }
        fields.forEach(field -> {
            if (field.contains(".")) {
                String tmp[] = field.split("[.]", 2);
                try {
                    Field field1 = type.getDeclaredField(tmp[0]);
                    if (field1 != null) {
                        exclude(field1.getType(), tmp[1]);
                    }
                } catch (Throwable e) {
                }
            } else {
                getStringListFormMap(excludes, type).add(field);
            }
        });
        return this;
    }

    public ResponseMessage exclude(Collection<String> fields) {
        if (excludes == null) {
            excludes = new HashMap<>();
        }
        if (fields == null || fields.isEmpty()){
            return this;
        }
        Class type;
        if (data != null) {
            type = data.getClass();
        } else {
            return this;
        }
        exclude(type, fields);
        return this;
    }

    public ResponseMessage include(Collection<String> fields) {
        if (includes == null) {
            includes = new HashMap<>();
        }
        if (fields == null || fields.isEmpty()){ return this;}
        Class type;
        if (data != null){
            type = data.getClass();
        } else {
            return this;
        }
        include(type, fields);
        return this;
    }

    public ResponseMessage exclude(Class type, String... fields) {
        return exclude(type, Arrays.asList(fields));
    }

    public ResponseMessage exclude(String... fields) {
        return exclude(Arrays.asList(fields));
    }

    public ResponseMessage include(String... fields) {
        return include(Arrays.asList(fields));
    }

    protected Set<String> getStringListFormMap(Map<Class<?>, Set<String>> map, Class type) {
        Set<String> list = map.get(type);
        if (list == null) {
            list = new HashSet<>();
            map.put(type, list);
        }
        return list;
    }

    public static int getGlobalException() {
        return GLOBAL_EXCEPTION;
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

    public Object getExtraData() {
        return extraData;
    }

    public void setExtraData(Object extraData) {
        this.extraData = extraData;
    }

    public long getTotal() {
        return total;
    }
    @Override
    public String toString() {
        return JSON.toJSONStringWithDateFormat(this, DateTimeUtils.YEAR_MONTH_DAY_HOUR_MINUTE_SECOND);
    }


    /**
      * @Description(功能描述): token错误返回信息
      * @author(作者): lrfalse<wangliyou>
      * @date(开发日期): 2018/8/14 11:55
      **/
	public String toErrorString() {
		return "{\"code\":"+this.getCode()+",\"message\":\""+this.getMessage()+"\",\"oK\":false,\"total\":-1}";
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public static ResponseMessage fromJson(String json) {
        return JSON.parseObject(json, ResponseMessage.class);
    }

    public Map<Class<?>, Set<String>> getExcludes() {
        return excludes;
    }

    public Map<Class<?>, Set<String>> getIncludes() {
        return includes;
    }

    public ResponseMessage callback(String callback) {
        this.callback = callback;
        return this;
    }

    public String getCallback() {
        return callback;
    }

    public static ResponseMessage ok() {
        return new ResponseMessage(OK,"success");
    }

    public static ResponseMessage okArray(Object data){
        if(data==null){
            return new ResponseMessage(OK,"success",TOTAL, new ArrayList<>());
        }else{
            return ResponseMessage.ok(data);
        }
    }

    public static ResponseMessage okArray(long total,Object data){
        if(data==null){
            return new ResponseMessage(OK,"success",TOTAL, new ArrayList<>());
        }else{
            return ResponseMessage.ok(total,data);
        }
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
	public static ResponseMessage ok(Object data,Object extraData) {
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
			return new ResponseMessage(OK,"success",1, data,extraData);
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
    /**
      * @Description(功能描述): feign连接错误
      * @author(作者): lrfalse<wangliyou>
      * @date(开发日期): 2018/8/31 9:09
      **/
    public static ResponseMessage errorFeign() {
        return new ResponseMessage(FEIGN_EXCEPTION,"远程服务错误！",TOTAL,null);
    }
    /**
     * @Description(功能描述): feign连接错误
     * @author(作者): lrfalse<wangliyou>
     * @date(开发日期): 2018/8/31 9:09
     **/
    public static ResponseMessage errorFeign(Object data) {
        return new ResponseMessage(FEIGN_EXCEPTION,"远程服务错误！",TOTAL,data);
    }

    public static ResponseMessage error(int code,String message) {
        return new ResponseMessage(code,message);
    }

    public static ResponseMessage error(int code,String message, Object object) {
        return new ResponseMessage(code,message,TOTAL_DEFAULT,object);
    }

    public static int getOK() {
        return OK;
    }

    public static int getERROR() {
        return ERROR;
    }

    public static int getTotalDefault() {
        return TOTAL_DEFAULT;
    }

    public static int getTOTAL() {
        return TOTAL;
    }
}
