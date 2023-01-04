package www.zlybl.controller.user;

import www.zlybl.model.User;
import www.zlybl.service.UserService;
import www.zlybl.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "ModUserInfoServlet", value = "/user/modUserInfo")
public class ModUserInfoServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        String sid = String.valueOf(user.getUserId());
        User u = userService.findUserById(sid);
        req.setAttribute("user",u);
        req.getRequestDispatcher("perInfoManagement.do").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        req.setCharacterEncoding("utf-8");
        user.setUserId(Integer.parseInt(req.getParameter("userId")));
        user.setUserName(req.getParameter("userName"));
        user.setUserPassword(req.getParameter("userPassword"));



        //调用相应的业务逻辑方法执行修改用户的操作,并根据结果跳转到登录界面
        if(userService.modUser(user)){
            //修改成功，重新登陆
            resp.sendRedirect("userLogout");
//            req.getRequestDispatcher("userLogout").forward(req,resp);
        }else {
            //修改失败
            resp.sendRedirect("perInfoManagement?id="+user.getUserId());
        }




    }
}
