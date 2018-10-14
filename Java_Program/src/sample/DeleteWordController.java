package sample;

import DictionaryProgram.Dictionary;
import DictionaryProgram.DictionaryManagement;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

import java.io.IOException;

/**
 * DeleteWordController is use to control and hand data, event from interface delete
 * @author Nguyen Huu Dat
 * @author Pham Duc Duy
 * @since 25/9/2018
 * @version 1.0
 */

public class DeleteWordController {
    @FXML
    TextField delete_Word = new TextField();

    //private DictionaryCommandline dic_Cmd = new DictionaryCommandline();
    private DictionaryManagement dic_management = new DictionaryManagement();
    private Dictionary dic = new Dictionary();
   // private Word word = new Word();

    /**
     * deleteWord is use to handle ActionEvent. Delete or not word
     * @param e
     */
    public void deleteWord(ActionEvent e)
    {
        Notifications notificationBuilder = Notifications.create().title("Add Word into Dictionary");
        Image ima_success = new Image(".\\sample\\image\\green-tick-check-mark-icon-simple-style-vector-8375981.png");

        String word_Delete = delete_Word.getText();
        dic_management.insertFromFile(dic, "avdict.txt");
        System.out.println(word_Delete);
        if (dic_management.deleteWord(dic, word_Delete) == true)
        {
            dic_management.dictionaryExportToFile(dic);
            System.out.println("true");
            notificationBuilder.text("Success!")
                    .graphic(new ImageView(ima_success))
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.CENTER);
            notificationBuilder.onAction(new EventHandler<ActionEvent>(){
                /**
                 * method handle is overrided. Using handle event
                 * @param event
                 */
                @Override
                public void handle(ActionEvent event)
                {
                    System.out.println("Click on Notification");
                }
            });
            notificationBuilder.show();
        }
        else
        {
            notificationBuilder.text("Failed!")
                    .graphic(null)
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.CENTER);
            notificationBuilder.onAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event)
                {
                    System.out.println("Click on Notification");
                }
            });
            notificationBuilder.showError();
        }
    }
    /**
     * class goBack is use to back up befor Scene
     * @param event
     * @throws IOException
     */
    public void goBack(ActionEvent event) throws IOException
    {
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("sample.fxml"));
        Parent sampleParent = loader.load();
        Scene scene = new Scene(sampleParent);
        stage.setScene(scene);

    }
}
