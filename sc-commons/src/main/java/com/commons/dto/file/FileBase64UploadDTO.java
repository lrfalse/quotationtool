package com.commons.dto.file;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description(功能描述): base64上传文件参数
 * @author(作者): liuym
 * @date (开发日期): 2018/8/23 9:55
 **/
@Data
public class FileBase64UploadDTO extends FileUploadDTO {

    /**
     * 业务id
     */
    @ApiModelProperty(value = "业务id", name = "businessGuid", dataType = "String")
    private String businessGuid;

}
