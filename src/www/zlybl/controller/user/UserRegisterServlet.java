package www.zlybl.controller.user;

import www.zlybl.model.User;
import www.zlybl.service.UserService;
import www.zlybl.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/user/userRegister")
public class UserRegisterServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        req.setCharacterEncoding("utf-8");
        User user = new User();
        int userId = userService.userGetLastId() + 1;
        user.setUserId((userId));
        user.setUserName(req.getParameter("userName"));
        user.setUserPassword(req.getParameter("userPassword"));
        HttpSession session = req.getSession();
        if (userService.userRegister(user)) {
            //弹框提示注册成功，分配的id
            session.setAttribute("user", user);
            resp.sendRedirect("userRegisterSuccess.do");
        } else {
            resp.sendRedirect("userRegister.do");
        }
    }
}