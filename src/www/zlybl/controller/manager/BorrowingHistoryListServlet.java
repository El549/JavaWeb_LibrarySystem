package www.zlybl.controller.manager;

import www.zlybl.model.BorrowingHistory;
import www.zlybl.service.BorrowingHistoryService;
import www.zlybl.service.impl.BorrowingHistoryServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/manager/BorrowingHistoryList")
public class BorrowingHistoryListServlet extends HttpServlet {
    BorrowingHistoryService borrowingHistoryService =new BorrowingHistoryServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<BorrowingHistory> histories= borrowingHistoryService.HistoryList();
        request.setAttribute("historyList",histories);
        request.getRequestDispatcher("borrowingHistoryManagement.do").forward(request, response);
    }
}
