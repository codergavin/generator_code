# generator_code
自动生成service/dao/model代码
## 操作步骤
一、找到执行类“GeneratorCodeMain”
二、修改部分参数
1、可以根据需求修改下面的参数 "author"

2、修改generator配置文件里面的内容

    jdbc.url
    jdbc.driver
    jdbc.username
    jdbc.password
   
3、如果主键不是Integer、Long，需要把Mapper.xml的insert${ClassName}的keyProperty="${pkColumn.type}"属性去掉。

