package www.zlybl.controller.user;

import www.zlybl.model.BorrowingHistory;
import www.zlybl.service.BorrowingHistoryService;
import www.zlybl.service.impl.BorrowingHistoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/user/borrowingHistoryListByUserId")
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
