package www.zlybl.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName = "managerLoginFilter",urlPatterns = {"/manager/*"})
public class ManagerLoginFlitter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        System.out.println(req.getSession().getAttribute("manager"));

        if (req.getSession().getAttribute("manager") == null) {
            System.out.println("运行到这里");
            System.out.println(req.getContextPath());
            resp.sendRedirect(req.getContextPath()+"/index.html");
            return;
        }
        chain.doFilter(request, response);//给其他过滤器放行
    }

}