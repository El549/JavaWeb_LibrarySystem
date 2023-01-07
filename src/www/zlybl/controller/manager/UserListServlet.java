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
import java.util.List;

//用户全查
@WebServlet(name = "UserListServlet", value = "/manager/userList")
public class UserListServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解析客户端请求，通过查询字符串获取分页信息
        String sPage = req.getParameter("page");

//        System.out.println(sPage);

        int p = 1;
        if (sPage != null && !sPage.equals("")) {
            p = Integer.parseInt(sPage);
        }
        int pageSize = 7;
        int count = userService.count();
        int pageCount = count % pageSize > 0 ? count / pageSize + 1 : count / pageSize;

        //获取用户列表，并保存至某个范围内
        List<User> userList = userService.findUserByPage(p, pageSize);
        req.setAttribute("userList", userList);
        req.setAttribute("pageCount", pageCount);
        req.setAttribute("p", p);

        //转跳到响应的视图界面
        RequestDispatcher rd = req.getRequestDispatcher("userManagement.do");
        rd.forward(req, resp);

    }
}
