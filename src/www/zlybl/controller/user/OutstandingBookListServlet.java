package www.zlybl.controller.user;

import www.zlybl.model.Book;
import www.zlybl.model.User;
import www.zlybl.service.BookService;
import www.zlybl.service.impl.BookServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "OutstandingBookListServlet", value = "/user/outstandingBookList")
public class OutstandingBookListServlet extends HttpServlet {
    BookService bookService = new BookServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        User user = (User) request.getSession().getAttribute("user");

        //获取图书列表，并保存到请求范围中
        List<Book> bookList = bookService.findBooksByUserId(user.getUserId());
        request.setAttribute("bookList",bookList);

        //转跳到响应的视图界面
        RequestDispatcher rd = request.getRequestDispatcher("outstandingBookQuery.do");
        rd.forward(request, response);
    }
}
