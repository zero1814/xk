######ClientDetailsServiceConfigurer 能够使用内存或 JDBC 方式实现获取已注册的客户端详情，有几个重要的属性：
+ clientId：客户端标识 ID
+ secret：客户端安全码
+ scope：客户端访问范围，默认为空则拥有全部范围
+ authorizedGrantTypes：客户端使用的授权类型，默认为空
+ authorities：客户端可使用的权限

######管理令牌（Managing Token）

+ ResourceServerTokenServices 接口定义了令牌加载、读取方法
+ AuthorizationServerTokenServices 接口定义了令牌的创建、获取、刷新方法
+ ConsumerTokenServices 定义了令牌的撤销方法
+ DefaultTokenServices 实现了上述三个接口,它包含了一些令牌业务的实现，如创建令牌、读取令牌、刷新令牌、获取客户端ID。默认的当尝试创建一个令牌时，是使用 UUID 随机值进行填充的，除了持久化令牌是委托一个 TokenStore 接口实现以外，这个类几乎帮你做了所有事情
+ 而 TokenStore 接口也有一些实现：
+ InMemoryTokenStore：默认采用该实现，将令牌信息保存在内存中，易于调试
+ JdbcTokenStore：令牌会被保存近关系型数据库，可以在不同服务器之间共享令牌
+ JwtTokenStore：使用 JWT 方式保存令牌，它不需要进行存储，但是它撤销一个已经授权令牌会非常困难，所以通常用来处理一个生命周期较短的令牌以及撤销刷新令牌

######下面是一些默认的端点 URL：

+ /oauth/authorize：授权端点
+ /oauth/token：令牌端点
+ /oauth/confirm_access：用户确认授权提交端点
+ /oauth/error：授权服务错误信息端点
+ /oauth/check_token：用于资源服务访问的令牌解析端点
+ /oauth/token_key：提供公有密匙的端点，如果你使用JWT令牌的话

