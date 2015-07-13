package com.wpc.base.system.action;

import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * User: wupic
 * Date: 15-7-13
 * Time: 下午2:58
 * To change this template use File | Settings | File Templates.
 */
public class MenuAction implements ServletRequestAware {
    HttpServletRequest request;
    HttpSession session;
    public String queryAllMenu(){
       session=  request.getSession();

        session.setAttribute("content_div", "/user/menus.jsp");
        return "index";
    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
         this.request=httpServletRequest;
    }
}
