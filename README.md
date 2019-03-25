
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

- 自动生成不重复的id和订单号

- 修复订单添加时数据超添加的问题

- 如何确保价格运算时不会丢失精度

- 集成 fastDFS 分布式文件系统

- 完善redis缓存添加

- 完成数据添加时事务管理

- 项目中使用拦截器

- 集成rabbitmq

- 完善swagger自动化接口测试

- 将日志信息添加到数据库

- 添加spring security 安全认证，完成用户-角色-权限添加


###日志配置文件暂存

```$xslt
 <appender name="DB-CLASSIC-MYSQL-POOL" class="ch.qos.logback.classic.db.DBAppender">
            <connectionSource class="ch.qos.logback.core.db.DataSourceConnectionSource">
                <dataSource class="org.apache.commons.dbcp.BasicDataSource">
                    <driverClassName>com.mysql.jdbc.Driver</driverClassName>
                    <url>jdbc:mysql://101.132.146.171:3306/spring?characterEncoding=UTF-8</url>
                    <username>root</username>
                    <password>root</password>
                </dataSource>
            </connectionSource>
            <!--这里设置日志级别为error-->
            <filter class="ch.qos.logback.classic.filter.LevelFilter">
                <level>error</level>
                <onMatch>ACCEPT</onMatch>
                <onMismatch>DENY</onMismatch>
            </filter>
        </appender>
```
