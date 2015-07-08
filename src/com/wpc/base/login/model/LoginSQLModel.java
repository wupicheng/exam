package com.wpc.base.login.model;

import com.wpc.base.entity.User;
import com.wpc.base.model.SQLModel;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: wupicheng
 * Date: 15-7-8
 * Time: 上午8:23
 * To change this template use File | Settings | File Templates.
 */
public class LoginSQLModel {
    public SQLModel  LoginSQLModel(User user){
        SQLModel sqlModel=new SQLModel();
        ArrayList parameters=new ArrayList();

        String sqlStr= " select * from exam_user " +
                       " where user_name=? and user_password=?";

        sqlModel.setSqlstr(sqlStr);
        sqlModel.setParameters(parameters);
        parameters.add(user.getUser_name());
        parameters.add(user.getUser_password());

        return sqlModel;
    }
}
