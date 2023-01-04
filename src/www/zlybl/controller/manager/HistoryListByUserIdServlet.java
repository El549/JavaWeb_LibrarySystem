package www.zlybl.controller.manager;

import www.zlybl.model.BorrowingHistory;
import www.zlybl.service.BorrowingHistoryService;
import www.zlybl.service.impl.BorrowingHistoryServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/manager/HistoryListByUserId")
public class HistoryListByUserIdServlet extends HttpServlet {
    BorrowingHistoryService borrowingHistoryService =new BorrowingHistoryServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        List<BorrowingHistory> historyList;
        if (request.getParameter("userId").equals("")){
            historyList= borrowingHistoryService.HistoryList();
        }else {
            int id=Integer.parseInt(request.getParameter("userId"));
            historyList= borrowingHistoryService.HistoryListByUserId(id);
        }
        request.setAttribute("historyList",historyList);
        request.getRequestDispatcher("borrowingHistoryManagement.do").forward(request, response);
    }
}
