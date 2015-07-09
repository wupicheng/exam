package com.wpc.base.system.model;

import com.wpc.base.entity.User;
import com.wpc.base.model.SQLModel;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: wupicheng
 * Date: 15-7-8
 * Time: 下午5:05
 * To change this template use File | Settings | File Templates.
 */
public class UserSQLModel {

    public SQLModel queryAllUserSQLModel(){
        SQLModel sqlModel=new SQLModel();
        ArrayList parameters=new ArrayList();

        String sqlStr= " select * from exam_user ";

        sqlModel.setSqlstr(sqlStr);
        sqlModel.setParameters(parameters);

        return sqlModel;
    }

    public SQLModel deleteUserSQLModel(String user_id){
        SQLModel sqlModel=new SQLModel();
        ArrayList parameters=new ArrayList();

        String sqlStr= " delete from exam_user where user_id=? ";
        parameters.add(user_id);

        sqlModel.setSqlstr(sqlStr);
        sqlModel.setParameters(parameters);

        return sqlModel;
    }
}
