import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "MainServlet")
public class MainServlet extends HttpServlet {
    DB db = new DB();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String submit = request.getParameter("submit");
        switch (submit) {
            case "add" : {
                String name = request.getParameter("name");
                String author = request.getParameter("author");
                int  countOfCopies = Integer.parseInt(request.getParameter("countofcopies"));
                String imageUrl = request.getParameter("imageUrl");
                int added = db.add(name, author,countOfCopies,imageUrl);
                request.setAttribute("crud", "c" + added);
                break;
            }
            case "delete" : {
                String bookId = request.getParameter("bookId");
                int deleted = db.delete(bookId);
                request.setAttribute("crud", "d" + deleted);
                break;
            }
            case "update" : {

            }
            case "search" : {
                String name = request.getParameter("name");
                ArrayList<Book> bookList = db.search(name);
                response.setContentType("text/html");
                String json = new Gson().toJson(bookList);
                response.getWriter().write(json);
                return;
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
