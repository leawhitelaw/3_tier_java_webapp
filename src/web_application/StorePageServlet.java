package web_application;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import web_application.data_layer.EmployeeDAOImpl;

/**
 * Servlet implementation class StorePageServlet
 */
@WebServlet("/store")
public class StorePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StorePageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//get session details
			HttpSession session = request.getSession(false);
			Integer store = (Integer) session.getAttribute("storeid");
			String employeeID = (String) session.getAttribute("username");
			String pword = (String) session.getAttribute("password");
			Integer emplid = Integer.parseInt(employeeID);
			
			//create new employee object from DAO implementation
			EmployeeDAOImpl emplDAOImpl = new EmployeeDAOImpl();
			//Employee curEmployee = new Employee();
			request.setAttribute("employee", emplDAOImpl.getEmployee(emplid, pword));
			request.getRequestDispatcher("store.jsp").forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
