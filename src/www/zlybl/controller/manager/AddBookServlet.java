package www.zlybl.controller.manager;

import www.zlybl.model.Book;
import www.zlybl.service.BookService;
import www.zlybl.service.impl.BookServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/manager/addBook")
public class AddBookServlet extends HttpServlet {
    BookService bookService =new BookServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Book book=new Book();
        book.setBookCover(request.getParameter("bookCover"));
        book.setBookName(request.getParameter("bookName"));
        book.setAuthor(request.getParameter("author"));
        book.setPress(request.getParameter("press"));
        book.setBookClass(request.getParameter("bookClass"));
        if(bookService.AddBook(book)){
            response.sendRedirect("bookList");
        }
    }
}
