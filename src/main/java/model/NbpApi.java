package model;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import network.HttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

public class NbpApi {

    HttpClient client = new HttpClient();

    public String getCurrencyName(String currencyFromUser) {
        try {
            String myJSONString = client.getNBPQuery(currencyFromUser);
            JsonObject jsonObject = new Gson().fromJson(myJSONString, JsonObject.class);
            return jsonObject.get("currency").toString();
        } catch (Exception e) {
        }
        return "Wprowadzono niepoprawne dane";
    }

    public double getCurrencyBid(String currencyFromUser) {
        try {
            String myJSONString = client.getNBPQuery(currencyFromUser);
            JSONObject objectForJsonArray = new JSONObject(myJSONString);
            JSONArray currencyJsonArray = objectForJsonArray.getJSONArray("rates");
            JSONObject currency = currencyJsonArray.getJSONObject(0);
            return Double.parseDouble(currency.getString("bid"));
        } catch (Exception e) {
        }
        return 0;
    }
    public double getCurrencyAsk(String currencyFromUser) {
        try {
            String myJSONString = client.getNBPQuery(currencyFromUser);
            JSONObject objectForJsonArray = new JSONObject(myJSONString);
            JSONArray currencyJsonArray = objectForJsonArray.getJSONArray("rates");
            JSONObject currency = currencyJsonArray.getJSONObject(0);
            return Double.parseDouble(currency.getString("ask"));
        } catch (Exception e) {
        }
        return 0;
    }
    public String getCurrencyDate(String currencyFromUser) {
        try {
            String myJSONString = client.getNBPQuery(currencyFromUser);
            JSONObject object = new JSONObject(myJSONString);
            JSONArray array = object.getJSONArray("rates");
            JSONObject currency = array.getJSONObject(0);
            return "Kurs waluty z dnia: " + currency.getString("effectiveDate");
        } catch (Exception e) {
        }
        return "Wprowadzono niepoprawne dane";
    }

    public String getCurrencyCode(String currencyFromUser) {
        try {
            String myJSONString = client.getNBPQuery(currencyFromUser);
            JsonObject jsonObject = new Gson().fromJson(myJSONString, JsonObject.class);
            return jsonObject.get("code").toString();

        } catch (Exception e) {
        }
        return "Wprowadzono niepoprawne dane";
    }
}
