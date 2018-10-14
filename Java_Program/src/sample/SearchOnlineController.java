package sample;

import DictionaryProgram.Speak;
import DictionaryProgram.Translator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * SearchOnlineController class use to control file searchOnline.fxml
 * @author Nguyen Huu Dat
 * @author Pham Duc Duy
 * @version 1.0
 * @since 25/9/2018
 */
public class SearchOnlineController {
    @FXML
    private TextField input_SearchOnline = new TextField();
    @FXML
    private TextArea output_SearchOnline = new TextArea();

    /**
     * submit method is use to actionEvent to search word online
     * @param e
     */
    public void submit(ActionEvent e)
    {
        Translator translatorOnline = new Translator();
        String input = input_SearchOnline.getText();
        String output = null;
        try {
            output = translatorOnline.get_translator(input);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        output_SearchOnline.setText(output);
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
        speaker.doSpeak(input_SearchOnline.getText());
    }
}
