package www.zlybl.controller.user;

import www.zlybl.model.Apply;
import www.zlybl.model.User;
import www.zlybl.service.ApplyService;
import www.zlybl.service.impl.ApplyServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ApplyForReturnServlet", value = "/user/applyForReturn")
public class ApplyForReturnServlet extends HttpServlet {
    ApplyService applyService = new ApplyServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Apply apply = new Apply();
        Boolean applyType = false;
        int applyStatus = 0;
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        User user = (User) request.getSession().getAttribute("user");
        apply.setUserId(user.getUserId());
        apply.setBookId(Integer.parseInt(request.getParameter("bookId")));
        apply.setApplyType(applyType);
        apply.setApplyStatus(applyStatus);

        //调用相应的业务逻辑方法执行添加用户的操作,并根据结果跳转到相应界面
        if(applyService.applyForLoan(apply)){
            PrintWriter out = response.getWriter();
            out.println("<script>alert('申请成功');" +
                    "window.location.href= 'outstandingBookList'</script>");
            out.close();
//            response.sendRedirect("success.do");
        }else {
            PrintWriter out = response.getWriter();
            out.println("<script>alert( '申请失败');"+
                    "window.location.href= 'outstandingBookList'</script>");
            out.close();
//            response.sendRedirect("failed.do");
        }
    }
}
