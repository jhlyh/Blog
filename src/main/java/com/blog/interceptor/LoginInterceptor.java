package com.blog.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("user");
        if (user == null) {
            request.setAttribute("message", "请先登录!");
            //request.getRequestDispatcher("/adminlogin").forward(request,response);
            response.sendRedirect("/adminlogin");
            return false;
        }
        return true;
    }

}
