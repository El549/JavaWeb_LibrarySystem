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

@WebServlet(name = "DelUserServlet", value = "/user/delUser")
public class DelUserServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = (User) request.getSession().getAttribute("user");
        String sid = String.valueOf(user.getUserId());

        //调用相应的业务逻辑方法执行添加用户的操作,并根据结果跳转到相应界面

        //删除成功
        if(userService.delUser(sid)){
            //删除成功，重新登陆
            response.sendRedirect("userLogout");
        }else{
            //删除失败
            response.sendRedirect("modUserInfo");
        }

    }
}
