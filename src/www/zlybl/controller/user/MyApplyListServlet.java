package www.zlybl.controller.user;

import www.zlybl.model.Apply;
import www.zlybl.service.ApplyService;
import www.zlybl.service.impl.ApplyServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/user/myApplyList")
public class MyApplyListServlet extends HttpServlet {
    ApplyService applyService=new ApplyServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int userId= Integer.parseInt(request.getParameter("userId"));
        List<Apply> applies;
        applies=applyService.MyApply(userId);
        request.setAttribute("applyList",applies);
        request.getRequestDispatcher("myApply.do").forward(request, response);
    }
}
