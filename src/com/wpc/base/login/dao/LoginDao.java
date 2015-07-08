package com.wpc.base.login.dao;

import com.wpc.base.dao.BaseDao;
import com.wpc.base.entity.User;
import com.wpc.base.login.model.LoginSQLModel;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wupicheng
 * Date: 15-7-8
 * Time: 上午8:22
 * To change this template use File | Settings | File Templates.
 */
public class LoginDao {
    BaseDao baseDao=new BaseDao();
    LoginSQLModel loginSQLModel=new LoginSQLModel();

    public List findUser(User user,Connection connection) throws IllegalAccessException, SQLException, InstantiationException {
        return baseDao.query(loginSQLModel.LoginSQLModel(user),new User(),connection);
    }


}
