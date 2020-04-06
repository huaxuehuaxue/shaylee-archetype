package com.shaylee.common.oss.constant;

/**
 * Title: OSS异常码(10通用服务 02云存储 XX具体异常)
 * Project: shaylee-common
 *
 * @author Adrian
 * @date 2019-10-24
 */
public interface OSSErrorCode {

    /**
     * OSS配置错误
     */
    String OSS_CONFIG_ERROR = "100201";

    /**
     * OSS文件上传错误异常
     */
    String OSS_UPLOAD_FILE_ERROR = "100202";

    /**
     * 文件为空异常
     */
    String UPLOAD_FILE_EMPTY = "100203";

}
