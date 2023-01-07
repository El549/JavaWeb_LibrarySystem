package www.zlybl.controller.manager;

import www.zlybl.service.ApplyService;
import www.zlybl.service.BookService;
import www.zlybl.service.BorrowingHistoryService;
import www.zlybl.service.impl.ApplyServiceImpl;
import www.zlybl.service.impl.BookServiceImpl;
import www.zlybl.service.impl.BorrowingHistoryServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ModApplyServlet", value = "/manager/modApply")
public class ModApplyServlet extends HttpServlet {
    ApplyService applyService = new ApplyServiceImpl();
    BookService bookService = new BookServiceImpl();
    BorrowingHistoryService borrowingHistoryService = new BorrowingHistoryServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int applyId = Integer.parseInt(request.getParameter("applyId"));
//        int userId = Integer.parseInt(request.getParameter("userId"));
        int userId = 001; //暂定为001 TODO
        int bookId = Integer.parseInt(request.getParameter("bookId"));
        boolean applyType = Boolean.parseBoolean(request.getParameter("applyType"));
        int applyStatus = Integer.parseInt(request.getParameter("applyStatus"));

        if (applyStatus == 1 && applyType == true) {
            //同意借书申请
            //更新申请表申请状态改为同意
            applyService.modApplyStatus(applyId, applyStatus);
            //更新图书表图书状态被借
            bookService.modBookStatus(bookId, false);
            //新增借阅历史表借阅记录
            borrowingHistoryService.addBorrowingHistory(bookId,userId);

            //转跳到响应的视图界面
            RequestDispatcher rd = request.getRequestDispatcher("loanApplyList");
            rd.forward(request, response);
        } else if (applyStatus == 2 && applyType == true) {
            //拒绝借书申请
            //更新申请表申请状态改为拒绝
            applyService.modApplyStatus(applyId, applyStatus);
            //转跳到响应的视图界面
            RequestDispatcher rd = request.getRequestDispatcher("loanApplyList");
            rd.forward(request, response);
        }
        if (applyStatus == 1 && applyType == false) {
            //同意还书申请
            //更新申请表申请状态改为同意
            applyService.modApplyStatus(applyId, applyStatus);
            //更新图书表图书状态可借
            bookService.modBookStatus(bookId, true);
            //修改借阅历史表借阅记录
            borrowingHistoryService.modReturnedTime(bookId);
            //转跳到响应的视图界面
            RequestDispatcher rd = request.getRequestDispatcher("returnApplyList");
            rd.forward(request, response);
        } else if (applyStatus == 2 && applyType == false) {
            //拒绝还书申请
            //更新申请表申请状态改为拒绝
            applyService.modApplyStatus(applyId, applyStatus);
            //转跳到响应的视图界面
            RequestDispatcher rd = request.getRequestDispatcher("returnApplyList");
            rd.forward(request, response);
        }
    }
}
