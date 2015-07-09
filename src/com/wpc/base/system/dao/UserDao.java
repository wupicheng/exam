package com.wpc.base.system.dao;

import com.wpc.base.dao.BaseDao;
import com.wpc.base.entity.User;
import com.wpc.base.system.model.UserSQLModel;
import com.wpc.base.util.PageObject;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wupicheng
 * Date: 15-7-8
 * Time: 下午5:05
 * To change this template use File | Settings | File Templates.
 */
public class UserDao {
    BaseDao baseDao = new BaseDao();
    UserSQLModel userSQLModel = new UserSQLModel();

    public List getAllUserDao(Connection connection,PageObject pageObject) throws SQLException {

      //  return baseDao.query(userSQLModel.queryAllUserSQLModel(), connection);
        return baseDao.query(userSQLModel.queryPageUserSQLModel(pageObject), connection);

    }

    public boolean deleteUserByIdDao(Connection connection, String userid) throws SQLException {

        return baseDao.baseCUD(connection, userSQLModel.deleteUserSQLModel(userid));

    }

    public int countAllUserDao(Connection connection) throws SQLException {
        //总记录数
        int count = 0;
        List counts = baseDao.query(userSQLModel.queryCountUserSQLModel(), connection);
        if (counts.size() > 0) {
            Long count_num = (Long) ((HashMap) counts.get(0)).get("count");
            count = count_num.intValue();
        }
        return count;
    }
}