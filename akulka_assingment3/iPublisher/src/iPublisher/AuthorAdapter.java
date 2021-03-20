package iPublisher;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AuthorAdapter
{
    Connection connection;

    public AuthorAdapter(Connection conn, Boolean reset) throws SQLException {
        connection = conn;
        if(reset)
        {
            Statement stm = connection.createStatement();
            try
            {
                stm.execute("DROP TABLE Author");
            }
            catch(SQLException ex)
            {

            }
            finally
            {
                stm.execute("CREATE TABLE Author ("
                        + "AuthorName CHAR(15) NOT NULL PRIMARY KEY, "
                        + "IDNum INT" + ")");
            }
        }
    }

    public void insertAuthor(String authorName, int ID) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("INSERT INTO Author (AuthorName, IDNum) VALUES ('" + authorName + "', " + ID + ")");
    }

    public ObservableList<String> getAuthorList() throws SQLException {
        ObservableList<String> list = FXCollections.observableArrayList();
        ResultSet rs;

        // Create a Statement object
        Statement stmt = connection.createStatement();

        String sqlStatement = "SELECT * FROM Author";
        rs = stmt.executeQuery(sqlStatement);

        while (rs.next()) {
            list.add(rs.getInt("IDNum") + "-" + rs.getString("AuthorName"));
        }
        return list;
    }

}
