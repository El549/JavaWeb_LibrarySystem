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
import java.io.PrintWriter;

@WebServlet(name = "UserLoginServlet", value = "/user/userLogin")
public class UserLoginServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String getUserId = req.getParameter("userId");
        //判断获取到的Id是否为数字
        for (int i = getUserId.length(); --i >= 0; ) {
            int chr = getUserId.charAt(i);
            if (chr < 48 || chr > 57) {
                //非数字
                PrintWriter out = resp.getWriter();
                out.println("<script>alert( 'The ID entered is invalid!');" +
                        "window.location.href='userLoginPage'</script>");
                out.close();
            }
        }
        int userId = Integer.parseInt(getUserId);
        //判断id是否在合法范围内
        if(userId <= 0 || userId >= 999999){
            PrintWriter out = resp.getWriter();
            out.println("<script>alert( 'The ID entered is invalid!');" +
                    "window.location.href='userLoginPage'</script>");
            out.close();
        }
        String userPassword = req.getParameter("userPassword");
        HttpSession session = req.getSession();
        //使用输入的Id和密码进行登录验证，匹配则返回user
        User user = userService.userLogin(userId, userPassword);
        if (user != null) {
            //将user存入session
            session.setAttribute("user", user);
//            req.getRequestDispatcher("/user/userHome.do").forward(req,resp);
            resp.sendRedirect("userHome.do");
        } else {
            resp.sendRedirect("userLogin.do");
        }
    }
}
