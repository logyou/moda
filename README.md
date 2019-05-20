# Moda
Moda 致力于提供微服务开发的一站式解决方案。此项目包含开发分布式应用微服务的常用组件，方便开发者轻松使用该系统架构来开发分布式应用服务。
# 主要功能
- **接口网关**：基于 Spring Cloud Gateway 的网关作为流量的入口，在微服务系统中有着非常重要的作用，网关常见的功能有路由转发、权限校验、限流控制等作用。
- **配置管理**：基于 Nacos 实现统一维护配置、API网关动态配置。
- **服务发现**：基于 Nacos 实现 Dubbo 服务注册、API网关动态路由。
- **限流控制**：基于 Sentinel 把流量作为切入点，从流量控制、熔断降级、系统负载保护等多个维度保护服务的稳定性。
- **接口文档**：基于 Swagger 自动生成接口文档，针对存在网关层的情况，实现了多个微服务接口文档组合为一个前端。
- **实时日志**：基于 Kafka+ELK 实现日志实时上报和分析，使用 Logback 直接写入 Kafka ,即插即用。
- **代码生成**：使用 MyBatis Generator 自动生成 Entity、DAO、XML ，自定义的和生成的隔离，可以多次覆盖生成，方便快捷。
- **系统监控**：搭配 Prometheus 和 Grafana 的监控系统，实时监控各种指标，在出现异常时及时发出警报。
- **链路追踪**：搭配 Elasticsearch 和 SkyWalking 的链路追踪 ，可跟踪调用走向和性能，有助于及时定位问题点。
- **消息队列**：基于 RabbitMQ 或 RocketMQ 的分布式消息系统，解耦系统。
# 系统架构图
查看大图地址：[https://www.processon.com/view/5cde23b0e4b06c0492f35bd1](https://www.processon.com/view/5cde23b0e4b06c0492f35bd1)
[![系统架构图](https://raw.githubusercontent.com/logyou/moda/master/moda-resources/images/archV4.jpg)](https://www.processon.com/view/5cde23b0e4b06c0492f35bd1)
