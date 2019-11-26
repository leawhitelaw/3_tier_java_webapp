package web_application;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	EmployeeDAO employeeData = new EmployeeDAOImpl();
    	String username = request.getParameter("username");
    	String password = request.getParameter("password");
    	HttpSession session = request.getSession(true);  
    	
    	session.setAttribute("username", username);
    	session.setAttribute("password", password);
    	Cookie username_cookie = new Cookie("username", username);
    	username_cookie.setMaxAge(60*10); //store cookie for 10 mins
    	response.addCookie(username_cookie);
 
    	Employee e = employeeData.getEmployee(Integer.parseInt(username), password);
    	if(e!= null && e.getEmployeeID()!= null) {
    		if(e.getAccessLevel() == 1) {
    			request.setAttribute("message", e.getEmployeeName());
        		request.getRequestDispatcher("analytics.jsp").forward(request, response);
    		}
    		else if(e.getAccessLevel() == 2) {
    			response.sendRedirect("priceList");
    		}
    		else if(e.getAccessLevel() == 3) {
    			request.setAttribute("message", e.getEmployeeName());
        		request.getRequestDispatcher("warehouse.jsp").forward(request, response);
    		}
    		
    	}else {
    		System.out.println(e);
    		request.setAttribute("message", "Data not locate in db please try again");
    		request.getRequestDispatcher("login.jsp").forward(request, response);
    	}
//    	try {
//    		response.setContentType("text/html");
//    		PrintWriter writer = response.getWriter();
//    		writer.println("<html><body>");
//    		writer.println("<p>Thank you, " + username + ". You are now logges into the system. </p>");
//    		String newURL = response.encodeURL("GetSession");
//    		writer.println("Click <a href=\"" + newURL + "\">here</a> for another Servlet");
//    		writer.println("</body></html>");
//    		writer.close();
//    	}
//    	catch(Exception e){
//    		e.printStackTrace();
//    	}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
}
