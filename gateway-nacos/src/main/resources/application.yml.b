#简写方式，路由规则、断言、过滤器都不写
#不写断言，系统会自动将服务名当做断言，并且自动去掉第一层路径

server:
  port: 8064
spring:
  application:
    name: gateway-nacos

    #    gateway的配置，此种方式集成nacos
  cloud:
    gateway:
      discovery:
        locator:
          enabled: true #是否启动自动识别nacos服务

    #配置Nacos
    nacos:
      discovery:
        server-addr: 192.168.88.128:8848
        username: nacos
        password: nacos




