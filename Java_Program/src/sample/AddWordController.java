package sample;

import DictionaryProgram.Dictionary;
import DictionaryProgram.DictionaryManagement;
import DictionaryProgram.Word;
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
 * Class AddWordController use to control and handle data, event of adding word into dictionary
 * @author Nguyen Huu Dat
 * @author Pham Duc Duy
 * @since 25/9/2018
 * @version 1.0
 */
public class AddWordController
{
    @FXML
    TextField add_WordTarget = new TextField();
    @FXML
    TextField add_WordExplain = new TextField();
    @FXML
    TextField add_Pronounce = new TextField();

    private DictionaryManagement dic_management = new DictionaryManagement();
    private Dictionary dic = new Dictionary();
    private Word word = new Word();

    /**
     * method submit is use to handle event add word into dictionary
     * @param e
     */
    public void submit(ActionEvent e)
    {
        String new_WordTarget = add_WordTarget.getText();
        String new_WordExplain = add_WordExplain.getText();
        String new_Pronounce = add_Pronounce.getText();

        word.setWordTarget(new_WordTarget);
        word.setWordExplain(new_WordExplain);
        dic_management.insertFromFile(dic, "avdict.txt");

        Image ima_success = new Image(".\\sample\\image\\green-tick-check-mark-icon-simple-style-vector-8375981.png");

        Notifications notificationBuilder = Notifications.create().title("Add Word into Dictionary");

        if (((word.getWordTarget().length() != 0)
                && ((word.getWordTarget().charAt(0) >= 65 && word.getWordTarget().charAt(0) <= 90)
                || (word.getWordTarget().charAt(0) >= 97 && word.getWordTarget().charAt(0) <= 122)))
        && ((word.getWordExplain().length() != 0)
                && ((word.getWordExplain().charAt(0) >= 65 && word.getWordExplain().charAt(0) <= 90)
                || (word.getWordExplain().charAt(0) >= 97 && word.getWordExplain().charAt(0) <= 122))))
        {
            word.setWordExplain("/" + new_Pronounce + "/   " + new_WordExplain);
            if (dic_management.addWords(dic, word))
            {
                dic_management.dictionaryExportToFile(dic);
                notificationBuilder.text("Success!")
                                    .graphic(new ImageView(ima_success))
                                    .hideAfter(Duration.seconds(5))
                                    .position(Pos.CENTER);
                notificationBuilder.onAction(new EventHandler<ActionEvent>(){
                    /**
                     * overriding method handle to print into Scence
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
                    /**
                     * overriding method handle to print into Scence
                     * @param event
                     */
                    @Override
                    public void handle(ActionEvent event)
                    {
                        System.out.println("Click on Notification");
                    }
                });
                notificationBuilder.showError();
            }
        }
        else
        {
            notificationBuilder.text("Failed!")
                    .graphic(null)
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.CENTER);
            notificationBuilder.onAction(new EventHandler<ActionEvent>(){
                /**
                 * overriding method handle to print into Scence
                 * @param event
                 */
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
