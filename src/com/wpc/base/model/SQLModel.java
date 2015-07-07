package com.wpc.base.model;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: wupicheng
 * Date: 15-5-6
 * Time: 上午11:02
 * To change this template use File | Settings | File Templates.
 */
public class SQLModel {
    /**
     * sqlmodel属性字段
     */
    String sqlstr;
    /**
     * sqlmodel属性字段
     */
    ArrayList parameters=new ArrayList();


    @Override
    public String toString() {
        return "SQLModel{" +
                "sqlstr='" + sqlstr + '\'' +
                ", arrayList=" + parameters +
                '}';
    }

    public String getSqlstr() {
        return sqlstr;
    }

    public void setSqlstr(String sqlstr) {
        this.sqlstr = sqlstr;
    }

    public ArrayList getParameters() {
        return parameters;
    }

    public void setParameters(ArrayList parameters) {
        this.parameters = parameters;
    }
}