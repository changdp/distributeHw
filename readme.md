#distrbuteHw Project 

## 写代码实现 Spring Bean装配
+ springAc 模块
  + Annotation 注解方式
    + Main.java 启动类

  + xml 方式
    + Main.java 启动类

-----
## 通过springMvc实现两个restful查询数据接口：
+ springMvcRestful 模块
  + SpringMvcRestfulApplicaion.java 启动类
  + Hw2Controller.java 
    + /user/getJson/{id}  返回json数据
    + /user/getXml/{name} 返回xml数据
-----
## 新建一个Springboot项目，远程调用方式访问

+ callMvcRestful 模块
  + CallMvcRestfulApplication.java 启动类
  + CallMvcRestful.java
    + getUser/{param}  HttpUrlConnection调用
    + getUser2/{param} Httpclient调用
    + getUser3/{param} restTemplate调用
    + getUser4/{param} jersey client调用
    
# 验证与启动顺序
    作业1
        Annotation装配方式：
            annotation.Main.java 启动类
        xml装配方式：
            xml.Main.java 启动类
    作业2、3启动顺序：
        1、启动springMvcRestful中的SpringMvcRestfulApplicaion
        2、启动callMvcRestful中的CallMvcRestfulApplication
        3、浏览器或curl命令方式：
            springMvcRestful:
                localhost:8081/user/getJson/{id}
                localhost:8081/user/getXml/{name}
            callMvcRestful:
                localhost:8080/getUserX/{param} 参见callMvcRestful模块

