package com.commons.dto.file;

import lombok.Data;

/**
 * @notes: 文件上传结果DTO
 * @author: At
 * @date: 2018/3/28
 */
@Data
public class UploadFileResultDTO {
    //文件key
    private String fileKey;
    //aliOSS 文件地址
    private String filePath;
    //文件Md5
    private String fileMd5;
    //
    private String eTag;

    public UploadFileResultDTO() {
    }

    public UploadFileResultDTO(String fileKey, String filePath, String fileMd5, String eTag) {
        this.fileKey = fileKey;
        this.filePath = filePath;
        this.fileMd5 = fileMd5;
        this.eTag = eTag;
    }
}
