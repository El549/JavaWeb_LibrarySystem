package www.zlybl.controller.manager;

import www.zlybl.model.Apply;
import www.zlybl.service.ApplyService;
import www.zlybl.service.impl.ApplyServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoanApplyListServlet", value = "/manager/loanApplyList")
public class LoanApplyListServlet extends HttpServlet {
    ApplyService applyService = new ApplyServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取借阅申请列表，并保存到请求范围中
        List<Apply> applyList = applyService.findApply(true);
        request.setAttribute("applyList", applyList);

        //转跳到响应的视图界面
        RequestDispatcher rd = request.getRequestDispatcher("loanApplyManagement.do");
        rd.forward(request, response);
    }
}
