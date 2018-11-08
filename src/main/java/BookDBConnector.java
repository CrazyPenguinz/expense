import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class BookDBConnector implements Connectable{
    private static String myDriver = "org.sqlite.JDBC";
    private static String urlDB = "jdbc:sqlite:DB.db";

    private static final BookDBConnector instance = new BookDBConnector();

    static public BookDBConnector getInstance() {
        return instance;
    }

    private BookDBConnector() {}

    @Override
    public ObservableList<Information> viewHistory() {
        ObservableList<Information> informations = FXCollections.observableArrayList();
        try {
            Class.forName(myDriver);
            Connection connection = DriverManager.getConnection(urlDB);
            if (connection != null) {
                String query = "select * from Book";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    String type = resultSet.getString("Type");
                    String detail = resultSet.getString("Detail");
                    String money = resultSet.getString("Money");
                    informations.add(new Information(type, detail, money));
                }
                connection.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return informations;
    }

    @Override
    public void add(String type, String detail, String amount) {
        try {
            Class.forName(myDriver);
            Connection connection = DriverManager.getConnection(urlDB);
            if (connection != null) {
                String query = "insert into Book (Type, Detail, Money) values ('" + type + "' , '" + detail + "' , '" + amount + "')";
                PreparedStatement p = connection.prepareStatement(query);
                p.executeUpdate();
            }
            connection.close();
        }

        catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
