package bnyOA;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import org.json.JSONObject;
public class callAPI {
    public int findTimes(String input) throws Exception{
        String url = "https://en.wikipedia.org/w/api.php?action=parse&section=0&prop=text&format=json&page=[topic]";
        url = url.replace("[topic]", input);
        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        BufferedReader in = new BufferedReader((new InputStreamReader(con.getInputStream())));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        System.out.println(response.toString());
        JSONObject myResponse = new JSONObject(response.toString());
        JSONObject content = myResponse.getJSONObject("parse");
        JSONObject content2 = content.getJSONObject("text");
        String countString = content2.getString("*");
        int count = 0;
        for (int i = 0; i < countString.length(); i++) {
            if (countString.charAt(i) == input.charAt(0)) {
                if (countString.substring(i, i + input.length()).equals(input)) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        callAPI here = new callAPI();
        try {
            System.out.println(here.findTimes("pizza"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
