package web_application.data_layer;
import java.sql.*;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	static Connection conn;
	static PreparedStatement ps;

	@Override
	public int insertEmployee(Employee e) {
		int status =0;
		try {
			conn = DatabaseConnector.getUsersCon();
			ps = conn.prepareStatement("Insert into user value(?,?)");
			ps.setString(1, e.getEmployeeName());
			ps.setInt(2, e.getEmployeeID());
			ps.setString(3, e.getPassword());
			status = ps.executeUpdate();
			
		}catch(Exception er) {
			er.printStackTrace();
		}
		return status;
	}

	@Override
	public Employee getEmployee(Integer employeeID, String password) {
		Employee e = new Employee();
		try {
			conn = DatabaseConnector.getUsersCon();
			ps = conn.prepareStatement("select * from employeerecord where employeeid=? and password=?");
			ps.setInt(1, employeeID);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				e.setEmployeeID(rs.getInt(1));
				e.setEmployeeName(rs.getString(2));
				e.setAccessLevel(rs.getInt(3));
				e.setPassword(rs.getString(4));
				e.setStoreID(rs.getInt(5));
			}
			
		}catch(Exception er) {
			er.printStackTrace();
		}
		return e;
	}

}
