package com.commons.dto.file;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @notes: 参数公共传输对象DTO 所有需要用户操作的接口参数DTO继承此对象
 * @author: At
 * @date: 2018/4/10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class FileIdsParamDTO  {

    //文件id 可以为空
    @ApiModelProperty(value = "文件id的数组",name = "fileIDs",dataType = "array",allowEmptyValue = true)
    private String[] fileIDs;
}
