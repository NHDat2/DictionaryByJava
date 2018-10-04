package DictionaryProgram;

import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Translator {

    public void get_translator () throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter your word: ");
        String text;
        text = scan.nextLine();
        System.out.println("Please wait a few seconds ");
        String translated = "Translated text: " + translate("en", "vi", text);
        System.out.println(translated);
        try{
            TimeUnit.SECONDS.sleep(3);
        }
        catch (Exception er){};
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
