package www.zlybl.controller.manager;

import www.zlybl.model.Apply;
import www.zlybl.service.ApplyService;
import www.zlybl.service.impl.ApplyServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ReturnApplyListServlet", value = "/manager/returnApplyList")
public class ReturnApplyListServlet extends HttpServlet {
    ApplyService applyService = new ApplyServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取借阅申请列表，并保存到请求范围中
        List<Apply> applyList = applyService.findApply(false);
        request.setAttribute("applyList", applyList);

        //转跳到响应的视图界面
        RequestDispatcher rd = request.getRequestDispatcher("returnApplyManagement.do");
        rd.forward(request, response);
    }
}
