package www.zlybl.controller.manager;

import www.zlybl.service.BookService;
import www.zlybl.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
