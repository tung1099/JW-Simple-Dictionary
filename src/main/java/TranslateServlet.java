import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "TranslateServlet", value = "/translate")
public class TranslateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("Hello", "Xin chào");
        dictionary.put("Car", "Ô tô");
        dictionary.put("Dog", "Con chó");
        dictionary.put("Cat", "Con mèo");
        dictionary.put("Book", "Quyển vở");

        String search = request.getParameter("txtSearch");

        PrintWriter writer = response.getWriter();
        writer.println("<html>");

        String result = dictionary.get(search);
        if (result != null){
            writer.println("<h1>Word: " + search + "</h1>");
            writer.println("<h1>Result: " + result + "</h1>");
        } else {
            writer.println("Not found");
        }
        writer.println("</html>");
    }
}
