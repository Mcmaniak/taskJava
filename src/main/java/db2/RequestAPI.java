package db2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class RequestAPI {
    private String apiKey;
    public RequestAPI(String apiKey){
        this.apiKey = apiKey;
    }

    public String sendRequest(String symbol){
        try {
            URL url = new URI("https://api.binance.com/api/v3/ticker/price?symbol=" + symbol).toURL();
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while((line = reader.readLine()) != null){
                response.append(line);
            }
            reader.close();

            connection.disconnect();

            return response.toString();
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
