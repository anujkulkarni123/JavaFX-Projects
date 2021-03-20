package TennisBallGames;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Abdelkader
 */
public class MatchesAdapter {

    Connection connection;

    public MatchesAdapter(Connection conn, Boolean reset) throws SQLException {
        connection = conn;
        if (reset) {
            Statement stmt = connection.createStatement();
            try {
                // Remove tables if database tables have been created.
            // This will throw an exception if the tables do not exist
            stmt.execute("DROP TABLE Matches");
                // then do finally
            } catch (SQLException ex) {
                // No need to report an error.
                // The table simply did not exist.
                // do finally to create it
            } finally {
                // Create the table of Matches
                stmt.execute("CREATE TABLE Matches ("
                        + "MatchNumber INT NOT NULL PRIMARY KEY, "
                        + "HomeTeam CHAR(15) NOT NULL REFERENCES Teams (TeamName), "
                        + "VisitorTeam CHAR(15) NOT NULL REFERENCES Teams (TeamName), "
                        + "HomeTeamScore INT, "
                        + "VisitorTeamScore INT "
                        + ")");
                populateSamples();
            }
        }
    }
    
    private void populateSamples() throws SQLException{
            // Create a listing of the matches to be played
            this.insertMatch(1, "Astros", "Brewers");
            this.insertMatch(2, "Brewers", "Cubs");
            this.insertMatch(3, "Cubs", "Astros");
    }
        
    
    public int getMax() throws SQLException {
        int num = 0;

        // Add your work code here for Task #3
        ResultSet set = connection.createStatement().executeQuery("SELECT MAX(MatchNumber) FROM Matches");
        if (set.next()) {
            num = set.getInt(1)+1;
        }
        
        return num;
    }
    
    public void insertMatch(int num, String home, String visitor) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("INSERT INTO Matches (MatchNumber, HomeTeam, VisitorTeam, HomeTeamScore, VisitorTeamScore) "
                + "VALUES (" + num + " , '" + home + "' , '" + visitor + "', 0, 0)");
    }
    
    // Get all Matches
    public ObservableList<Matches> getMatchesList() throws SQLException {
        ObservableList<Matches> matchesList = FXCollections.observableArrayList();

        // Selected all elements in column Matches, and executing the query
        Statement statement = connection.createStatement();
        ResultSet set = statement.executeQuery("SELECT * FROM Matches");

        //Validation loop
        while(set.next())   {
            matchesList.add(new Matches(set.getInt(1), set.getString(2), set.getString(3),
                    set.getInt(4), set.getInt(5)));
        }

        return matchesList;
    }

    // Get a String list of matches to populate the ComboBox used in Task #4.
    public ObservableList<String> getMatchesNamesList() throws SQLException {
        ObservableList<String> list = FXCollections.observableArrayList();
        ResultSet rs;
        
        // Create a Statement object
        Statement statement = connection.createStatement();

        // Create a string with a SELECT statement
        String command = "SELECT * FROM Matches";



        // Execute the statement and return the result
        rs = statement.executeQuery(command);
        
        // Loop the entire rows of rs and set the string values of list
        while (rs.next()) {
            list.add(rs.getString(1) + "-"+rs.getString(2) + "-" + rs.getString(3));
        }
        
        return list;
    }
    
    
    public void setTeamsScore(int matchNumber, int hScore, int vScore) throws SQLException
   {
       // Add your code here for Task #4
       connection.createStatement().executeUpdate("UPDATE Matches SET HomeTeamScore = " + hScore + ", VisitorTeamScore = "+ vScore + " WHERE MatchNumber = " + matchNumber);
   }

}
