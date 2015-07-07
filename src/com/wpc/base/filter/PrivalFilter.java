package com.wpc.base.filter;


import com.wpc.base.constant.BaseConstant;
import com.wpc.base.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: wupicheng
 * Date: 15-5-8
 * Time: 下午3:35
 * To change this template use File | Settings | File Templates.
 */
public class PrivalFilter implements Filter {
    String extesion;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("privalfilter init..");
        extesion= filterConfig.getInitParameter("extesion");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("privalfilter do filter ..");
        HttpServletRequest request= (HttpServletRequest) servletRequest;

       String url= request.getRequestURL().toString();
        System.out.println(url);
       HttpSession session= request.getSession();
       User user= (User) session.getAttribute(BaseConstant.SESSION_LOGIN_USER);
       String urlextesion=   url.substring(url.lastIndexOf(".")+1,url.length());
        if (extesion.contains(urlextesion)){
            filterChain.doFilter(request,servletResponse);
            return;
        }
        if(user!=null){
            System.out.println("filter user is not null...");
            filterChain.doFilter(request,servletResponse);
        }  else {
            request.getRequestDispatcher("/login/sign-in.jsp").forward(request,servletResponse);
        }

    }

    @Override
    public void destroy() {
        System.out.println("privalfilter destroy..");
    }
}
