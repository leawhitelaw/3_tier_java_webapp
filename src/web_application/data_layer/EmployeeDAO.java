package web_application.data_layer;

public interface EmployeeDAO {
	
	public int insertEmployee(Employee e);
	
	public Employee getEmployee(Integer employeeID, String password);

}
