package prestation.client;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;


public class ClientBean {

    private Connection connection = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;


    public ClientBean(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cabinet_test","root","");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public ObservableList getAll(){
        ObservableList clients = FXCollections.observableArrayList();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT client.*, typeclient.label as label FROM client JOIN typeclient ON client.id_typeclient=typeclient.id");
            while(resultSet.next()){
                ClientModel client = new ClientModel(
                        resultSet.getInt("id"),
                        resultSet.getString("nom"),
                        resultSet.getString("prenom"),
                        resultSet.getString("email"),
                        resultSet.getString("contact"),
                        resultSet.getString("label")
                        );
                clients.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    public void addClient(ClientModel client, int type){
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO client (nom, prenom, email, contact, id_typeclient) VALUES (?,?,?,?,?)");
            preparedStatement.setString(1, client.getNom());
            preparedStatement.setString(2, client.getPrenom());
            preparedStatement.setString(3, client.getEmail());
            preparedStatement.setString(4, client.getContact());
            preparedStatement.setInt(5, type);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
