package com.shaylee.common.oss.factory;

import com.shaylee.common.core.utils.SpringContextHolder;
import com.shaylee.common.oss.config.CloudStorageConfig;
import com.shaylee.common.oss.constant.OSSConstant;
import com.shaylee.common.oss.service.AliyunCloudStorageService;
import com.shaylee.common.oss.service.base.AbstractCloudStorageService;

/**
 * Title: OSSFactory
 * Project: shaylee-common
 *
 * @author Adrian
 * @date 2019-10-24
 */
public final class OSSFactory {

    private static CloudStorageConfig config;

    static {
        OSSFactory.config = SpringContextHolder.getBean(CloudStorageConfig.class);
    }

    public static AbstractCloudStorageService build() {
        if (config.getType() == OSSConstant.CloudProvider.ALIYUN.getValue()) {
            return new AliyunCloudStorageService(config);
        }
        return null;
    }
}