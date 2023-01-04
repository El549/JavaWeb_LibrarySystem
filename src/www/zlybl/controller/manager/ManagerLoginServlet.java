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

@WebServlet(name = "ManagerLoginServlet", value = "/manager/managerLogin")
public class ManagerLoginServlet extends HttpServlet {

    ManagerService managerService = new ManagerServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String managerName = req.getParameter("managerName");
        String managerPassword = req.getParameter("managerPassword");
        HttpSession session = req.getSession();

        Manager manager = managerService.managerLogin(managerName, managerPassword);
        System.out.println(manager);
        if (manager != null) {
            session.setAttribute("manager", manager);
            resp.sendRedirect("managerHome.do");
        }
        else {
            resp.sendRedirect("managerLogin.do");
        }
    }
}
