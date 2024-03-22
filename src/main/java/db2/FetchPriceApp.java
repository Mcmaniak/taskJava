package db2;

public class FetchPriceApp {
    public static void main(String[] args) {
        String symbol = "BTCUSDT";

        RequestAPI requestAPI = new RequestAPI(symbol);
        String jsonRes = requestAPI.sendRequest(symbol);
        if (jsonRes != null) {
            String price = jsonRes.split("\"price\":\"")[1].split("\"")[0];
            float priceRnd = Float.parseFloat(price);
            System.out.println("The price of " + symbol + " right now is around: " + priceRnd + " $.");
        } else {
            System.err.println("Error with fetching data from Binance.");
        }
    }

}
