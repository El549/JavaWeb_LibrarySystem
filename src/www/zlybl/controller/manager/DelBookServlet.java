package www.zlybl.controller.manager;

import www.zlybl.service.BookService;
import www.zlybl.service.impl.BookServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/manager/delBook")
public class DelBookServlet extends HttpServlet {
    BookService bookService =new BookServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id= request.getParameter("bookId");
        if (bookService.DelBook(Integer.parseInt(id))){
            response.sendRedirect("bookList");
        }else {
            response.sendRedirect("delBook?bookId="+Integer.parseInt(id));
        }
    }
}
