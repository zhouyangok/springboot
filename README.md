
### Mac连接远程服务器linux
1、打开终端，输入sudo su -

2、输入 ：ssh -p 端口号 服务器用户名@ip （例如ssh -p 22 root@ip
）回车，到这会让你输入yes或者no来确认是否连接，输入yes回车。

3、输入服务器密码：******

4、连接成功。

### Mac 上传文件至linux服务器
scp -P 22 /target/springboot-0.0.1-SNAPSHOT.jar root@ip:/root/project/springboot/

### Linux启动服务
java -jar springboot-0.0.1-SNAPSHOT.jar

###spring boot项目计划

- 2019年3月20日:完成订单信息添加和订单详情添加。

###spring boot 项目未完成

- 添加配置文件中数据库密码加密功能（已完成）

- 自动生成不重复的id和订单号(已完成)

- 修复订单添加时数据超添加的问题(已完成)

- 如何确保价格运算时不会丢失精度(已完成)

- 集成 fastDFS 分布式文件系统

- 完善redis缓存添加（已完成）

- 完成数据添加时事务管理（已完成）

- 项目中使用拦截器(已完成)

- 集成rabbitmq（已完成http://101.132.146.171:15672查看rabbit页面）

- 集成druid对数据库进行监控(已完成http://localhost:8082/druid/index.html，用户名admin，密码admin)

- 完善swagger自动化接口测试（http://127.0.0.1:8082/swagger-ui.html#/）

- 将日志信息添加到数据库(使用AOP将日志添加到数据库完成，待完善)

- 添加spring security 安全认证，完成用户-角色-权限添加

- 集成mybatis generator 自动生成代码插件。


###日志配置文件暂存

```$xslt
 sout
 写代码使用
```


###更改
2019-04-11 由于阿里云redis报连接异常，将redis切换为本机redis。