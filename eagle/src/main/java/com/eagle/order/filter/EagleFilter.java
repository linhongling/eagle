package com.eagle.order.filter;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Description
 * @Author hongling.lin
 * @Date 2019/4/15
 */
public class EagleFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String requestURI = request.getRequestURI();
        if (requestURI.contains("web/login")) {
            String account = request.getParameter("account");
            String password = request.getParameter("password");
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(account, password);
            token.setRememberMe(true);
            subject.login(token);
        }
    }

    @Override
    public void destroy() {

    }
}
