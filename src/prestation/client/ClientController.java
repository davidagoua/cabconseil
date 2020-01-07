package prestation.client;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.util.Pair;


import java.io.IOException;

public class ClientController extends BorderPane {

    @FXML TableView<ClientModel> tableClient;
    @FXML TableColumn<ClientModel, String> colNom;
    @FXML TableColumn<ClientModel, String> colPrenom;
    @FXML TableColumn<ClientModel, String> colEmail;
    @FXML TableColumn<ClientModel, String> colContact;
    @FXML TableColumn<ClientModel, String> colType;
    @FXML TextField txtNom;
    @FXML TextField txtPrenom;
    @FXML TextField txtEmail;
    @FXML TextField txtContact;
    @FXML
    ChoiceBox<Pair<Integer, String>> txtType;
    @FXML Button btnAjouter;
    @FXML Button btnModifier;
    @FXML Button btnSuppr;

    ClientBean clientBean;
    TypeClientBean typeClientBean;

    public ClientController(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("client.fxml"));
        loader.setController(this);
        loader.setRoot(this);

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        clientBean = new ClientBean();
        typeClientBean = new TypeClientBean();
        setupTable();
    }

    public void setupTable(){
        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));

        setupItem();
    }

    public void setupItem(){
        System.out.println("Actualisation..;");
        tableClient.setItems(clientBean.getAll());
    }

    public void addClient(){
        ClientModel client = new ClientModel(
          txtNom.getText(),
          txtPrenom.getText(),
          txtEmail.getText(),
          txtContact.getText(),
          2
        );
        clientBean.addClient(client, 2);
        setupItem();
    }
}
