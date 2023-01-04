package www.zlybl.controller.manager;

import www.zlybl.model.User;
import www.zlybl.service.UserService;
import www.zlybl.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "ResetUserPwdServlet", value = "/manager/resetUserPwd")
public class ResetUserPwdServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接受表单中的数据
        String sid = req.getParameter("id");
        System.out.println(sid);
        //在数据库中查找
        if(userService.resetPassword(sid)){
            //密码重置成功，重新登陆
            //resp.sendRedirect("/userLogOut");
            System.out.println("密码重置成功");
        }else{
            //密码重置失败
            resp.sendRedirect("queryUserById");
        }

    }
}
