package www.zlybl.controller.user;

import www.zlybl.model.BorrowingHistory;
import www.zlybl.service.BorrowingHistoryService;
import www.zlybl.service.impl.BorrowingHistoryServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/user/BorrowingHistoryListByUserId")
public class BorrowingHistoryListByUserIdServlet extends HttpServlet {
    BorrowingHistoryService borrowingHistoryService =new BorrowingHistoryServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        List<BorrowingHistory> historyList;
        int userId= Integer.parseInt(request.getParameter("userId"));
        historyList= borrowingHistoryService.HistoryListByUserId(userId);
        request.setAttribute("historyList",historyList);
        request.getRequestDispatcher("borrowingHistoryQuery.do").forward(request, response);
    }
}
