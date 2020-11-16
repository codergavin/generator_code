package com.codergavin.generatorcode.common;
/**
 * @author Gavin Lee
 * @version 1.0
 * @date 2020-11-16 10:14
 */
public class Column {

    /** Java的Column名 */
    private String name;
    /** 数据库的Column名 */
    private String dbName;
    /** 数据库的Column中文名*/
    private String label;
    /** 数据库的Column列的Java类型*/
    private String type;
    /** 数据库的Column列的数据库类型类型*/
    private String dbType;
    private Integer length;
    private Boolean nullable;
    private Integer decimalDigits;


    public String getName() {
        return name;
    }

    public String getNameUpper() {
        return name.replaceFirst(name.substring(0, 1), name.substring(0, 1).toUpperCase());
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Boolean getNullable() {
        return nullable;
    }

    public void setNullable(Boolean nullable) {
        this.nullable = nullable;
    }

    public Integer getDecimalDigits() {
        return decimalDigits;
    }

    public void setDecimalDigits(Integer decimalDigits) {
        this.decimalDigits = decimalDigits;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getDbType() {
        return dbType;
    }

    public void setDbType(String dbType) {
        this.dbType = dbType;
    }
}
