package sample;
import DictionaryProgram.Dictionary;
import DictionaryProgram.DictionaryManagement;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import np.com.ngopal.control.AutoFillTextBox;

/**
 * Main class use to run appDictionary
 * @author Nguyen Huu Dat
 * @author Pham Duc Duy
 * @since 25/9/2018
 */

public class Main extends Application {

    /**
     * method start is overrided to run and load graphic sample.fxml
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Parent root = FXMLLoader.load(this.getClass().getResource("sample.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    /**
     * method main
     * @param args doesn't use
     * @return none
     */
    public static void main(String[] args)
    {
        launch(args);
    }
}
