package com.wpc.base.system.dao;

import com.wpc.base.dao.BaseDao;
import com.wpc.base.entity.User;
import com.wpc.base.system.model.UserSQLModel;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wupicheng
 * Date: 15-7-8
 * Time: 下午5:05
 * To change this template use File | Settings | File Templates.
 */
public class UserDao {
    BaseDao baseDao=new BaseDao();
    UserSQLModel userSQLModel=new UserSQLModel();

    public List  getAllUserDao(Connection connection) throws SQLException {

        return  baseDao.query(userSQLModel.queryAllUserSQLModel(),connection);

    }
    public boolean deleteUserByIdDao(Connection connection, String userid) throws SQLException {

        return  baseDao.baseCUD(connection,userSQLModel.deleteUserSQLModel(userid));

    }

}