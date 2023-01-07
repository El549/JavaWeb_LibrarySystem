package www.zlybl.controller.user;

import www.zlybl.model.Book;
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

@WebServlet(name = "BookListUServlet", value = "/user/bookListU")
public class BookListUServlet extends HttpServlet {
    BookService bookService = new BookServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //解析客户端请求，通过查询字符串获取分页信息
        String sPage = request.getParameter("page");
        int p = 1;
        if (sPage != null && !sPage.equals("")) {
            p = Integer.parseInt(sPage);
        }
        int pageSize = 5;
        int count = bookService.count();
        int pageCount = count % pageSize > 0 ? count / pageSize + 1 : count / pageSize;

        //获取图书列表，并保存到请求范围中
        List<Book> bookList = bookService.findAllBooksByPage(p,pageSize);
        request.setAttribute("bookList",bookList);
        request.setAttribute("pageCount",pageCount);
        request.setAttribute("p",p);
        //转跳到响应的视图界面
        RequestDispatcher rd = request.getRequestDispatcher("bookQuery.do");
        rd.forward(request, response);
    }
}
