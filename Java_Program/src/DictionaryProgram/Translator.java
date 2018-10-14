package DictionaryProgram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * class Translator is use to translate from api google translate
 * @author Nguyen Huu Dat
 * @author Pham Duc Duy
 * @since 25/9/2018
 * @version 1.0
 */

public class Translator {

    public String get_translator (String text) throws IOException {
        System.out.println("Please wait a few seconds ");
        String translated = translate("en", "vi", text);
        try{
            //TimeUnit.SECONDS.sleep(3);
        }
        catch (Exception er){};
        return translated;
    }

    private static String translate(String langFrom, String langTo, String text) throws IOException {
        String urlStr = "https://script.google.com/macros/s/AKfycbzGXSqBlm62Vu4WZBsp1gWn8WVtTyE9oToHRrrL3Zau1nOpvl5L/exec" +
                "?q=" + URLEncoder.encode(text, "UTF-8") +
                "&target=" + langTo +
                "&source=" + langFrom;
        URL url = new URL(urlStr);
        StringBuilder response = new StringBuilder();
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }

}
