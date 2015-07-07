package com.wpc.base.db;

import java.sql.*;

/**
 * Created with IntelliJ IDEA.
 * User: wupicheng
 * Date: 15-3-10
 * Time: 上午9:29
 * To change this template use File | Settings | File Templates.
 */
public class DBManager {
    static String driverName = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/stu2";
    static String user = "root";
    static String pwd = "root";

    static {
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(url, user, pwd);

    }

    public static void main(String[] args) throws SQLException {
        Connection connection = getConnection();
        System.out.println(connection);
        connection.close();
    }
     public static  void closeResourse(ResultSet resultSet,PreparedStatement statement,Connection connection){
          if(resultSet!=null){
              try {
                  resultSet.close();
              } catch (SQLException e) {
                  e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
              }   finally {
                  if(statement!=null){
                      try {
                          statement.close();
                      } catch (SQLException e) {
                          e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                      }   finally {
                          if (connection!=null){
                              try {
                                  connection.close();
                              } catch (SQLException e) {
                                  e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                              }
                          }
                      }
                  }
              }
          }
     }
}