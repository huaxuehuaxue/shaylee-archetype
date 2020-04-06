package com.shaylee.common.oss.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Title: 云存储配置文件(目前只支持阿里云)
 * Project: shaylee-common
 *
 * @author Adrian
 * @date 2019-10-24
 */
@Getter
@Setter
@Component("cloudStorageConfig")
public class CloudStorageConfig implements Serializable {
    private static final long serialVersionUID = -3109322525140169249L;

    @Value("${oss.type}")
    private Integer type;

    @Value("${oss.domain}")
    private String domain;

    @Value("${oss.aliyun.endPoint}")
    private String aliyunEndPoint;

    @Value("${oss.aliyun.accesskeyid}")
    private String aliyunAccessKeyId;

    @Value("${oss.aliyun.accesskeysecret}")
    private String aliyunAccessKeySecret;

    @Value("${oss.aliyun.bucketname}")
    private String aliyunBucketName;
}
