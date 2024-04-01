import java.sql.Connection;

public class DAOFactory {
    private Connection connection;

    public DAOFactory(Connection connection) {
        this.connection = connection;
    }

    public DeptDAO getDeptDAO() {
        return new DeptDAO(connection);
    }

    public EmpDAO getEmpDAO() {
        return new EmpDAO(connection) {
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
    }

    public DeptDAO getdependentsDAO(){
        return new DeptDAO(connection);
    }

    public DAO getBonusDAO(){
        return new DeptDAO(connection);
    }
}
