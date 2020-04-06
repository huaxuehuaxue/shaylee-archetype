package com.shaylee.common.oss.constant;

/**
 * Title: OSS相关常量
 * Project: shaylee-common
 *
 * @author Adrian
 * @date 2019-10-24
 */
public interface OSSConstant {
    /**
     * 云服务商
     */
    enum CloudProvider {
        /**
         * 阿里云
         */
        ALIYUN(1);

        private int value;

        CloudProvider(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
