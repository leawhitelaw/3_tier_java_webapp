package web_application;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web_application.data_layer.StoreInventoryDAOImpl;

/**
 * Servlet implementation class StoreInventoryServlet
 */
@WebServlet("/store/stock")
public class StoreInventoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Integer store;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoreInventoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession(false);
			store = (Integer)session.getAttribute("storeid");
			session.removeAttribute("currentProduct");
			request.setAttribute("stock", StoreInventoryDAOImpl.getStock(store));
			System.out.println(StoreInventoryDAOImpl.getStock(store).get(0));
			request.getRequestDispatcher("/stockList.jsp").forward(request, response);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {		
			doGet(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
