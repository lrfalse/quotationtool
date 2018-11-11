package com.commons.dto.file;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @notes: 文件上传参数 service使用
 * @author: At
 * @date: 2018/5/15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TemplateFileUploadParamDTO {

    private String filePath;

    private String fileType;

    private String md5;

    private Integer fileSize;

    private String fileName;

}
