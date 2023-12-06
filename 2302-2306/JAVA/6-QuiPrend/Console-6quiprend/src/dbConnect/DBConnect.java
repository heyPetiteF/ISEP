package dbConnect;

import java.sql.*;

public class DBConnect {
    private Connection con;
    private static Statement st;
    private ResultSet rs;

    public DBConnect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/nimmt?characterEncoding=utf-8&rewriteBatchedStatement=true";
            String username = "root";
            String password = "";

            con = DriverManager.getConnection(url, username, password);
            st = con.createStatement();

        } catch (ClassNotFoundException ex) {
            System.out.println("Error: MySQL JDBC Driver not found");
            ex.printStackTrace();
        } catch (SQLException ex) {
            System.out.println("Error: Failed to connect to the database");
            ex.printStackTrace();
        }
    }

    public static void addDataToGameIndex(int gameID, int gameInterest, int turnID, int turnInterest) {
        try {
            String sql = "INSERT INTO gameindex (GameID, GameInterest, TurnID, TurnInterest) VALUES (" + gameID + "," + gameInterest + "," + turnID + "," + turnInterest + ")";
            st.executeUpdate(sql);
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
    }

    public static void addDataToPlayData(int gameID, int turnID, int playerID, int cardID, int success, int interest) {
        try {
            String sql = "INSERT INTO playdata (GameID, TurnID, PlayerID, CardID, Success, Interest) VALUES (" + gameID + "," + turnID + "," + playerID + "," + cardID + "," + success + "," + interest + ")";
            st.executeUpdate(sql);
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
    }

    public static void addDatatoFactData(int gameID, int turnID, String classifier, int value, String location) {
        try {
            String sql = "INSERT INTO factdata (GameID, TurnID, Classifier, Value, Location) VALUES (" + gameID + "," + turnID + "," + "'" + classifier + "'" + "," + value + "," + "'" + location + "'" + ")";
            st.executeUpdate(sql);
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
    }
}
