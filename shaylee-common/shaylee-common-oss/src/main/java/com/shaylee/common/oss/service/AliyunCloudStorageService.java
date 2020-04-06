package com.shaylee.common.oss.service;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.OSSObject;
import com.shaylee.common.core.base.exception.BaseException;
import com.shaylee.common.oss.config.CloudStorageConfig;
import com.shaylee.common.oss.constant.OSSErrorCode;
import com.shaylee.common.oss.service.base.AbstractCloudStorageService;
import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * Title: 阿里云存储
 * Project: shaylee-common
 *
 * @author Adrian
 * @date 2019-10-24
 */
@Slf4j
public class AliyunCloudStorageService extends AbstractCloudStorageService {

    public AliyunCloudStorageService(CloudStorageConfig config) {
        this.config = config;
    }

    /**
     * 构建OSSClient
     * 多个方法共用OSSClient实例时，前端连续提交会出现异常，因此OSSClinet要在每次文件操作的时候创建。
     *
     * @return OSSClient
     */
    private OSS buildOSSClient() {
        return new OSSClientBuilder().build(config.getAliyunEndPoint(), config.getAliyunAccessKeyId(),
                config.getAliyunAccessKeySecret());
    }

    @Override
    public String upload(byte[] data, String path) {
        return upload(new ByteArrayInputStream(data), path);
    }

    @Override
    public String upload(InputStream inputStream, String path) {
        OSS client = this.buildOSSClient();
        try {
            client.putObject(config.getAliyunBucketName(), path, inputStream);
            client.shutdown();
        } catch (Exception e) {
            throw new BaseException(OSSErrorCode.OSS_UPLOAD_FILE_ERROR, e);
        }
        return path;
    }

    @Override
    public InputStream getInputStream(String path) {
        OSS client = this.buildOSSClient();
        OSSObject ossObject = client.getObject(config.getAliyunBucketName(), path);
        return ossObject.getObjectContent();
    }

    @Override
    public void delete(String path) {
        OSS client = this.buildOSSClient();
        client.deleteObject(config.getAliyunBucketName(), path);
    }
}