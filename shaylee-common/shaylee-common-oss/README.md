## 一、配置

``` yaml
# OSS配置
oss:
  # CloudProvider枚举(1阿里云)
  type: 1
  # OSS域名
  domain: https://avatar.shaylee.cn
  # 阿里云OSS
  aliyun:
    # 基础配置
    endPoint: oss-cn-hongkong.aliyuncs.com
    accesskeyid: xxxx
    accesskeysecret: xxxx
    bucketname: shayleebucket
```

## 二、使用方法
- 在需要使用的时候，使用如下代码获取CloudStorageService，调用内部上传方法即可
``` java
private AbstractCloudStorageService cloudStorageService = OSSFactory.build();
```