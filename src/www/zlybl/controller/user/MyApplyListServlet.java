package www.zlybl.controller.user;

import www.zlybl.model.Apply;
import www.zlybl.service.ApplyService;
import www.zlybl.service.impl.ApplyServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/user/MyApplyList")
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
