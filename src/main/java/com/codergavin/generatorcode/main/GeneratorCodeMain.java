package com.codergavin.generatorcode.main;

import com.codergavin.generatorcode.common.Column;
import com.codergavin.generatorcode.common.Table;
import com.codergavin.generatorcode.utils.CamelCaseUtils;
import com.codergavin.generatorcode.utils.FileHelper;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.filechooser.FileSystemView;
import java.io.*;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Gavin Lee
 * @version 1.0
 * @date 2020-11-16 10:14
 * @desc 生成代码脚本
 */
public class GeneratorCodeMain {
    private Logger logger = LoggerFactory.getLogger(GeneratorCodeMain.class);
    private Properties properties;

    /**
     * 读取配置文件
     *
     * @throws Exception
     */
    public GeneratorCodeMain() throws Exception {
        properties = new Properties();
        String fileDir = this.getClass().getClassLoader().getResource("generator.xml").getFile();
        properties.loadFromXML(new FileInputStream(fileDir));
    }

    /**
     * 解析数据表
     *
     * @param tableName
     * @return
     * @throws Exception
     */
    public Table parseTable(String tableName) throws Exception {
        String driverName = properties.getProperty("jdbc.driver");
        String userName = properties.getProperty("jdbc.username");
        String userPwd = properties.getProperty("jdbc.password");
        String dbURL = properties.getProperty("jdbc.url");

        String catalog = properties.getProperty("jdbc.catalog");
        String schema = properties.getProperty("jdbc.schema");
        schema = schema == null ? "%" : schema;
        String column = "%";

        logger.debug("driver>>" + driverName);
        logger.debug("url>>" + dbURL);
        logger.debug("name>>" + userName);
        logger.debug("password>>" + userPwd);
        logger.debug("catalog>>" + catalog);
        logger.debug("schema>>" + schema);

        Class.forName(driverName);
        Connection connection = java.sql.DriverManager.getConnection(dbURL, userName, userPwd);
        DatabaseMetaData dmd = connection.getMetaData();

        ResultSet rs = dmd.getColumns(catalog, schema, tableName, column);
        List<Column> columns = new ArrayList<>();
        Map<String,Column> colNameAndMap = new HashMap<>();
        while (rs.next()) {
            Column c = new Column();

            String remaks = rs.getString("REMARKS");

            c.setLabel(StringUtils.isBlank(remaks) ? "" : remaks);

            String name = rs.getString("COLUMN_NAME");
            c.setName(CamelCaseUtils.toCamelCase(name));
            c.setDbName(name);

            String dbType = rs.getString("TYPE_NAME");

            int columnSize = rs.getInt("COLUMN_SIZE");
            if (dbType.equalsIgnoreCase("CHAR")) {
                c.setType("String");
            } else if (dbType.equalsIgnoreCase("VARCHAR")){
                c.setType("String");
            } else if (dbType.equalsIgnoreCase("LONGVARCHAR")){
                c.setType("String");
            } else if (dbType.equalsIgnoreCase("serial")){
                c.setType("Integer");
            } else if (dbType.equalsIgnoreCase("int4")){
                c.setType("Integer");
            } else if (dbType.equalsIgnoreCase("TINYINT")){
                c.setType("Integer");
            } else if (dbType.equalsIgnoreCase("TINYINT UNSIGNED")){
                c.setType("Integer");
            } else if (dbType.equalsIgnoreCase("SMALLINT")){
                c.setType("Integer");
            } else if (dbType.equalsIgnoreCase("INTEGER")){
                c.setType("Integer");
            } else if (dbType.equalsIgnoreCase("INTEGER UNSIGNED")){
                c.setType("Integer");
            } else if (dbType.equalsIgnoreCase("INT")){
                c.setType("Integer");
            } else if (dbType.equalsIgnoreCase("INT UNSIGNED")){
                c.setType("Integer");
            } else if (dbType.equalsIgnoreCase("NUMERIC")){
                c.setType("Double");
            } else if (dbType.equalsIgnoreCase("REAL")){
                c.setType("Double");
            } else if (dbType.equalsIgnoreCase("DOUBLE")){
                c.setType("Double");
            } else if (dbType.equalsIgnoreCase("DECIMAL")){
                c.setType("java.math.BigDecimal");
            } else if (dbType.equalsIgnoreCase("BIGINT")){
                c.setType("Long");
            } else if (dbType.equalsIgnoreCase("BIGINT UNSIGNED")){
                c.setType("Long");
            } else if (dbType.equalsIgnoreCase("DATE")){
                c.setType("java.util.Date");
            } else if (dbType.equalsIgnoreCase("TIME")){
                c.setType("java.util.Date");
            } else if (dbType.equalsIgnoreCase("DATETIME")){
                c.setType("java.util.Date");
            } else if (dbType.equalsIgnoreCase("TIMESTAMP")){
                c.setType("java.util.Date");
            } else if (dbType.equalsIgnoreCase("BIT")){
                c.setType("Boolean");
            } else {
                String type = properties.getProperty(dbType);
                c.setType(type == null ? "String" : type);
            }
            c.setDbType(dbType);

            c.setLength(rs.getInt("COLUMN_SIZE"));
            c.setDecimalDigits(rs.getInt("DECIMAL_DIGITS"));
            c.setNullable(rs.getBoolean("NULLABLE"));
            columns.add(c);
            colNameAndMap.put(name,c);
        }

        List<Column> pkColumns = new ArrayList<Column>();
        Map<String,String> pkColMap = new HashMap<>();
        ResultSet pkrs = dmd.getPrimaryKeys(catalog, schema, tableName);
        while (pkrs.next()) {
            String name = pkrs.getString("COLUMN_NAME");
            if (!pkColMap.containsKey(name)) {
                Column c = new Column();
                c.setName(CamelCaseUtils.toCamelCase(name));
                c.setDbName(name);
                pkColumns.add(c);
                pkColMap.put(name,name);
            }

        }

        connection.close();

        Table t = new Table();

        String prefiex = properties.getProperty("tableRemovePrefixes");
        String name = tableName;
        if (prefiex != null && !"".equals(prefiex)) {
            name = tableName.split(prefiex)[0];
        }
        t.setName(CamelCaseUtils.toCamelCase(name));
        t.setDbName(tableName);
        t.setColumns(columns);
        //TODO // FIXME: 2020/11/16 0016 这里是BUG,临时解决,后续需要解决
        if (pkColumns.size() > 0) {
            t.setPkColumn(colNameAndMap.get(pkColMap.get(pkColumns.get(0).getDbName())));
        } else {
            t.setPkColumn(columns.get(0));
            pkColumns.add(columns.get(0));
        }

        t.setPkColumns(pkColumns);

        
        return t;
    }

