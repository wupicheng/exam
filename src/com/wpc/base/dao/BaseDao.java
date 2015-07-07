package com.wpc.base.dao;




import com.wpc.base.model.SQLModel;
import com.wpc.base.util.RecordMappingToMap;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wupicheng
 * Date: 15-3-25
 * Time: 上午9:41
 * To change this template use File | Settings | File Templates.
 */
public class BaseDao {

    /**
     * base  通用增删改数据库操作
     * @param sqlModel
     * @throws java.sql.SQLException
     */
    public boolean baseCUD(Connection connection,SQLModel sqlModel) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement(sqlModel.getSqlstr());
        for(int i=0;i<sqlModel.getParameters().size();i++){
            preparedStatement.setObject(i+1, sqlModel.getParameters().get(i));
        }
      return   preparedStatement.execute();
    }

    /**
     *
     * @param connection
     * @param sqlModel
     * @throws java.sql.SQLException
     */
    public List query(SQLModel sqlModel, Object o,Connection connection) throws SQLException, IllegalAccessException, InstantiationException {

        PreparedStatement preparedStatement = connection.prepareStatement(sqlModel.getSqlstr());
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < sqlModel.getParameters().size(); i++) {
            preparedStatement.setObject(i + 1, sqlModel.getParameters().get(i));
        }
        Class claze = o.getClass();
        Field[] fileds = claze.getDeclaredFields();
        ResultSet resultSet = preparedStatement.executeQuery();
        int columncount=   resultSet.getMetaData().getColumnCount();
        while (resultSet.next()) {
            Object o2 = claze.newInstance();
            for (Field field : fileds) {
                field.setAccessible(true);
                for(int i=0;i<columncount;i++){
                    String columnname=  resultSet.getMetaData().getColumnName(i+1);
                    if (columnname.equals(field.getName())){
                        field.set(o2, resultSet.getObject(field.getName()));
                    }else {
                        continue;
                    }
                }
            }
            System.out.println(o2);

            arrayList.add(o2);
        }

        return arrayList;
    }

    /**
     * 此方法返回任意结果集的 List list里面每条记录都是一个map
     *
     * @param sqlModel
     * @param con
     * @return
     * @throws java.sql.SQLException
     */
    public  List query(SQLModel sqlModel,Connection con) throws SQLException {
        RecordMappingToMap recordMappingToMap=new RecordMappingToMap();
        return  recordMappingToMap.query(sqlModel,con);

    }
}
