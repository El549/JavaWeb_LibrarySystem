package www.zlybl.controller.manager;

import www.zlybl.model.Book;
import www.zlybl.service.BookService;
import www.zlybl.service.impl.BookServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
//修改书籍信息
@WebServlet("/manager/modBook")
public class ModBookServlet extends HttpServlet {
    BookService bookService =new BookServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id= request.getParameter("bookId");
        Book book= bookService.findBookById(Integer.parseInt(id));
        request.setAttribute("book",book);
        request.getRequestDispatcher("modBook.do").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Book book=new Book();
        request.setCharacterEncoding("utf-8");
        book.setBookId(Integer.parseInt(request.getParameter("bookId")));
        book.setBookCover(request.getParameter("bookCover"));
        book.setBookName(request.getParameter("bookName"));
        book.setAuthor(request.getParameter("author"));
        book.setPress(request.getParameter("press"));
        book.setBookClass(request.getParameter("bookClass"));
        if(request.getParameter("bookStatus").equals("true")){
            book.setBookStatus(true);
        }else {
            book.setBookStatus(false);
        }

        //调用相应的业务逻辑方法执行添加用户的操作,并根据结果跳转到相应界面

        if(bookService.ModBook(book)){
            response.sendRedirect("bookList");
        }else {
            response.sendRedirect("modBook?bookId="+book.getBookId());
        }

    }
}
