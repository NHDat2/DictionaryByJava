package sample;

import DictionaryProgram.Dictionary;
import DictionaryProgram.DictionaryManagement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Main class use to run appDictionary
 * @author Nguyen Huu Dat
 * @author Pham Duc Duy
 * @version 1.0
 * @since 25/9/2018
 */

public class ShowAllWordController {
    @FXML
    private ListView List_Word = new ListView();

    /**
     * showAllWord is use to Show All Word in data into ListView
     */
    public void ShowAllWord()
    {
        Dictionary list = new Dictionary();
        DictionaryManagement control = new DictionaryManagement();
        control.insertFromFile(list, "avdict.txt");
        ArrayList<String> list_word = new ArrayList<String>();
        for (int i = 0; i < list.list_word.size(); i++)
        {
            String target = list.list_word.get(i).getWordTarget();
            String explain = list.list_word.get(i).getWordExplain();
            String result = target + "\t" + explain;
            list_word.add(result);
        }
        List_Word.getItems().addAll(list_word);
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

}
