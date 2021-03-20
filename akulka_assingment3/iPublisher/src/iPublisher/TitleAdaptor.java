package iPublisher;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TitleAdaptor
{
    Connection connection;

    public TitleAdaptor(Connection conn, boolean reset) throws SQLException
    {
        connection = conn;
        if(reset)
        {
            Statement stmt = connection.createStatement();
            try
            {
                stmt.execute("DROP TABLE Title");
            }
            catch(SQLException ex)
            {

            }
            finally
            {
                stmt.execute("CREATE TABLE Title ("
                        + "ManagerName CHAR(15) NOT NULL PRIMARY KEY, "
                        + "NumOfType INT" + ")");
            }
        }
    }

    public void insertTitle(String titleName, int ID) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("INSERT INTO Title (AuthorName, IDNum) VALUES ('" + titleName + "', " + ID + ")");
    }

    public ObservableList<String> getAuthor() throws SQLException {
        ObservableList<String> list = FXCollections.observableArrayList();
        ResultSet rs;

        Statement stm = connection.createStatement();
        rs = stm.executeQuery("SELECT * FROM Author");

        while(rs.next())
        {
            list.add(rs.getString("ManagerName") + "-" +rs.getInt("NumOfType"));
        }

        return list;
    }
}
