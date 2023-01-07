package www.zlybl.controller.manager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ManagerLogoutServlet", value = "/manager/managerLogout")
public class ManagerLogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        让会话对象失效
        HttpSession session = req.getSession();
        session.invalidate();

        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        resp.sendRedirect("../index.html");
        out.close();
    }
}
