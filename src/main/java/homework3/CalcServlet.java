package homework3;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class CalcServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        proccessRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        proccessRequest(req, resp);
    }

    private void proccessRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter writer = resp.getWriter();
        CalcOperations co = new CalcOperations();

        try {
            String operation = req.getParameter("operation");

            System.out.println(operation);
            int value1 = Integer.valueOf(req.getParameter("one"));
            System.out.println(value1);
            int value2 = Integer.valueOf(req.getParameter("two"));
            System.out.println(value2);

            writer.println("<html>");
            writer.println("<head>");
            writer.println("<title>Calc Operations</title>");
            writer.println("</head>");
            writer.println("<body>");
            writer.print("<p>" + co.Calc(operation, value1, value2) + "</p>");


        } catch (Exception e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            e.printStackTrace();
        } finally {
            writer.println("</body");
            writer.println("</html>");
            writer.close();
        }

    }

}