    /**
     * <p>Discription:[生成映射文件和实体类]</p>
     * @param tableName       要声称映射文件和实体类的表名称
     * @param tableDescAndCat 表描述
     * @throws Exception
     */
    public void gen(String tableName, String tableDescAndCat, String id, String modelId) throws Exception {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_21);

        String outRoot = properties.getProperty("outRoot");

        //当输出地址为null时，文件放到桌面
        if (StringUtils.isBlank(outRoot)) {
            File desktopDir = FileSystemView.getFileSystemView() .getHomeDirectory();
            outRoot = desktopDir.getAbsolutePath() + "/Desktop/GeneratorCodeDemo";
        }

        String basePackage = properties.getProperty("basePackage");
        //获取当前日期
        SimpleDateFormat sm_date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sm_year = new SimpleDateFormat("yyyy年");

        //将首字母转为大写
        StringBuffer buffer = new StringBuffer();
        String namePart1 = modelId.substring(0, 1).toUpperCase();
        String namePart2 = modelId.substring(1);
        buffer.append(namePart1 + namePart2);

        System.out.println(buffer);

        Map<String, Object> root = new HashMap<String, Object>();
        Table t = this.parseTable(tableName);
        t.setTableDesc(tableDescAndCat.split("_")[0]);
        root.put("table", t);
        root.put("tableName",t.getDbName());
        /**首字母大写*/
        root.put("ClassName", t.getNameUpper());
        /**首字母小写*/
        root.put("className", t.getName());
        root.put("pkColumn", t.getPkColumn());
        root.put("modelId", modelId);
        root.put("modelIdFirstUpper", buffer);
        root.put("package", basePackage);
        root.put("date", sm_date.format(new Date()));
        root.put("year", sm_year.format(new Date()));
        root.put("functionName", t.getTableDesc());

        root.put("author", "Gavin Lee");

        String templateDir = this.getClass().getClassLoader().getResource("templates").getPath();

        File tdf = new File(templateDir);
        List<File> files = FileHelper.findAllFile(tdf);

        for (File f : files) {
            String parentDir = "";
            if (f.getParentFile().compareTo(tdf) != 0) {
                parentDir = f.getParent().split("templates")[1];
            }
            cfg.setClassForTemplateLoading(this.getClass(), "/templates" + parentDir);

            Template template = cfg.getTemplate(f.getName());
            template.setEncoding("UTF-8");
            String parentFileDir = FileHelper.genFileDir(parentDir, root);
            parentFileDir = parentFileDir.replace(".", "/");
            String file = FileHelper.genFileDir(f.getName(), root).replace(".ftl", ".java");
            System.out.println(file);

            File newFile = FileHelper.makeFile(outRoot + parentFileDir + "/" + file);
            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(newFile), "UTF-8"));
            template.process(root, out);
            logger.debug("已生成文件：" + outRoot + parentFileDir + "/" + file);
        }
    }

    public static void main(String[] args) throws Exception {
        long time = System.currentTimeMillis();
        GeneratorCodeMain g = new GeneratorCodeMain();
        Map<String, String> map = new HashMap<>();

        /**
         * 使用阅读
         * 1、可以根据需求修改下面的参数 "author"
         * 2、修改generator配置文件里面的内容
         *      2.1、jdbc.url
         *      2.2、jdbc.driver
         *      2.3、jdbc.username
         *      2.4、jdbc.password
         * 3、如果主键不是Integer、Long，需要把Mapper.xml的insert${ClassName}的keyProperty="${pkColumn.type}"属性去掉。
         *
         */
        map.put("data_count_test_case", "数据增量校验用例表");
        map.put("data_count_test_report", "数据量校验结果表");


        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> e = it.next();
            //设置数据库主键字段
            g.gen(e.getKey(), e.getValue(), "id", "id");
        }
        System.out.println("-------------------模版文件生成完毕，时间：" + (System.currentTimeMillis() - time) + "毫秒 ----------------!!!");
    }
}
