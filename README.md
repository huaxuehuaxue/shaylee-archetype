# shaylee-archetype
shaylee-archetype，一套基于SpirngCloud的简洁轻量后端开发模板

### 环境说明
- jdk 1.8
- mysql 5.7.8+
- redis 3.2+
- maven 3.5 +
- lombok插件

### 基础服务

| 服务       | 使用技术               | 进度 | 备注                             |
| ---------- | ---------------------- | ---- | -------------------------------- |
| 注册中心   | Nacos                  | ✅    |                                  |
| 配置中心   | Nacos                  | ✅    |                                  |
| 消息队列   | Rabbitmq               | 🏗    | 基于补偿的死信,丢失,重复消费处理 |
| 动态网关   | SpringCloud Gateway    | ✅    | 数据库配置                       |
| 授权认证   | Spring Security OAuth2 | 🏗    | Jwt模式                          |
| 服务容错   | SpringCloud Sentinel   | ✅    |                                  |
| 服务调用   | SpringCloud OpenFeign  | 🏗    |                                  |
| 分布式事务 | Seata                  | 🏗    |                                  |
| 对象存储   | OSS                    | ✅    |                                  |
| 任务调度   | Elastic-Job            | 🏗    |                                  |
| 分库分表   | ShardingSphere         | ✅    |                                  |
| CRUD       | PageHelper + Mapper    | ✅    |                                  |
| 缓存       | Redis                  | ✅    | 扩展@Cacheable添加失效时间支持   |

### 开发运维

| 服务     | 使用技术          | 进度 | 备注 |
| -------- | ----------------- | ---- | ---- |
| 文档管理 | Swagger2          | 🏗    |      |
| 服务监控 | Spring Boot Admin | ✅    |      |
| 链路追踪 | SkyWalking        | 🏗    |      |
| 日志管理 | ELK               | 🏗    |      |
| 监控告警 | Grafana           | 🏗    |      |

### 服务端口

| 服务模块            | 端口号 | 备注           |
| ------------------- | ------ | -------------- |
| shaylee-api         | 6290   | API服务        |
| shaylee-admin       | 6810   | 后台服务       |
| shaylee-mq-consumer | 6920   | MQ统一消费服务 |
| shaylee-schedule    | 6910   | 定时任务服务   |
| shaylee-gateway     | 6190   | 网关服务       |
| shaylee-monitor     | 6110   | 监控服务       |
| shaylee-nacos       | 29959  | 注册中心       |
| shaylee-sentinel    | 29820  | 流量监控       |

### 配置本地hosts
```
127.0.0.1 shaylee-register
127.0.0.1 shaylee-sentinel
127.0.0.1 shaylee-monitor
```

