package pastOA.bnyOA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.*;
public class callAPI {
    public int findTimes(String topic) throws Exception{
        final Gson gson = new Gson();
        String url = "https://en.wikipedia.org/w/api.php?action=parse&section=0&prop=text&format=json&page=[topic]";
        url = url.replace("[topic]", topic);
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        BufferedReader in = new BufferedReader((new InputStreamReader(con.getInputStream())));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        System.out.println(response.toString());
        //JsonObject myResponse = gson.fromJson(response.toString(), String.class);
        //JSONObject myResponse = new JSONObject(response.toString());
        JsonObject myResponse = new JsonParser().parse(response.toString()).getAsJsonObject();
        JsonObject content = myResponse.get("parse").getAsJsonObject();
        JsonObject content2 = content.get("text").getAsJsonObject();;
        String countString = content2.get("*").getAsString();
        int count = 0;
        for (int i = 0; i < countString.length(); i++) {
            if (countString.charAt(i) == topic.charAt(0)) {
                if (countString.substring(i, i + topic.length()).equals(topic)) {
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
