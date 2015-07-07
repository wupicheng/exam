package com.wpc.base.util;



import com.wpc.base.db.DBManager;
import com.wpc.base.model.SQLModel;

import java.math.BigDecimal;
import java.sql.*;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: wupicheng
 * Date: 15-5-7
 * Time: 下午5:00
 * To change this template use File | Settings | File Templates.
 */
public class RecordMappingToMap {

    PreparedStatement stmt = null;
    ResultSet rs = null;
    ResultSetMetaData rsmd = null;
    /**
     * 将ResultSet结果集中的记录映射到Map对象中.
     *
     * @param fieldClassName 是JDBC API中的类型名称,
     * @param fieldName      是字段名，
     * @param rs             是一个ResultSet查询结果集,
     * @param fieldValue     Map对象,用于存贮一条记录.
     * @throws
     */
    private void _recordMappingToMap(String fieldClassName, String fieldName, ResultSet rs, Map fieldValue) throws SQLException, SQLException {

        fieldName = fieldName.toLowerCase();
        //优先规则：常用类型靠前
        if (fieldClassName.equals("java.lang.String")) {
            String s = rs.getString(fieldName);
            if (rs.wasNull()) {
                fieldValue.put(fieldName, null);
            } else {
                fieldValue.put(fieldName, s);
            }
        } else if (fieldClassName.equals("java.lang.Integer")) {
            int s = rs.getInt(fieldName);
            if (rs.wasNull()) {
                fieldValue.put(fieldName, null);
            } else {
                fieldValue.put(fieldName, s);//早期jdk需要包装，jdk1.5后不需要包装
            }
        } else if (fieldClassName.equals("java.lang.Long")) {
            long s = rs.getLong(fieldName);
            if (rs.wasNull()) {
                fieldValue.put(fieldName, null);
            } else {
                fieldValue.put(fieldName, s);
            }
        } else if (fieldClassName.equals("java.lang.Boolean")) {
            boolean s = rs.getBoolean(fieldName);
            if (rs.wasNull()) {
                fieldValue.put(fieldName, null);
            } else {
                fieldValue.put(fieldName, s);
            }
        } else if (fieldClassName.equals("java.lang.Short")) {
            short s = rs.getShort(fieldName);
            if (rs.wasNull()) {
                fieldValue.put(fieldName, null);
            } else {
                fieldValue.put(fieldName, s);
            }
        } else if (fieldClassName.equals("java.lang.Float")) {
            float s = rs.getFloat(fieldName);
            if (rs.wasNull()) {
                fieldValue.put(fieldName, null);
            } else {
                fieldValue.put(fieldName, s);
            }
        } else if (fieldClassName.equals("java.lang.Double")) {
            double s = rs.getDouble(fieldName);
            if (rs.wasNull()) {
                fieldValue.put(fieldName, null);
            } else {
                fieldValue.put(fieldName, s);
            }
        } else if (fieldClassName.equals("java.sql.Timestamp")) {
            Timestamp s = rs.getTimestamp(fieldName);
            if (rs.wasNull()) {
                fieldValue.put(fieldName, null);
            } else {
                fieldValue.put(fieldName, s);
            }
        } else if (fieldClassName.equals("java.sql.Date") || fieldClassName.equals("java.util.Date")) {
            java.util.Date s = rs.getDate(fieldName);
            if (rs.wasNull()) {
                fieldValue.put(fieldName, null);
            } else {
                fieldValue.put(fieldName, s);
            }
        } else if (fieldClassName.equals("java.sql.Time")) {
            Time s = rs.getTime(fieldName);
            if (rs.wasNull()) {
                fieldValue.put(fieldName, null);
            } else {
                fieldValue.put(fieldName, s);
            }

        } else if (fieldClassName.equals("java.lang.Byte")) {
            byte s = rs.getByte(fieldName);
            if (rs.wasNull()) {
                fieldValue.put(fieldName, null);
            } else {
                fieldValue.put(fieldName, new Byte(s));
            }
        } else if (fieldClassName.equals("[B") || fieldClassName.equals("byte[]")) {
            //byte[]出现在SQL Server中
            byte[] s = rs.getBytes(fieldName);
            if (rs.wasNull()) {
                fieldValue.put(fieldName, null);
            } else {
                fieldValue.put(fieldName, s);
            }
        } else if (fieldClassName.equals("java.math.BigDecimal")) {
            BigDecimal s = rs.getBigDecimal(fieldName);
            if (rs.wasNull()) {
                fieldValue.put(fieldName, null);
            } else {
                fieldValue.put(fieldName, s);
            }
        } else if (fieldClassName.equals("java.lang.Object") || fieldClassName.equals("oracle.sql.STRUCT")) {
            Object s = rs.getObject(fieldName);
            if (rs.wasNull()) {
                fieldValue.put(fieldName, null);
            } else {
                fieldValue.put(fieldName, s);
            }
        } else if (fieldClassName.equals("java.sql.Array")
                || fieldClassName.equals("oracle.sql.ARRAY")) {
            Array s = rs.getArray(fieldName);
            if (rs.wasNull()) {
                fieldValue.put(fieldName, null);
            } else {
                fieldValue.put(fieldName, s);
            }
        } else if (fieldClassName.equals("java.sql.Clob")) {
            Clob s = rs.getClob(fieldName);
            if (rs.wasNull()) {
                fieldValue.put(fieldName, null);
            } else {
                fieldValue.put(fieldName, s);
            }
        } else if (fieldClassName.equals("java.sql.Blob")) {
            Blob s = rs.getBlob(fieldName);
            if (rs.wasNull()) {
                fieldValue.put(fieldName, null);
            } else {
                fieldValue.put(fieldName, s);
            }
        } else {//对于其它任何未知类型的处理
            Object s = rs.getObject(fieldName);
            if (rs.wasNull()) {
                fieldValue.put(fieldName, null);
            } else {
                fieldValue.put(fieldName, s);
            }
        }
    }


