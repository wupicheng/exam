package com.wpc.base.login.dao;

import com.wpc.base.dao.BaseDao;
import com.wpc.base.entity.User;
import com.wpc.base.login.model.MenuSQLModel;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: wupicheng
 * Date: 15-7-8
 * Time: 上午8:31
 * To change this template use File | Settings | File Templates.
 */
public class MenuDao {
    BaseDao baseDao=new BaseDao();
    MenuSQLModel menuSQLModel=new MenuSQLModel();

    /**
     * 拼装菜单
     *
     * @param connection
     * @param user
     * @return
     * @throws SQLException
     */
    public List getAllMenuDao(Connection connection,User user) throws SQLException {
        MenuDao menuDao=new MenuDao();
        List menus=new ArrayList();
        List firstMenus= menuDao.getFirstLevelMenuDao(connection,user);
        for(Object obj:firstMenus){
            Map menuMap=new HashMap();
            Map firstMenuMap= (Map) obj;
            String firstLevelMenuId=  firstMenuMap.get("node_id").toString();

            menuMap.put("menu1",firstMenuMap);

            List secondLevelMenus= menuDao.getSecondLevelMenuDao(firstLevelMenuId,connection);
            menuMap.put("menu2s",secondLevelMenus);
            menus.add(menuMap);
        }
        return  menus;
    }

    public List getFirstLevelMenuDao(Connection connection,User user) throws SQLException {
        return  baseDao.query(menuSQLModel.firstLevelMenuSQLModel(user),connection);
    }
    public List getSecondLevelMenuDao(String firstLevelMenuId,Connection connection) throws SQLException {
        return  baseDao.query(menuSQLModel.secondLevelMenuSQLModel(firstLevelMenuId),connection);
    }
}
