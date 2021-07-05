package homework4;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws Exception {

        String request = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json";

        String result = performRequest(request);

        Gson gson = new GsonBuilder().create();

        Money[] monies =  gson.fromJson(result, Money[].class);


        for (Money money: monies) {
            if (money.getCc().equals("UAN")||money.getCc().equals("RUB")||money.getCc().equals("USD")||money.getCc().equals("EUR"))
            System.out.println(money);
        }

    }


    private static String performRequest(String urlStr) throws IOException {
        URL url = new URL(urlStr);

        StringBuilder sb = new StringBuilder();

        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream()));
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
