package homework4;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class MoneyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF-8");

        String request = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json";

        String result = performRequest(request);

        Gson gson = new GsonBuilder().create();
       
        Money[] monies = gson.fromJson(result, Money[].class);


        PrintWriter writer = resp.getWriter();

        writer.println("<html>");
        writer.println("<head>");
        writer.println("<title>");
        writer.println("Money");
        writer.println("</title>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("<h1>");
        for (Money money : monies) {
            if (money.getCc().equals("UAN") || money.getCc().equals("RUB") || money.getCc().equals("USD") || money.getCc().equals("EUR")) {
                writer.print("<p>");
                writer.print(money);
                writer.print("</p>");
            }
        }
            writer.println("</h1>");

            writer.println("</body");
            writer.println("</html>");

            writer.close();

    }

        @Override
        protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            super.doPost(req, resp);
        }
        private static String performRequest (String urlStr) throws IOException {
            URL url = new URL(urlStr);

            StringBuilder sb = new StringBuilder();

            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream(), "UTF-8"));
                char[] buf = new char[1000000];

                int counter;
                do {
                    if ((counter = br.read(buf)) > 0) {
                        sb.append(new String(buf, 0, counter));
                    }
                } while (counter > 0);
            } finally {
                http.disconnect();
            }

            return sb.toString();
        }
    }
