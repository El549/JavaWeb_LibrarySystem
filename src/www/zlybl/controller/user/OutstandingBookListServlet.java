package www.zlybl.controller.user;

import www.zlybl.model.Book;
import www.zlybl.service.BookService;
import www.zlybl.service.impl.BookServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "OutstandingBookListServlet", value = "/user/outstandingBookList")
public class OutstandingBookListServlet extends HttpServlet {
    BookService bookService = new BookServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
//        int userId = Integer.parseInt(request.getParameter("userId"));
        int userId = 001; //暂定为001 TODO
        //获取图书列表，并保存到请求范围中
        List<Book> bookList = bookService.findBooksByUserId(userId);
        request.setAttribute("bookList",bookList);

        //转跳到响应的视图界面
        RequestDispatcher rd = request.getRequestDispatcher("outstandingBookQuery.do");
        rd.forward(request, response);
    }
}
