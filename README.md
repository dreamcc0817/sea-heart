#### 核心依赖 


依赖 | 版本
---|---
Spring Boot |  2.1.6.RELEASE  
Spring Cloud | Greenwich.SR1   


#### 模块说明
```lua
pig
├── pig-auth -- 授权服务提供[9000]
└── pig-common -- 系统公共模块 
     ├── pig-common-core -- 公共工具类核心包
     ├── pig-common-log -- 日志服务
     └── pig-common-security -- 安全工具类
├── pig-config -- 配置中心[8888]
├── pig-eureka -- 服务注册与发现[7001]
├── pig-gateway -- Spring Cloud Gateway网关[9999]
└── pig-upms -- 通用用户权限管理模块
     └── pig-upms-api -- 通用用户权限管理系统公共api模块
     └── pig-upms-server -- 通用用户权限管理系统业务处理模块[4000]
└── pig-visual  -- 图形化模块 
     ├── pig-monitor -- Spring Boot Admin监控 [5001]
     ├── pig-zipkin -- 链路调用监控 [5002]
     └── pig-codegen -- 图形化代码生成[5003]