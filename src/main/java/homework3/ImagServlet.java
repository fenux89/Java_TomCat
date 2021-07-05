package homework3;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class ImagServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        PrintWriter writer = resp.getWriter();


        writer.println("<html>");
        writer.println("<head>");
        writer.println("<title>");
        writer.println("Hello");
        writer.println("</title>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("<h1>");
        writer.println("<img src='/src/main/resources/images/imag1.jpg' /> ");
        writer.println("</h1>");
        writer.println("<h1>");
        writer.println("<img src='/images/imag2.jpg' width=\"534\" height=\"802\" /> ");
        writer.println("</h1>");
        writer.println("<h1>");
        writer.println("<img src='C:\\Users\\fenux\\IdeaProjects\\Java_TomCat\\src\\main\\resources\\images\\imag3.jpg' /> ");
        writer.println("</h1>");
        writer.println("<h1>");
        writer.println("<img src='../../resources/images/imag4.png' /> ");
        writer.println("</h1>");
        writer.println("</body");
        writer.println("</html>");

        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}
