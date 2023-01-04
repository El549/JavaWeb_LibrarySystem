package www.zlybl.controller.manager;

import www.zlybl.model.Book;
import www.zlybl.service.BookService;
import www.zlybl.service.impl.BookServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
//书籍信息全查
@WebServlet("/manager/bookList")
public class BookListMServlet extends HttpServlet {
    BookService bookService =new BookServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sPage=request.getParameter("page");
        int p=1;
        if(sPage!=null&&!sPage.equals("")){
            p = Integer.parseInt(sPage);
        }
        int pageSize = 5;
        int count=bookService.count();
        int pageCount = count % pageSize > 0 ? count / pageSize + 1 : count / pageSize;
        List<Book> bookList= bookService.QueryBookList(p,pageSize);
        request.setAttribute("bookList",bookList);
        request.setAttribute("pageCount", pageCount);
        request.setAttribute("p", p);
        request.getRequestDispatcher("bookManagement.do").forward(request, response);
    }

}
