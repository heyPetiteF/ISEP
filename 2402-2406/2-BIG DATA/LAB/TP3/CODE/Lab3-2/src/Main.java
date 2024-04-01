
import java.sql.*;



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
            System.out.println("Bdd Connected");
            statement = connexion.createStatement();

            /*--------------------------------Exercice 10--------------------------------*/
            /*
            DAO<Dept> departmentDao = new DeptDAO(connexion);
            Dept dept20 = departmentDao.find(20);
            System.out.println(dept20); */

            /*--------------------------------Exercice 11--------------------------------*/
            /*
            Class.forName("org.postgresql.Driver");

            EmpDAO employeeDao = new EmpDAO(connexion) {
                @Override
                public boolean create(Emp object) {
                    return false;
                }
                @Override
                public boolean update(Emp object) {
                    return false;
                }
                @Override
                public boolean delete(Emp object) {
                    return false;
                }
            };
            Emp emp = employeeDao.find(20);
            System.out.println(emp);
        }
        catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
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
             */
        /*--------------------------------Exercice 12--------------------------------*/
            DAOFactory daoFactory = new DAOFactory(connexion);
            DAO<Dept> departmentDao = daoFactory.getDeptDAO();
            Dept dept20 = departmentDao.find(20);
            System.out.println(dept20);

            DAO<Emp> employeeDao = daoFactory.getEmpDAO();
            Emp emp = employeeDao.find(20);
            System.out.println(emp);
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection failure.");
        }
    }
}
