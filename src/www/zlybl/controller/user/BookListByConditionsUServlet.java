package www.zlybl.controller.user;

import www.zlybl.model.Book;
import www.zlybl.service.BookService;
import www.zlybl.service.impl.BookServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookListByConditionsUServlet", value = "/user/bookListByConditionsU")
public class BookListByConditionsUServlet extends HttpServlet {
    BookService bookService = new BookServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取图书列表，并保存到请求范围中
        request.setCharacterEncoding("utf-8");
        Book targetBook = new Book();
        targetBook.setBookName(request.getParameter("bookName"));
        targetBook.setAuthor(request.getParameter("author"));
        targetBook.setPress(request.getParameter("press"));
        targetBook.setBookClass(request.getParameter("bookClass"));
        targetBook.setBookStatus(Boolean.parseBoolean(request.getParameter("bookStatus")));

        List<Book> bookList = bookService.findBooksByConditions(targetBook);
        request.setAttribute("bookList", bookList);

        //转跳到响应的视图界面
        RequestDispatcher rd = request.getRequestDispatcher("bookQueryByConditions.do");
        rd.forward(request, response);
    }
}
