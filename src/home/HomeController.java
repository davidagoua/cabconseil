package home;

import prestation.client.ClientController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class HomeController extends BorderPane {

    @FXML BorderPane pane;

    public HomeController(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("home.fxml"));
        loader.setController(this);
        loader.setRoot(this);

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getClientController(){
        pane.setCenter(new ClientController());
    }
}
