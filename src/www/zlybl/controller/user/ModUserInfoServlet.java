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
        //String sid = req.getParameter("userId");

        //代替收到userId
        String sid = String.valueOf(4);
        //System.out.println(sid);

        User user = userService.findUserById(sid);
        req.setAttribute("user",user);
        req.getRequestDispatcher("perInfoManagement.do").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        req.setCharacterEncoding("utf-8");
//        user.setUserId(Integer.parseInt(req.getParameter("userId")));
//        user.setUserName(req.getParameter("userName"));
//        user.setUserPassword(req.getParameter("userPassword"));

        //测试
        user.setUserId(Integer.parseInt(String.valueOf(4)));
        user.setUserName("Wangwu");
        user.setUserPassword("123456");

        //调用相应的业务逻辑方法执行修改用户的操作,并根据结果跳转到登录界面
        if(userService.modUser(user)){
            //修改成功，重新登陆
            req.getRequestDispatcher("userLogOut").forward(req,resp);
        }else {
            //修改失败
            resp.sendRedirect("perInfoManagement?id="+user.getUserId());
        }




    }
}
