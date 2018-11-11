package com.commons.dto.file;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @notes: 文件业务更新对象
 * @author: At
 * @date: 2018/4/10
 */
@Data
@ApiModel(value = "文件业务更新对象",description = "文件业务更新对象参数")
public class FileUpDateParamDTO  {

    @ApiModelProperty(name = "businessId",value = "业务主键", required = true, dataType = "String")
    @NotBlank(message = "业务主键不能为空！")
    private String businessId;

    @ApiModelProperty(name = "fileIds",value = "文件ID（多个英文半角逗号分隔如1,2,3)", required = true, dataType = "String")
    @NotBlank(message = "文件ID不能为空！")
    private String fileIds;
}
