package www.zlybl.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("*.do")
public class MyJspServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String path = req.getRequestURI();
        System.out.println(path);
        String root = req.getContextPath();
        System.out.println(root);
        path = path.substring(root.length(), path.length() - 3);
        System.out.println(path);
        req.getRequestDispatcher("/WEB-INF/jsp/" + path + ".jsp").forward(req, resp);

    }

}
