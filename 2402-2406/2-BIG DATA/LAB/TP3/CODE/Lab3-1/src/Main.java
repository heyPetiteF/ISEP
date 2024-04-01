import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class Main {
       public static void main(String[] args) throws SQLException {
           /* Load JDBC Driver. */
           try {
               Class.forName("org.postgresql.Driver");
           } catch (ClassNotFoundException e) {
               e.printStackTrace();
           }

           String url = "jdbc:postgresql://localhost/company";
           String user = "postgres";
           String pass = "123456";
           Connection connexion = null;
           Statement statement = null;

           try {
               connexion = DriverManager.getConnection(url, user, pass);
               /* Requests to bdd will be here */
               System.out.println("Bdd Connected");

               statement = connexion.createStatement();

               //displayDepartment(connexion);
               //moveDepartment(connexion,7369,30);
               displayTable("emp");
           }
           catch (SQLException e) {
               e.printStackTrace();
           }
           /*catch (IOException e){
               throw new RuntimeException(e);
           }*/
           finally {
               if (connexion != null)
                   try {
                       statement.close();
                   } catch (SQLException ignore) {
                       ignore.printStackTrace();
                   }
                   try {
                       connexion.close();
                   } catch (SQLException ignore) {
                       ignore.printStackTrace();
                   }
           }
       }
    public static void displayDepartment(Connection connexion) throws SQLException {
        Statement statement = connexion.createStatement();
        ResultSet resultat = statement.
                executeQuery( "SELECT deptno, dname, loc FROM dept" );
        while ( resultat.next() ) {
            int deptno = resultat.getInt( "deptno");
            String dname = resultat.getString( "dname" );
            String location = resultat.getString("loc");
            System.out.println("Department " + deptno + " is for "
                    + dname + " and located in " + location);
        }
        resultat.close();
    }

    public static void moveDepartment(Connection connection,int Emp, int Deptno) throws SQLException{
        String command = "UPDATE EMP set DEPTNO = ? WHERE EMPNO = ?";
        try(PreparedStatement updateEmp = connection.prepareStatement(command)){
            updateEmp.setInt(1,Deptno);
            updateEmp.setInt(2,Emp);
            updateEmp.execute();
            System.out.println("\nEmployee No. " + Emp + " has been moved to department " + Deptno);
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
    }

    public static void displayTable(String tableName) throws SQLException {
        String url = "jdbc:postgresql://localhost/company";
        String user = "postgres";
        String pass = "123456";

        String query = "SELECT * FROM ?"; //PreparedStatement

        try (Connection connection = DriverManager.getConnection(url, user, pass)) {
           try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery("SELECT * FROM " + tableName)) {
                        ResultSetMetaData metaData = resultSet.getMetaData();
                        int columnCount = metaData.getColumnCount();
        /* -----------------------------------PreparedStatement-----------------------------------
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, tableName);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    ResultSetMetaData metaData = resultSet.getMetaData();
                    int columnCount = metaData.getColumnCount();
         -----------------------------------PreparedStatement----------------------------------- */
                        for (int i = 1; i <= columnCount; i++) {
                            System.out.print(metaData.getColumnName(i) + "\t| ");
                        }
                        System.out.println();

                        while (resultSet.next()) {
                            for (int i = 1; i <= columnCount; i++) {
                                System.out.print(resultSet.getString(i) + "\t| ");
                            }
                            System.out.println();
                        }
                        resultSet.close();
                        statement.close();
                        /*catch (SQLException e){
                        e.printStackTrace();*/
                }
            }
        }
    }
}
