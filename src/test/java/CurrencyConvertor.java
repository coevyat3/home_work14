import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class CurrencyConvertor {
    private static Scanner sc= new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to currency convertor\nEnter amount to convert");
        int amount=sc.nextInt();
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("https://api.exchangeratesapi.io/latest?base=USD").build();
        Response response = client.newCall(request).execute();
        String jsonData = response.body().string();
        JSONObject mainJsonObject = new JSONObject(jsonData);
        JSONObject ratesJsonObject = mainJsonObject.getJSONObject("rates");
         double s=amount * ratesJsonObject.getDouble("ILS");
        System.out.println(s);
        System.out.println("Thanks for using our currency converter");
    }
}