package web_application.data_layer;

public class Employee {
	
	private Integer employeeID;
	private Integer AccessLevel;
	private String employeeName;
	private String password;
	
	public Integer getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}
	public Integer getAccessLevel() {
		return AccessLevel;
	}
	public void setAccessLevel(Integer accessLevel) {
		AccessLevel = accessLevel;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
