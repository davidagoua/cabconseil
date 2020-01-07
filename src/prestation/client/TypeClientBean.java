package prestation.client;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import libs.BeanBase;

import java.sql.SQLException;


public class TypeClientBean extends BeanBase {

    public ObservableList getAll(){
        ObservableList<TypeClient> typeClients = FXCollections.observableArrayList();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM typeclient");
            while(resultSet.next()){
                TypeClient typeClient = new TypeClient(resultSet.getInt("id"), resultSet.getString("label"));
                typeClients.add(typeClient);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typeClients;
    }

    public TypeClient getById(int id){
        TypeClient typeClient = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM typeclient WHERE id=?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                typeClient = new TypeClient(resultSet.getInt("id"), resultSet.getString("label"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typeClient;
    }

    public TypeClient getbyLabel(String label){
        TypeClient typeClient = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM typeclient WHERE label=?");
            preparedStatement.setString(1, label);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                typeClient = new TypeClient(resultSet.getInt("id"), resultSet.getString("label"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typeClient;
    }
}
