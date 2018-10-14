package sample;

import DictionaryProgram.Dictionary;
import DictionaryProgram.DictionaryManagement;
import DictionaryProgram.Speak;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;

/**
 * class SeachController use to control file search.fxml
 * @author Nguyen Huu Dat
 * @author Pham Duc Duy
 * @since 25/9/2018
 * @version 1.0
 */

public class SeachController
{
    @FXML
    private Label output = new Label();
    @FXML
    private ListView output2 = new ListView();

    private DictionaryManagement dic_management = new DictionaryManagement();
    private Dictionary dic = new Dictionary();
    private String word_target = "";
    private String word_explain = "";

    /**
     * setWord method is use to take data and display from input of main scene
     * @param word_Target
     */
    public void setWord(String word_Target)
    {
        word_target = word_Target;
        dic_management.insertFromFile(dic, "avdict.txt");
        String temp = dic_management.dictionaryLookup(dic, word_Target);
        word_explain = temp;
        String[] s = new String[15];
        int count = 0;
        for (int i = 0; i < temp.length(); i++)
        {
            if (temp.charAt(i) != '/' && temp.charAt(i) != ',')
            {
                s[count] += temp.charAt(i);
            }
            else
            {
                count++;
            }
        }
        for (int i = 1; i <= count ; i++)
        {
            s[i] = s[i].substring(4, s[i].length());
            s[i] = s[i].trim();
        }
        output.setText("/" + s[1] + "/");
        ArrayList<String> arResult = new ArrayList<String>();
        String result = word_Target + ":" + "\n";
        arResult.add(result);
        for (int i = 2; i <= count; i++)
        {
            result = s[i] + "\n";
            arResult.add(result);
        }
        output2.getItems().addAll(arResult);
    }
    /**
     * class goBack is use to back up befor Scene
     * @param event
     * @throws IOException
     */
    public void goBack(ActionEvent event) throws IOException
    {
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loaderr = new FXMLLoader();
        loaderr.setLocation(getClass().getResource("sample.fxml"));
        Parent sampleParent = loaderr.load();
        Scene scene = new Scene(sampleParent);
        stage.setScene(scene);
    }

    /**
     * Speak method is use to speak
     * @param e
     */
    public void Speak(ActionEvent e)
    {
        Speak speaker = new Speak();
        speaker.doSpeak(word_target);
    }
}
