package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Cabinet Conseil ITA");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 597, 265));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
