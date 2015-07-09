package com.wpc.base.system.action;

import com.wpc.base.db.DBManager;
import com.wpc.base.entity.User;
import com.wpc.base.system.dao.UserDao;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.util.ServletContextAware;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wupicheng
 * Date: 15-7-8
 * Time: 下午5:01
 * To change this template use File | Settings | File Templates.
 */
public class UserAction implements ServletRequestAware{
    HttpServletRequest request;
    HttpSession session;
    User user= new User();
    UserDao userDao=new UserDao();
    public String queryAllUser(){
        Connection connection= null;
        session=request.getSession();
        try {
            connection = DBManager.getConnection();
            List users=  userDao.getAllUserDao(connection);
            request.setAttribute("users",users);
            session.setAttribute("content_div","/user/users.jsp");
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally {
            DBManager.closeResourse(null,null,connection);
        }

        return "queryall";
    }

    public String deleteUser(){
        System.out.println("delete");
        Connection connection= null;
        String user_id=  request.getParameter("user_id");
        session=request.getSession();
        try {
            connection = DBManager.getConnection();
            if(user_id!=null){
                userDao.deleteUserByIdDao(connection,user_id);
            }
            List users=  userDao.getAllUserDao(connection);
            request.setAttribute("users",users);
            session.setAttribute("content_div","/user/users.jsp");
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally {
            DBManager.closeResourse(null,null,connection);
        }
        return "queryall";
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }



    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
          this.request=httpServletRequest;
    }
}
