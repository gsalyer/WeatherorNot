import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

public class Weather
{
    private final String ACCESS_TOKEN = "1655f919bbcd29ed";
    private JsonElement json;

    public Weather(String zip)
    {
        try
        {
            String encodedZip = URLEncoder.encode(zip, "utf-8");
            String apiURL = "http://api.wunderground.com/api/" +
                    ACCESS_TOKEN + "/conditions/q/" + encodedZip + ".json";

            URL weatherURL = new URL(apiURL);

            InputStream is = weatherURL.openStream();
            InputStreamReader isr = new InputStreamReader(is);
            JsonParser parser = new JsonParser();
            json = parser.parse(isr);
        }
        catch (java.net.MalformedURLException mue)
        {
            System.out.println("Malformed URL");
        }
        catch (java.io.IOException ioe)
        {
            System.out.println("IO Error");
        }
    }

    public String getWeather()
    {
        return json.getAsJsonObject().get("current_observation").getAsJsonObject().get("weather").getAsString();
    }

    public String getTemperature()
    {
        return json.getAsJsonObject().get("current_observation").getAsJsonObject().get("temperature_string").getAsString();
    }

    public String getCityState()
    {
        return json.getAsJsonObject().get("current_observation").getAsJsonObject().get("display_location").getAsJsonObject().get("full").getAsString();
    }


    public static void main(String[] args)
    {
        Weather w = new Weather("95677");
        System.out.println(w.getCityState());
        System.out.println(w.getWeather());
        System.out.println(w.getTemperature());
    }
}
