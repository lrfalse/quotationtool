package com.commons.dto.file;

import lombok.Data;

/**
 * @notes: 根据文件业务id查询文件详情数据
 * @author: liuym
 * @date: 2018/7/10
 */
@Data
public class FileDetailDTO {
    /**
     * 文件Id
     */
    private String guid;

    /**
     * 企业id
     */
    private String enterpriseGuid;

    /**
     * 用户id
     */
    private String userGuid;

    /**
     * 附件名称
     */
    private String fileName;

    /**
     * 附件路径
     */
    private String filePath;

    /**
     * 托管模块模块
     */
    private String escrowType;

    /**
     * 附件上传时间
     */
    private String fileUploadTime;

    /**
     * 附件大小
     */
    private Integer fileSize;

    /**
     * 附件类型
     */
    private String fileType;
}
