import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class EmpDAO extends DAO<Emp> {
    public EmpDAO(Connection connexion) {
        super(connexion);
    }

    @Override
    public Emp find(int id) {
        Emp emp = null;
        try {
            PreparedStatement findEmp = connect.prepareStatement(
                    "SELECT * FROM EMP WHERE EMPNO = ?"
            );
            findEmp.setInt(1, id);
            ResultSet result = findEmp.executeQuery();
            if (result.next()) {
                emp = new Emp();
                emp.setEmpNo((long) result.getInt("empNo"));
                emp.setEname(result.getString("ename"));

                int mgrId = result.getInt("mgr");
                if (mgrId != 0) {
                    emp.setMgr(find(mgrId)); // 递归调用，设置经理
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return emp;
    }
}
