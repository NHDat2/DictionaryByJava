package sample;

import javafx.scene.control.Button;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import DictionaryProgram.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.Node;
import javafx.scene.Parent;

/**
 * Controller is implemented from interface Initializable. Using Controller Sample.xfml
 * @author Nguyen Huu Dat
 * @author Pham Duc Duy
 * @since 25/9/2018
 * @version 1.0
 */

public class Controller implements Initializable
{
    @FXML
    AutoCompleteTextField input_Search = new AutoCompleteTextField();
    @FXML
    Button add_Word = new Button();
    @FXML
    Button edit_Word = new Button();
    @FXML
    Button delete_Word = new Button();

    /**
     * method initialize is use to creat list suggest words
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        Dictionary list_Word = new Dictionary();
        DictionaryManagement input_list = new DictionaryManagement();
        input_list.insertFromFile(list_Word, "avdict.txt");
        int leng = list_Word.list_word.size();
        ObservableList word = FXCollections.observableArrayList();
        for (int i = 0; i < leng; i++)
        {
            word.add(list_Word.list_word.get(i).getWordTarget());

        }
        input_Search.getEntries().addAll(word);
    }

    /**
     * searchWord method is use to changeScene into Scene search
     * @param event
     * @throws IOException
     */
    public void searchWord(ActionEvent event) throws IOException {
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Search.fxml"));
        Parent addWordView = loader.load();
        Scene scene = new Scene(addWordView);
        SeachController controllerr = loader.getController();
        controllerr.setWord(input_Search.getText());
        stage.setScene(scene);
    }

    /**
     * method changeSceneAddWord is use to change Scene from interface dictionary into interface add word
     * @param event
     * @throws IOException
     */
    public void changeSceneAddWord(ActionEvent event) throws IOException
    {
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AddWord.fxml"));
        Parent addWordView = loader.load();
        Scene scene = new Scene(addWordView);
        AddWordController controllerr = loader.getController();
        stage.setScene(scene);
    }
    /**
     * method changeSceneDeleteWord is use to change Scene from interface dictionary into interface delete word
     * @param e
     * @throws IOException
     */
    public void changeSceneDeleteWord(ActionEvent e) throws IOException
    {
        Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("DeleteWord.fxml"));
        Parent deleteWordViewer = loader.load();
        Scene scene = new Scene(deleteWordViewer);
        DeleteWordController controller = loader.getController();
        stage.setScene(scene);
    }

    /**
     * changeSceneFindEditWord method is use to change scene from sample scene to EditWord scene
     * @param e
     * @throws IOException
     */
    public void changeSceneFindEditWord(ActionEvent e) throws IOException
    {

        Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("EditWord.fxml"));
        Parent sampleParent = loader.load();
        Scene scene = new Scene(sampleParent);
        stage.setScene(scene);
    }
    /**
     * changeSceneFindEditWord method is use to change scene from sample scene to SearchOnline scene
     * @param e
     * @throws IOException
     */
    public void changeSceneSearchOnline(ActionEvent e) throws IOException {
        Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("SearchOnline.fxml"));
        Parent sampleParent = loader.load();
        Scene scene = new Scene(sampleParent);
        stage.setScene(scene);
    }
    /**
     * changeSceneFindEditWord method is use to change scene from sample scene to ShowAllWord scene
     * @param e
     * @throws IOException
     */
    public void changeSceneShowAllWord(ActionEvent e) throws IOException {
        Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ShowAllWord.fxml"));
        Parent sampleParent = loader.load();
        Scene scene = new Scene(sampleParent);
        ShowAllWordController controller = loader.getController();
        controller.ShowAllWord();
        stage.setScene(scene);
    }

}
