package www.zlybl.controller.manager;

import www.zlybl.model.Manager;
import www.zlybl.service.ManagerService;
import www.zlybl.service.impl.ManagerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ManagerLoginServlet", value = "/manager/managerLogin")
public class ManagerLoginServlet extends HttpServlet {

    ManagerService managerService = new ManagerServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String getManagerId = req.getParameter("managerId");
        //判断获取到的Id是否为数字
//        for (int i = getManagerId.length(); --i >= 0; ) {
//            int chr = getManagerId.charAt(i);
//            if (chr < 48 || chr > 57) {
//                //非数字
//                PrintWriter out = resp.getWriter();
//                out.println("<script>alert( 'The ID entered is invalid!');" +
//                        "window.location.href='managerLoginPage'</script>");
//                out.close();
//            }
//        }
        int managerId = Integer.parseInt(getManagerId);
        //判断id是否在合法范围内
        if(managerId <= 0 || managerId >= 999999){
            PrintWriter out = resp.getWriter();
            out.println("<script>alert( 'The ID entered is invalid!');" +
                    "window.location.href='managerLoginPage'</script>");
            out.close();
        }
        String managerPassword = req.getParameter("managerPassword");
        HttpSession session = req.getSession();
        //使用输入的Id和密码进行登录验证，匹配则返回manager
        System.out.println(managerId+managerPassword);
        Manager manager = managerService.managerLogin(managerId, managerPassword);
        if (manager != null) {
            //将manager存入session
            session.setAttribute("manager", manager);
            resp.sendRedirect("managerHome.do");
        } else {
            resp.sendRedirect("managerLogin.do");
        }
    }
}
