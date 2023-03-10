package www.zlybl.controller.user;

import www.zlybl.model.Apply;
import www.zlybl.model.User;
import www.zlybl.service.ApplyService;
import www.zlybl.service.impl.ApplyServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ApplyForLoanServlet", value = "/user/applyForLoan")
public class ApplyForLoanServlet extends HttpServlet {
    ApplyService applyService = new ApplyServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Apply apply = new Apply();
        Boolean applyType = true;
        int applyStatus = 0;
        request.setCharacterEncoding("utf-8");
        User user = (User) request.getSession().getAttribute("user");
        apply.setUserId(user.getUserId());
        apply.setBookId(Integer.parseInt(request.getParameter("bookId")));
        apply.setApplyType(applyType);
        apply.setApplyStatus(applyStatus);

        //调用相应的业务逻辑方法执行添加用户的操作,并根据结果跳转到相应界面
        if(applyService.applyForLoan(apply)){
            response.sendRedirect("success.do");
        }else {
            response.sendRedirect("failed.do");
        }
    }
}
