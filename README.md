# generator_code
自动生成service/dao/model代码
## 操作步骤

一、找到执行类“GeneratorCodeMain”  
    ```
        generator.xml 配置数据库信息
        GeneratorCodeMain 执行主类
    ```

二、修改部分参数

* 1、可以根据需求修改下面的参数 "author"

* 2、修改generator配置文件里面的内容

    jdbc.url
    jdbc.driver
    jdbc.username
    jdbc.password

* 3、基础功能介绍
   * Mapper.xml：
       ```
       ①、查询列表
       ②、根据主键查看实体
       ③、新增
       ④、更新
       ⑤、单个、批量删除
       ```
   * Model.java:  
        ```
        重写toString()方法；
        ```
