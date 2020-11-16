package com.codergavin.generatorcode.common;

import java.util.List;
/**
 * @author Gavin Lee
 * @version 1.0
 * @date 2020-11-16 10:14
 */
public class Table {

    private String name;
    private String dbName;
    private String tableDesc;
    /**主键*/
    private Column pkColumn;
    private List<Column> columns;
    private List<Column> pkColumns;

    public String getName() {
        return name;
    }

    public String getNameUpper() {
        return name.replaceFirst(name.substring(0, 1), name.substring(0, 1).toUpperCase());
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getTableDesc() {
        return tableDesc;
    }

    public void setTableDesc(String tableDesc) {
        this.tableDesc = tableDesc;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }

    public List<Column> getPkColumns() {
        return pkColumns;
    }

    public void setPkColumns(List<Column> pkColumns) {
        this.pkColumns = pkColumns;
    }

    public Column getPkColumn() {
        return pkColumn;
    }

    public void setPkColumn(Column pkColumn) {
        this.pkColumn = pkColumn;
    }
}
