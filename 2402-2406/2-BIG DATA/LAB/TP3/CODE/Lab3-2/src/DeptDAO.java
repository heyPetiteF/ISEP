import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeptDAO extends DAO<Dept> {
public DeptDAO(Connection connexion){ super(connexion);}
    public Dept find(int id) {
        Dept dept = new Dept();
        try {
            PreparedStatement finddept = connect.prepareStatement("SELECT * FROM DEPT where DEPTNO = ?");
            finddept.setInt(1, id);
            ResultSet result = finddept.executeQuery();
            while (result.next()){
                dept.setDeptno(result.getInt("Deptno"));
                dept.setDname(result.getString("Dname"));
                dept.setLoc(result.getString("loc"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dept;
    }

    @Override
    public boolean create(Dept object) {
        return false;
    }

    @Override
    public boolean update(Dept object) {
        return false;
    }

    @Override
    public boolean delete(Dept object) {
        return false;
    }
}
