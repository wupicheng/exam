package com.wpc.base.login.action;

import com.wpc.base.constant.BaseConstant;
import com.wpc.base.db.DBManager;
import com.wpc.base.entity.User;
import com.wpc.base.login.dao.LoginDao;
import com.wpc.base.login.dao.MenuDao;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wupicheng
 * Date: 15-7-8
 * Time: 上午7:59
 * To change this template use File | Settings | File Templates.
 */
public class LoginAction implements ServletRequestAware {
   User user=new User();
   HttpServletRequest request;
   HttpSession session;
   LoginDao loginDao=new LoginDao();
   public String login(){
       Connection connection= null;
       try {
           connection = DBManager.getConnection();
           List users=  loginDao.findUser(user,connection);
           if(users.size()>0){
             session=request.getSession();
             User user1= (User) users.get(0);
             MenuDao menuDao=new MenuDao();
              List menus= menuDao.getAllMenuDao(connection,user1);
             session.setAttribute(BaseConstant.SESSION_LOGIN_MENU,menus);
             session.setAttribute(BaseConstant.SESSION_LOGIN_USER,user1);
             session.setAttribute("content_div","/user/blank.jsp");
             return "loginsuccess";
           }
       } catch (SQLException e) {
           e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
       } catch (InstantiationException e) {
           e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
       } catch (IllegalAccessException e) {
           e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
       }
        return "sign-in";

   }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
         this.request=httpServletRequest;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
