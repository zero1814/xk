# xk

## 说明

> 基于spring cloud + jpa 开发的电商平台系统，主要包含前端(app，微信小程序)及后台管理系统

> 适用人群定位在二手周边交易人群，例如：商家对退换货不予处理，卖家需出售；买家想低价购物情景等。

##项目介绍
xk是一套完整的电商系统，包括app(android 基于uni-app)、微信小程序及后台管理系统，基于spring cloud 开发的分布式系统。

###项目架构
``` lua
xk
├── cloud-parent  -- 基于spring cloud的接口管理中心
				├── eureka-server  -- 搭建eureka的服务发现平台
				├── zuul-gateway-server -- 基于zuul的api gateway
				└── member-cloud   -- 系统相关api
├── product-center -- 商品中心
				├── product-entity  -- 商品实体类
				├── product-service -- 商品数据访问接口及业务处理接口实现
				└── product-cloud   -- 商品相关api
├── member-center  -- 会员中心
				├── member-entity  -- 会员实体类
				├── member-service -- 会员数据访问接口及业务处理接口实现
				└── member-cloud   -- 会员相关api
├── order-center   -- 订单中心
				├── member-entity  -- 订单实体类
				├── member-service -- 订单数据访问接口及业务处理接口实现
				└── member-cloud   -- 订单相关api
├── system-center  -- 系统中心
				├── member-entity  -- 系统实体类
				├── member-service -- 系统数据访问接口及业务处理接口实现
				└── member-cloud   -- 系统相关api
└── logger-center  -- 日志中心
				├── member-entity  -- 日志实体类
				├── member-service -- 日志数据访问接口及业务处理接口实现
				└── member-cloud   -- 日志相关api
```

##技术选型

#### 后端技术
----|----|----
技术 | 说明 | 官网
Spring cloud | 微服务架构 | [https://spring.io/projects/spring-boot](https://spring.io/projects/spring-boot)
Spring Security | 认证和授权框架 | [https://spring.io/projects/spring-security](https://spring.io/projects/spring-security)
Swagger-UI | 文档生产工具 | [https://github.com/swagger-api/swagger-ui](https://github.com/swagger-api/swagger-ui)
Hibernator-Validator | 验证框架 | [http://hibernate.org/validator/](http://hibernate.org/validator/)
Elasticsearch | 搜索引擎 | [https://github.com/elastic/elasticsearch](https://github.com/elastic/elasticsearch)
RabbitMq | 消息队列 | [https://www.rabbitmq.com/](https://www.rabbitmq.com/)
Redis | 分布式缓存 | [https://redis.io/](https://redis.io/)
MongoDb | NoSql数据库 | [https://www.mongodb.com/](https://www.mongodb.com/)
LogStash | 日志收集 | [https://github.com/logstash/logstash-logback-encoder](https://github.com/logstash/logstash-logback-encoder)
Lombok | 简化对象封装工具 | [https://github.com/rzwitserloot/lombok](https://github.com/rzwitserloot/lombok)

#### 前端技术

技术 | 说明 | 官网
----|----|----
Vue | 前端框架 | [https://vuejs.org/](https://vuejs.org/)
Vue-router | 路由框架 | [https://router.vuejs.org/](https://router.vuejs.org/)
Vuex | 全局状态管理框架 | [https://vuex.vuejs.org/](https://vuex.vuejs.org/)
Element | 前端UI框架 | [https://element.eleme.io/](https://element.eleme.io/)
Axios | 前端HTTP框架 | [https://github.com/axios/axios](https://github.com/axios/axios)
v-charts | 基于Echarts的图表框架 | [https://v-charts.js.org/](https://v-charts.js.org/)
Js-cookie | cookie管理工具 | [https://github.com/js-cookie/js-cookie](https://github.com/js-cookie/js-cookie)
nprogress | 进度条控件 | [https://github.com/rstacruz/nprogress](https://github.com/rstacruz/nprogress)

#### 模块介绍
##### 后台管理系统 `xk-admin-manager`

- 商品管理
- 会员管理
- 订单管理
- 系统管理

## 环境搭建

### 开发工具

工具 | 说明 | 官网
----|----|----
Eclipse | 开发IDE | https://www.eclipse.org/downloads/
RedisDesktop | redis客户端连接工具 | https://redisdesktop.com/download
Robomongo | mongo客户端连接工具 | https://robomongo.org/download
SwitchHosts| 本地host管理 | https://oldj.github.io/SwitchHosts/
X-shell | Linux远程连接工具 | http://www.netsarang.com/download/software.html
Navicat | 数据库连接工具 | http://www.formysql.com/xiazai.html
PowerDesigner | 数据库设计工具 | http://powerdesigner.de/
Axure | 原型设计工具 | https://www.axure.com/
MindMaster | 思维导图设计工具 | http://www.edrawsoft.cn/mindmaster
ScreenToGif | gif录制工具 | https://www.screentogif.com/
ProcessOn | 流程图绘制工具 | https://www.processon.com/
PicPick | 屏幕取色工具 | https://picpick.app/zh/

### 开发环境

工具 | 版本号 | 下载
----|----|----
JDK | 1.8 | https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
Mysql | 5.7 | https://www.mysql.com/
Redis | 3.2 | https://redis.io/download
Elasticsearch | 6.2.2 | https://www.elastic.co/downloads
MongoDb | 3.2 | https://www.mongodb.com/download-center
RabbitMq | 3.4.1 | http://www.rabbitmq.com/download.html
nginx | 1.10 | http://nginx.org/en/download.html


## 参考资料

- [Spring实战（第4版）](https://book.douban.com/subject/26767354/)
- [Spring Boot实战](https://book.douban.com/subject/26857423/)
- [Spring Cloud微服务实战](https://book.douban.com/subject/27025912/)
- [Spring Cloud与Docker微服务架构实战](https://book.douban.com/subject/27028228/)
- [Spring Data实战](https://book.douban.com/subject/25975186/)
- [MyBatis从入门到精通](https://book.douban.com/subject/27074809/)
- [深入浅出MySQL](https://book.douban.com/subject/25817684/)
- [循序渐进Linux（第2版）](https://book.douban.com/subject/26758194/)
- [Elasticsearch 权威指南](https://www.elastic.co/guide/cn/elasticsearch/guide/current/index.html)
- [Elasticsearch 技术解析与实战](https://book.douban.com/subject/26967826/)
- [MongoDB实战(第二版)](https://book.douban.com/subject/27061123/)
- [Kubernetes权威指南](https://book.douban.com/subject/26902153/)
- [Pro Git](https://git-scm.com/book/zh/v2)

### 搭建步骤

> 本地环境搭建