    /**
     * 通过一个可滚动结果集获取指定起始位置、指定长度的子结果集,不论isScrollSenstive真否，结果集均设定为只读.
     *
     * @param sqlquery         是标准查询语句,可以是任意复杂的多表查询语句,但必须是受JDBC API支持的标准查询语句
     * @param position         记录起始位置,注意表中记录是从1开始;越界则返回0条记录
     * @param length           是指定记录长度,若不够长度,则含position后的全部记录
     * @param isScrollSenstive 指定结果集是否敏感
     * @return 获取查询结果集转化成List对象, 每一条记录映射成一个HashMap对象,
     *         这个HashMap对象的键名是表中的字段名，或是字段的别名，键值为字段值，键值的类型是字段所对应的JDBC
     *         API的Java类。若无记录则返回零长度List对象。
     * @throws java.sql.SQLException
     */

    public List query(String sqlquery, int position, int length, boolean isScrollSenstive, Connection con) throws SQLException {
       Statement stmt = null;
        List records = new ArrayList();
        try {
            DatabaseMetaData dmd = con.getMetaData();
            if (dmd.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)
                    || dmd.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)) {
                if (isScrollSenstive) {
                    stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                            ResultSet.CONCUR_READ_ONLY);
                } else {
                    stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_READ_ONLY);
                }
            }
            rs = stmt.executeQuery(sqlquery);
            rsmd = rs.getMetaData();
            int fieldCount = rsmd.getColumnCount();
            rs.last();
            int x = rs.getRow();
            if (position < 1 || position > x) {
                return records; //起始位置越界,则返回0条记录;
            }
            if (position + length > x) {
                length = x - (position - 1); //若起始位置后的记录数小于length,则取起始位置后的全部记录;
            }
            Map valueMap = null;
            if (rs.absolute(position)) {
                for (int k = position; k < position + length; k++) {
                    valueMap = new HashMap();

                    for (int i = 1; i <= fieldCount; i++) {
                        String fieldClassName = rsmd.getColumnClassName(i);
                        String fieldName = rsmd.getColumnName(i);
                        this._recordMappingToMap(fieldClassName, fieldName, rs, valueMap);
                    }
                    records.add(valueMap);
                    if (!rs.next()) {
                        break;
                    }
                }
            }
        } finally {
            stmt.close();
        }
        return records;
    }

    /**
     * 查询方法
     *
     * @param sqlModel 是标准查询语句,可以是任意复杂的多表查询语句,但必须是受JDBC API支持的标准查询语句
     * @param timeout  设定查询时限，单位：秒；timeout=0,则查询不受时间限制
     * @return 将查询结果ResultSet对象转换成List<Map<String,Object>>类型的结果
     * @throws java.sql.SQLException
     */

    public List query(SQLModel sqlModel, int timeout, Connection con) throws SQLException {
        List records = new ArrayList();
        try {
            stmt = con.prepareStatement(sqlModel.getSqlstr());
            for (int i = 0; i < sqlModel.getParameters().size(); i++) {
                stmt.setObject(i + 1, sqlModel.getParameters().get(i));
            }
            if (timeout > 0) {
                stmt.setQueryTimeout(timeout);
            }
            rs = stmt.executeQuery();
            rsmd = rs.getMetaData();
            int fieldCount = rsmd.getColumnCount();
            while (rs.next()) {
                Map valueMap = new LinkedHashMap();
                for (int i = 1; i <= fieldCount; i++) {
                    String fieldClassName = rsmd.getColumnClassName(i);
                    String fieldName = rsmd.getColumnName(i);
                    this._recordMappingToMap(fieldClassName, fieldName, rs, valueMap);
                }
                records.add(valueMap);
            }
            rs.close();
        } finally {
            stmt.close();
        }
        //db.setLastQuerySql(sqlquery);
        return records;
    }

    /**
     * 查询方法
     *
     * @param sqlModel 是标准查询语句,可以是任意复杂的多表查询语句,但必须是受JDBC API支持的标准查询语句
     * @param timeout  设定查询时限，单位：秒；timeout=0,则查询不受时间限制
     * @return 将查询结果ResultSet对象转换成List<Map<String,Object>>类型的结果
     * @throws java.sql.SQLException
     */

    public List query(int timeout, Connection con,SQLModel sqlModel) throws SQLException {
        List records = new ArrayList();
        try {
            stmt = con.prepareStatement(sqlModel.getSqlstr());

            if (timeout > 0) {
                stmt.setQueryTimeout(timeout);
            }
            rs = stmt.executeQuery();
            rsmd = rs.getMetaData();
            int fieldCount = rsmd.getColumnCount();
            while (rs.next()) {
                Map valueMap = new LinkedHashMap();
                for (int i = 1; i <= fieldCount; i++) {
                    String fieldClassName = rsmd.getColumnClassName(i);
                    String fieldName = rsmd.getColumnName(i);
                    this._recordMappingToMap(fieldClassName, fieldName, rs, valueMap);
                }
                records.add(valueMap);
            }
            rs.close();
        } finally {
            stmt.close();
        }
        //db.setLastQuerySql(sqlquery);
        return records;
    }




    /**
     * 查询方法
     *
     * @param sqlModel 是标准查询语句,可以是任意复杂的多表查询语句,但必须是受JDBC API支持的标准查询语句
     * @return 将查询结果ResultSet对象转换成List<Map<String,Object>>类型的结果
     * @throws java.sql.SQLException
     */
    public List query(SQLModel sqlModel, Connection con) throws SQLException {
        return this.query(sqlModel, 0, con);
    }

    public static void main(String[] args) throws SQLException {
        Connection con = DBManager.getConnection();
        RecordMappingToMap recordMappingToMap = new RecordMappingToMap();
        String sqlStr = "select * from stu_user where user_id=? ";
        SQLModel sqlModel=new SQLModel();
        ArrayList parameters=new ArrayList();
        parameters.add("1");
        sqlModel.setSqlstr(sqlStr);
        sqlModel.setParameters(parameters);

        List list = recordMappingToMap.query(sqlModel, con);
        System.out.println(list);
        DBManager.closeResourse(null, null, con);
    }

}
