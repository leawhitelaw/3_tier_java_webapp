package web_application;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AnalyticsServlet
 * This servlet displays the analytics reporting in the DE-Store 
 */
@WebServlet("/store/report")
public class AnalyticsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnalyticsServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//get store info from session
			HttpSession session = request.getSession(false);
			Integer store = (Integer) session.getAttribute("storeid");
			request.setAttribute("storeID", store);
			request.setAttribute("graph", "/img/analytics.png");
			request.getRequestDispatcher("/analytics.jsp").forward(request, response);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
