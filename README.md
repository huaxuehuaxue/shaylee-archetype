# shaylee-archetype
shaylee-archetype，一套基于SpirngCloud的简洁轻量后端开发模板

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