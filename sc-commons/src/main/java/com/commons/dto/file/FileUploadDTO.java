package com.commons.dto.file;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @notes: 上传文件参数对象
 * @author: At
 * @date: 2018/4/10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "上传文件参数对象", description = "上传文件传输的参数对象实体")
public class FileUploadDTO {

    @ApiModelProperty(value = "用户Id", name = "loginUid", required = true, dataType = "String")
    @NotBlank(message = "用户id不能为空！")
    private String loginUid;

    @ApiModelProperty(value = "企业Id", name = "loginEid", dataType = "String", allowEmptyValue = true)
    private String loginEid;

    @NotBlank(message = "模板业务类型不能为空")
    @ApiModelProperty(name = "escrowType", value = "模板业务类型", required = true, dataType = "String")
    private String escrowType;

}
