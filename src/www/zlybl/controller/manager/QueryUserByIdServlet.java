package www.zlybl.controller.manager;

import www.zlybl.model.User;
import www.zlybl.service.UserService;
import www.zlybl.service.impl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "QueryUserByIdServlet", value = "/manager/queryUserById")
public class QueryUserByIdServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //接受表单中的数据
        String sid = req.getParameter("userId");
        //System.out.println(sid);

        //在数据库中查找
        User user = null;
        user= userService.findUserById(sid);
        //System.out.println(user);
        req.setAttribute("user",user);


        //返回用户列表
//        req.getRequestDispatcher("userPerInfoManagement.do").forward(req,resp);
        if(user!=null){
            //进入用户个人信息管理页面
            RequestDispatcher rd = req.getRequestDispatcher("userPerInfoManagement.do");
            rd.forward(req, resp);
        }else{
            //回到用户管理页面
            resp.sendRedirect("userList");
        }

    }
}
