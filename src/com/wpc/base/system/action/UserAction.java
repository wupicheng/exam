package com.wpc.base.system.action;

import com.wpc.base.db.DBManager;
import com.wpc.base.entity.User;
import com.wpc.base.system.dao.UserDao;
import com.wpc.base.util.PageObject;
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
public class UserAction implements ServletRequestAware {
    HttpServletRequest request;
    HttpSession session;
    User user = new User();
    UserDao userDao = new UserDao();

    /**
     * 分页预处理
     *
     * @return
     */
    public PageObject prePageObject() {
        int currentpagenum = 0;
        int everypagenum = 0;
        String current_page_num = request.getParameter("currentPageNum");
        String every_page_num = request.getParameter("everyPageNum");
        if (current_page_num == null||current_page_num.equals("")) {
            currentpagenum = 1;
        } else {
            currentpagenum = Integer.parseInt(current_page_num);
        }
        if (every_page_num == null) {
            everypagenum = 5;
        } else {
            everypagenum = Integer.parseInt(every_page_num);
        }
        PageObject pageObject = new PageObject();
        pageObject.setCurrentPageNum(currentpagenum);
        pageObject.setEveryPageNum(everypagenum);
        return pageObject;
    }

    public String queryAllUser() {
        Connection connection = null;
        session = request.getSession();
       PageObject pageObjectPre=  prePageObject();
        try {
            connection = DBManager.getConnection();

            PageObject pageObject = new PageObject(userDao.countAllUserDao(connection), pageObjectPre.getEveryPageNum(), pageObjectPre.getCurrentPageNum());
            List users = userDao.getAllUserDao(connection, pageObject);
            request.setAttribute("users", users);
            request.setAttribute("pageObject", pageObject);
            session.setAttribute("content_div", "/user/users.jsp");
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally {
            DBManager.closeResourse(null, null, connection);
        }

        return "queryall";
    }

    public String deleteUser() {
        System.out.println("delete");
        Connection connection = null;
        String user_id = request.getParameter("user_id");
        session = request.getSession();
        PageObject pageObjectPre= prePageObject();
        try {
            connection = DBManager.getConnection();
            if (user_id != null) {
                userDao.deleteUserByIdDao(connection, user_id);
            }
            PageObject pageObject = new PageObject(userDao.countAllUserDao(connection), pageObjectPre.getEveryPageNum(), pageObjectPre.getCurrentPageNum());

            List users = userDao.getAllUserDao(connection, pageObject);
            request.setAttribute("users", users);
            session.setAttribute("content_div", "/user/users.jsp");
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally {
            DBManager.closeResourse(null, null, connection);
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
        this.request = httpServletRequest;
    }
}
