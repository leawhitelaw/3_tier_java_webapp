package web_application;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import web_application.data_layer.StoreInventory;
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
			try {
				Integer id = Integer.parseInt((String)session.getAttribute("id"));
				Integer qty = Integer.parseInt((String) session.getAttribute("qty"));
				//check for request from remove stock servlet and display alert
				if( id != null && qty != null) {
					System.out.println("remove " + qty + " of item id: " + id + " from store");
					session.removeAttribute("id");
					session.removeAttribute("qty");
					
					//get item
					StoreInventoryDAOImpl sDAO = new StoreInventoryDAOImpl();
					StoreInventory lowStockItem = new StoreInventory();
					lowStockItem = sDAO.getProductStock(store, id);
					request.setAttribute("lowStockItem", lowStockItem);
					
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			
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
