package www.zlybl.controller;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "userLoginFilter",urlPatterns = {"/user/*"})
public class UserLoginFlitter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        System.out.println(req.getSession().getAttribute("user"));

        if (req.getSession().getAttribute("user") == null) {
            System.out.println("运行到这里");
            System.out.println(req.getContextPath());
            resp.sendRedirect(req.getContextPath()+"/index.html");
            return;
        }
        chain.doFilter(request, response);//给其他过滤器放行
    }

}