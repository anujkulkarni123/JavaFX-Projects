package iPublisher;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PublisherUnitAdapter
{
    Connection connection;

    public PublisherUnitAdapter(Connection conn, Boolean reset) throws SQLException {
        connection = conn;
        if(reset)
        {
            Statement stmt = connection.createStatement();
            try
            {
                stmt.execute("DROP TABLE PublisherUnit");
            }
            catch(SQLException ex)
            {

            }
            finally
            {
                stmt.execute("CREATE TABLE PublisherUnit ("
                        + "Name CHAR(15) NOT NULL PRIMARY KEY, "
                        + "Address CHAR(15) , "
                        + "IDNum INT" + ")");
            }
        }
    }

    public void insertPublisherUnit(String publisherName, String addressName, int id) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("INSERT INTO PublisherUnit (Name, Address, IDNum) VALUES ('" + publisherName + "', '" + addressName + "', " + id + ")");
    }

    //Populate the combo box
    public ObservableList<String> getPublisherUnitList() throws SQLException {
        ObservableList<String> list = FXCollections.observableArrayList();
        ResultSet rs;

        Statement stmt = connection.createStatement();
        String sqlStatement = "SELECT * FROM PublisherUnit";
        rs = stmt.executeQuery(sqlStatement);

        while (rs.next()) {
            list.add(rs.getInt("IDNum") + "-" + rs.getString("Name") + "-" + rs.getString("Address"));
        }
        return list;
    }

    public void updatePublisherUnit(int id, String name, String address) throws SQLException
    {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("UPDATE PublisherUnit (Name, Address, IDNum) SET publisherName ='" + name + "', Address = '" + address + "' WHERE IDNum =" + id);
    }
}
