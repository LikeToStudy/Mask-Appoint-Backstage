package com.dgut.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //特殊的请求放行
/*        String requestURI = request.getRequestURI();
        if (requestURI.equalsIgnoreCase("/loginSubmit")){
            return true;
        }
        else if (requestURI.equalsIgnoreCase("/login.html")){
            return true;
        }
        else if (requestURI.equalsIgnoreCase("/register")){
            return true;
        }*/

        String user = (String) request.getSession().getAttribute("UID");
        if (user != null){
/*            String url = request.getRequestURI();
            System.out.println("true: "+url);*/
            return true;
        }
        else {
/*            String url = request.getRequestURI();
            System.out.println("false: "+url);*/
            request.getRequestDispatcher("/login.html").forward(request,response);
            return false;
        }
    }
}
