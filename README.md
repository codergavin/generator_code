# generator_code
自动生成service/dao/model代码
## 操作步骤
```
1、可以根据需求修改下面的参数 "author"
2、修改generator.xml配置文件里面的内容
     2.1、jdbc.url
     2.2、jdbc.driver
     2.3、jdbc.username
     2.4、jdbc.password
     2.5、jdbc.schema
     2.6、jdbc.catalog
3、如果主键不是Integer、Long，需要把Mapper.xml的insert${ClassName}的keyProperty="${pkColumn.type}"属性去掉。
4、在GeneratorCodeMain类的main方法里面的map里面添加map.put("数据库表名","数据库表名说明解释");
```

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
    jdbc.schema
    jdbc.catalog

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
