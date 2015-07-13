package com.wpc.base.login.model;

import com.wpc.base.entity.User;
import com.wpc.base.model.SQLModel;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: wupicheng
 * Date: 15-7-8
 * Time: 上午8:32
 * To change this template use File | Settings | File Templates.
 */
public class MenuSQLModel {
    public SQLModel firstLevelMenuSQLModel(User user){
        SQLModel sqlModel=new SQLModel();
        ArrayList parameters=new ArrayList();
        String sqlStr="";
           //超级用户拥有所有菜单功能
          if("admin".equals(user.getUser_name())){
               sqlStr=  " SELECT * FROM" +
                   //    " EXAM_USER U,\n" +
                     // " EXAM_ROLE R,\n" +
                      " EXAM_NODE N \n" +
                    //  " EXAM_USER_ROLE UR,\n" +
                    //  " EXAM_ROLE_NODE RN \n" +
                      " WHERE " +
                    //   "UR.ROLE_ID=R.ROLE_ID \n" +
                     // " AND   UR.USER_ID=U.USER_ID \n" +
                     // " AND   RN.NODE_ID=N.NODE_ID \n" +
                     // " AND   RN.ROLE_ID=R.ROLE_ID \n" +
                      "    N.NODE_LEVEL='1' \n" +
                      " AND   N.NODE_ENABLE='1' ";
           //         " AND   U.USER_ID=? ";
          } else{
              sqlStr= " SELECT * FROM EXAM_USER U,\n" +
                      " EXAM_ROLE R,\n" +
                      " EXAM_NODE N,\n" +
                      " EXAM_USER_ROLE UR,\n" +
                      " EXAM_ROLE_NODE RN \n" +
                      " WHERE UR.ROLE_ID=R.ROLE_ID \n" +
                      " AND   UR.USER_ID=U.USER_ID \n" +
                      " AND   RN.NODE_ID=N.NODE_ID \n" +
                      " AND   RN.ROLE_ID=R.ROLE_ID \n" +
                      " AND   N.NODE_LEVEL='1' \n" +
                      " AND   N.NODE_ENABLE='1' " +
                      " AND   U.USER_ID=? ";
              parameters.add(user.getUser_id());

          }

        sqlModel.setSqlstr(sqlStr);
        sqlModel.setParameters(parameters);

        return sqlModel;
    }
    public SQLModel secondLevelMenuSQLModel(String  firstLevelId){
        SQLModel sqlModel=new SQLModel();
        ArrayList parameters=new ArrayList();

        String sqlStr=  " SELECT * FROM EXAM_NODE \n" +
                        " WHERE NODE_PARENT_ID= ? \n" +
                        " AND NODE_ENABLE='1' ";

        sqlModel.setSqlstr(sqlStr);
        parameters.add(firstLevelId);

        sqlModel.setParameters(parameters);


        return sqlModel;
    }
}
