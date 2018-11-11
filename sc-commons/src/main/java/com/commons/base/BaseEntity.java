package com.commons.base;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
  * @Description(功能描述): 超类
  * @author(作者): lrfalse<wangliyou>
  * @date (开发日期): 2018/10/10 19:23
  **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseEntity  implements Serializable {
	private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
	@Id
	@GeneratedValue(generator = "JDBC")
	private Long id;

	/**
	 * 创建时间
	 */
	@ApiModelProperty(hidden = true)
	private  String createTime;

	/**
	 * 创建者
	 */
//	@ApiModelProperty(hidden = true)
//	private String creator;

	/**
	 * 修改者
	 */
//	@ApiModelProperty(hidden = true)
//	private String modifier;

	/**
	 * 修改时间
	 */
//	@ApiModelProperty(hidden = true)
//	private String modifyTime;

	/**
	 * 删除标识(1表示删除)
	 */
//	@ApiModelProperty(hidden = true)
//	private Integer delFlag;

	/**
	 * 备注
	 */
//	@ApiModelProperty(hidden = true)
//	private String remark;

}
