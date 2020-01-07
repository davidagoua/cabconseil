package sample;

import home.HomeController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML TextField txtUsername;
    @FXML TextField txtPassword;
    @FXML
    Button btnLogin;
    Stage primaryStage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void login(){
        String username = txtUsername.getText();
        String password = txtPassword.getText();
        System.out.println("Username:"+username+"\nPassword:"+password);
        getHomeController();
    }

    public void getHomeController(){
        primaryStage = (Stage) txtPassword.getScene().getWindow();
        primaryStage.setScene(new Scene(new HomeController(), 852, 600));
    }
}
