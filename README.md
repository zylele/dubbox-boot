# dubbox-demo

## dubbox-demo

dubbox-demo是一个基于dubbox、SpringBoot、旨在帮助开发者能迅速构建启动dubbox项目的demo，入手即用，并且同时集成了多个运维工具供选择，例如服务治理及服务监控，依赖关系等图表展示功能

## dubbox-demo包含哪些功能

- 服务提供者示例
- 服务消费者示例
- 数据库、缓存、dubbo配置管理
- 集合服务治理、运维工具

## 准备

建议在maven安装目录下的`conf\settings.xml`的`<mirrors>`标签中添加如下镜像，以提高maven打包速度

```xml
<mirror>
    <id>alimaven</id>
    <name>aliyun maven</name>
    <url>http://maven.aliyun.com/nexus/content/groups/public/</url>
    <mirrorOf>central</mirrorOf>
</mirror>
```

下载dubbox源码并且编译：

> git clone git@github.com:dangdangdotcom/dubbox.git
执行maven命令`mvn clean install -Dmaven.test.skip`

## 快速启动

- 下载源码`git clone git@github.com:zylele/dubbox-demo.git`

- 生成eclipse项目`mvn eclipse:eclipse`

- 导入eclipse

- 执行初始化[init.sql](init.sql)

- 启动`ZooKeeper`

- 启动提供者`UserServiceProvider`和`DynamicServiceProvider`

- 启动消费者`XybaseConsumer`

- 访问`http://localhost:1000/user/{1,2,3}`，`http://localhost:1000/dynamic/{1,2,3}`

服务主要配置详情请点击我的博文[dubbox快速指南](http://lle.coding.me/2017/03/07/dubbo-demo/)

## 服务治理与运维

### dubbo原生管理控制台

> 管理控制台为内部裁剪版本，开源部分主要包含：路由规则，动态配置，服务降级，访问控制，权重调整，负载均衡，等管理功能

- 将`dubbox\dubbo-admin\target`下的war包部署到Tomcat解压，配置`WEB-INF\dubbo.properties`，启动访问

![](http://lle.coding.me/img/dubbox-demo/dubbo-admin.png)

### dubbo原生Simple监控中心

> 监控中心也是一个标准的Dubbo服务，可以通过注册中心发现，也可以直连
Simple Monitor挂掉不会影响到Consumer和Provider之间的调用，所以用于生产环境不会有风险
Simple Monitor采用磁盘存储统计信息，请注意安装机器的磁盘限制

- 将`dubbox\dubbo-simple\dubbo-monitor-simple\target`下的压缩文件解压配置`conf\dubbo.properties`，charts目录必须放在jetty.directory下，否则页面上访问不了

- 运行`bin\stat.bat(sh)`

- 访问`localhost:{dubbo.jetty.port}`，dubbo.jetty.port为上述dubbo.properties中的配置端口

![](http://lle.coding.me/img/dubbox-demo/dubbo-monitor-simple.png)

### dubbo-monitor-x

> oschina有一个开源项目：[http://git.oschina.net/handu/dubbo-monitor](http://git.oschina.net/handu/dubbo-monitor) （为了与dubbox里的dubbo-monitor子项目名称上分开，我在后面加了-x），其中的开发者之一：马金凯，也是dubbox的作者之一。与官网的监控存储方案不同，dubbo-monitor-x是把数据保存在mysql里的

- 进入operations下的**dubbo-monitor-x**

- 视自身情况配置`src\main\resources\application.properties`(数据库名无需修改，否则请一并修改初始化sql中的数据库名)

- 执行[create.sql](dubbox-operations/dubbo-monitor-x/sql/create.sql)

- 执行maven命令`mvn clean install -Dmaven.test.skip`，target下将生成一个war包，部署到Tomcat即可启动访问

![](http://lle.coding.me/img/dubbox-demo/dubbo-monitor-x.png)

### Dubbokeeper

> 这是托管在git上的项目，地址为：[https://github.com/dubboclub/dubbokeeper](https://github.com/dubboclub/dubbokeeper)，从github用户信息上的邮箱后缀看，可能是阿里云的人发起的，与前面的项目不同，这个项目把管理+监控集成在一起了，而且存储方案除了mysql，还支持mongodb，lucene，如果这个项目逐渐完善了，最有前途

该项目部署以用mysql存储为例

- 进入operations下的**dubbokeeper**

- 视自身情况配置`conf\dubbo-mysql.properties`(数据库名无需修改，否则请一并修改初始化sql中的数据库名)

- 执行[doc\storage\mysql\sql\application.sql](dubbox-operations/dubbokeeper/doc/storage/mysql/sql/application.sql)

- 视自身情况配置`dubbokeeper-ui\src\main\resources\dubbo.properties`

- 执行根目录下的`install-mysql.bat(sh)`

- 执行`target\mysql-dubbokeeper-server\bin\start-mysql.bat(sh)`，便启动了dk的存储(mysql-dubbokeeper-server本身就是一个dubbo服务，用于保存监控数据)

- 将`target\mysql-dubbokeeper-ui`的war包部署到Tomcat，启动即可访问Dubbo监控展示

![](http://lle.coding.me/img/dubbox-demo/dubbokeeper-admin.png)

![](http://lle.coding.me/img/dubbox-demo/dubbokeeper-monitor.png)

![](http://lle.coding.me/img/dubbox-demo/dubbokeeper-dpc.png)

### 推荐搭配：

- 原生dubbo-admin + dubbo-monitor-simple

- 原生dubbo-admin + dubbo-monitor-x

- dubbokeeper

监控服务，如果同时起多个，dubbo-admin里会有警告，而且监控数据存多份，也没必要

---

dubbox还具有相当多的配置功能，如负载均衡、集群容错，多协议、多注册中心等

更多示例与参考手册，可查看[dubbo用户指南](http://dubbo.io/User+Guide-zh.htm)