import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
public class CurrencyConverter {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("===== CURRENCY CONVERTER =====");
            System.out.println("Available: USD, EUR, INR, GBP, JPY");
            System.out.println("--------------------------------");
            System.out.print("Enter base currency (code only): ");
            String base = input.next().toUpperCase();
            System.out.print("Enter target currency (code only): ");
            String target = input.next().toUpperCase();
            System.out.print("Enter amount to convert: ");
            double amount = input.nextDouble();
            if (amount <= 0) {
                System.out.println("Amount must be greater than 0");
                return;
            }
            String apiUrl = "https://open.er-api.com/v6/latest/" + base;
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            String json = response.toString();
            if (!json.contains("\"result\":\"success\"")) {
                System.out.println("Invalid base currency or API error.");
                return;
            }
            String searchKey = "\"" + target + "\":";
            if (!json.contains(searchKey)) {
                System.out.println("Invalid target currency.");
                return;
            }
            String rateStr = json.split(searchKey)[1]
                                 .split(",")[0]
                                 .replace("}", "")
                                 .trim();
            double rate = Double.parseDouble(rateStr);
            double convertedAmount = amount * rate;
            System.out.println("\n===== CONVERSION RESULT =====");
            System.out.println(amount + " " + base + " = " + convertedAmount + " " + target);
            System.out.println("Exchange Rate: 1 " + base + " = " + rate + " " + target);
            input.close();
        } catch (Exception e) {
            System.out.println("Error: Check internet connection or currency code.");
        }
    }
}