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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import javafx.scene.control.TextField;
import java.io.IOException;

/**
 * @author Nguyen Huu Dat
 * @author Pham Duc Duy
 * @since 25/9/2018
 * @version 1.0
 */

public class EditWordController
{
    @FXML
    private TextField Edit_WordTarget = new TextField();
    @FXML
    private TextField Edit_WordExplain = new TextField();
    @FXML
    private TextField Edit_Pronounce = new TextField();

    private DictionaryManagement dic_management = new DictionaryManagement();
    private Dictionary dic = new Dictionary();
    private Word word = new Word();

    /**
     * submit method is use to actionEvent edit word
     * @param event
     * @throws IOException
     */
    public void submit(ActionEvent event) throws IOException {
        String new_WordTarget = Edit_WordTarget.getText();
        String new_WordExplain = Edit_WordExplain.getText();
        String new_Pronounce = Edit_Pronounce.getText();

        word.setWordTarget(new_WordTarget);
        word.setWordExplain(new_Pronounce + "/" + "   " + new_WordExplain);
        dic_management.insertFromFile(dic, "avdict.txt");

        javafx.scene.image.Image ima_success = new Image(".\\sample\\image\\green-tick-check-mark-icon-simple-style-vector-8375981.png");

        if (((word.getWordTarget().length() != 0)
                && ((word.getWordTarget().charAt(0) >= 65 && word.getWordTarget().charAt(0) <= 90)
                || (word.getWordTarget().charAt(0) >= 97 && word.getWordTarget().charAt(0) <= 122)))
                && ((word.getWordExplain().length() != 0)
                && ((word.getWordExplain().charAt(0) >= 65 && word.getWordExplain().charAt(0) <= 90)
                || (word.getWordExplain().charAt(0) >= 97 && word.getWordExplain().charAt(0) <= 122)))) {
            String result = dic_management.dictionaryLookup(dic, new_WordTarget);
            if (result == "") {
                Notifications notificationBuilder = Notifications.create().title("Find Word from Dictionary");
                notificationBuilder.text("Failed!")
                        .graphic(null)
                        .hideAfter(Duration.seconds(5))
                        .position(Pos.CENTER);
                notificationBuilder.onAction(new EventHandler<ActionEvent>() {
                    /**
                     * overriding method handle to print into Scence
                     *
                     * @param event
                     */
                    @Override
                    public void handle(ActionEvent event) {
                        System.out.println("Click on Notification");
                    }
                });
                notificationBuilder.showError();
            } else {
                if (dic_management.editWord(dic, new_WordTarget, word)) {
                    dic_management.dictionaryExportToFile(dic);
                    Notifications notificationBuilder = Notifications.create().title("Find Word from Dictionary");
                    notificationBuilder.text("Success!")
                            .graphic(new ImageView(ima_success))
                            .hideAfter(Duration.seconds(5))
                            .position(Pos.CENTER);
                    notificationBuilder.onAction(new EventHandler<ActionEvent>() {
                        /**
                         * overriding method handle to print into Scence
                         *
                         * @param event
                         */
                        @Override
                        public void handle(ActionEvent event) {
                            System.out.println("Click on Notification");
                        }
                    });
                    notificationBuilder.show();
                } else {
                    Notifications notificationBuilder = Notifications.create().title("Find Word from Dictionary");
                    notificationBuilder.text("Failed!")
                            .graphic(null)
                            .hideAfter(Duration.seconds(5))
                            .position(Pos.CENTER);
                    notificationBuilder.onAction(new EventHandler<ActionEvent>() {
                        /**
                         * overriding method handle to print into Scence
                         *
                         * @param event
                         */
                        @Override
                        public void handle(ActionEvent event) {
                            System.out.println("Click on Notification");
                        }
                    });
                    notificationBuilder.showError();
                }
            }

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
        FXMLLoader loaderr = new FXMLLoader();
        loaderr.setLocation(getClass().getResource("sample.fxml"));
        Parent sampleParent = loaderr.load();
        Scene scene = new Scene(sampleParent);
        stage.setScene(scene);
    }
}
