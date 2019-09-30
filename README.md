spring-boot-starter-jdbc hikari多数据源starter

**使用方法**
 - pom 添加starter,版本使用最新版(maven库为公司私服)
 ```maven
<dependency>
    <groupId>org.chieftain</groupId>
    <artifactId>dynamicds-hikaricp-spring-boot-starter</artifactId>
    <version>1.3.1</version>
</dependency>
```
 - 启动类排查DataSource的自动配置
 ```java
 @SpringBootApplication(
      exclude={
          DataSourceAutoConfiguration.class
      }
  )
  ```
 - application.yml 添加配置,注意是最顶级,enable为开启数据源,master-key是设值默认数据源,值对应dynamic-data-source下的数据源数组的key,不填默认为master,dynamic-data-source为数据库的连接信息和连接池信息,key为每个数据源的标识
 ```yml
 dbconfig:
   hikariconfig:
     enable: true
     master-key: master
     dynamic-data-source:
       - key: master
         driver-class-name: oracle.jdbc.driver.OracleDriver
         #url: jdbc:oracle:thin:@192.168.1.64:1521/testdb
         url: jdbc:oracle:thin:@192.168.1.3:1522/henan
         #url: jdbc:oracle:thin:@zhimao1.uttcare.com:7897/henan
         username: ZZ_visual_display
         password: ZZ_visual_display
         minimum-idle: 5
         maximum-pool-size: 20
         auto-commit: true
         idle-timeout: 30000
         pool-name: HikariCP
         max-lifetime: 1800000
         connection-timeout: 10000
         connection-test-query: select 1 from dual
       - key: slave1
         driver-class-name: oracle.jdbc.driver.OracleDriver
         #url: jdbc:oracle:thin:@192.168.1.64:1521/testdb
         url: jdbc:oracle:thin:@192.168.1.64:1521/testdb
         #url: jdbc:oracle:thin:@zhimao1.uttcare.com:7897/henan
         username: meihua_bk
         password: meihua_bk
         minimum-idle: 5
         maximum-pool-size: 20
         auto-commit: true
         idle-timeout: 30000
         pool-name: HikariCP
         max-lifetime: 1800000
         connection-timeout: 10000
         connection-test-query: select 1 from dual
 ```
 