package web_application;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Cookie;
import web_application.data_layer.*;

/**
 * Servlet implementation class LoginServlet
 * this servlet is mapped to /LoginServlet URL pattern and handles login requests
 * it receives username and password values from the HTTPServletRequest object and 
 * attempts to store the info in a HttpSession object
 * if HttpSession doesn't exist it'll create a new one
 * generates dynamic HTML content including a hyperlink for the GetSession servlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public LoginServlet() {
        super();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//get username & password from client
    	String username = request.getParameter("username");
    	String password = request.getParameter("password");
    	
    	//set user in session cookies
    	HttpSession session = request.getSession(true);
    	session.setAttribute("username", username);
    	session.setAttribute("password", password);
    	Cookie username_cookie = new Cookie("username", username);
    	username_cookie.setMaxAge(60*10); //store cookie for 10 mins
    	response.addCookie(username_cookie);
    	
    	//get employee that just logged in
    	EmployeeDAO employeeData = new EmployeeDAOImpl();
    	Employee e = employeeData.getEmployee(Integer.parseInt(username), password);
    	
    
    	if(e!= null && e.getEmployeeID()!= null) {
    		// staff memeber - basic access (can view but cannot edit) own store
    		if(e.getAccessLevel() == 1) {
    			try {
    				session.setAttribute("accessLevel", 1);
    				request.setAttribute("storeid", e.getStoreID());
    				response.sendRedirect("/software_architecture_cw/store");
    				
    			}catch(Exception exc) {
    				exc.printStackTrace();
    			}
    		}
    		// manager - can access and edit own store
    		else if(e.getAccessLevel() == 2) {
    			try {
    				session.setAttribute("accessLevel", 2);
        			session.setAttribute("storeid", e.getStoreID());
        			response.sendRedirect("/software_architecture_cw/store");
    				
    			}catch(Exception exc) {
    				exc.printStackTrace();
    			}
    		}
    		// HQ staff - can veiw all stores as well as main warehouse
    		else if(e.getAccessLevel() == 3) {
    			try {
    				session.setAttribute("accessLevel", 3);
    				session.setAttribute("storeid", e.getStoreID());
        			response.sendRedirect("/software_architecture_cw/store");
    			}catch(Exception exc) {
    				exc.printStackTrace();
    			}
    		}
    		
    	}
    	// incorrect details / do not match database 
    	else {
    		System.out.println(e);
    		request.setAttribute("message", "Data not locate in db please try again");
    		request.getRequestDispatcher("login.jsp").forward(request, response);
    	}
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
}
