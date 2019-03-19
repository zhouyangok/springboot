
### Mac连接远程服务器linux
1、打开终端，输入sudo su -

2、输入 ：ssh -p 端口号 服务器用户名@ip （例如ssh -p 22 root@ip
）回车，到这会让你输入yes或者no来确认是否连接，输入yes回车。

3、输入服务器密码：******

4、连接成功。

### Mac 上传文件至linux服务器
scp -P 22 /target/springboot-0.0.1-SNAPSHOT.jar root@ip1:/root/project/springboot/

### Linux启动服务
java -jar springboot-0.0.1-SNAPSHOT.jar