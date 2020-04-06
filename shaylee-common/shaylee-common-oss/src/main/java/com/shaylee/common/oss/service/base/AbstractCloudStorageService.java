package com.shaylee.common.oss.service.base;

import com.shaylee.common.oss.config.CloudStorageConfig;

import java.io.InputStream;

/**
 * Title: 云存储抽象服务
 * Project: shaylee-common
 *
 * @author Adrian
 * @date 2019-10-24
 */
public abstract class AbstractCloudStorageService {

    /**
     * 云存储配置信息
     */
    protected CloudStorageConfig config;

    /**
     * 文件上传
     *
     * @param data 文件字节数组
     * @param url  相对路径，包含文件名(path/filename.suffix)
     * @return 返回http地址
     */
    public abstract String upload(byte[] data, String url);

    /**
     * 文件上传
     *
     * @param inputStream 字节流
     * @param path        相对路径，不包含文件名
     * @return 返回http地址
     */
    public abstract String upload(InputStream inputStream, String path);

    /**
     * 文件下载
     *
     * @param path     路径
     * @return OSS文件输入流
     */
    public abstract InputStream getInputStream(String path);

    /**
     * 文件删除
     *
     * @param path 路径
     */
    public abstract void delete(String path);
}
