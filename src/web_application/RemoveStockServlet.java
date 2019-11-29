package web_application;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web_application.data_layer.StoreInventory;
import web_application.data_layer.StoreInventoryDAO;
import web_application.data_layer.StoreInventoryDAOImpl;

/**
 * Servlet implementation class RemoveStockServlet
 */
@WebServlet("/store/removestock")
public class RemoveStockServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveStockServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			HttpSession session = request.getSession(false);
			Integer store = (Integer)session.getAttribute("storeid");
			String id = request.getParameter("id");
			String qty = request.getParameter("qty");
			session.setAttribute("id", id);
			session.setAttribute("qty", qty);
			response.sendRedirect("/software_architecture_cw/store/stock");
			
			//get stock info on current item to remove stock
			Integer productid = Integer.parseInt(id);
			Integer removeQty = Integer.parseInt(qty);
			StoreInventoryDAOImpl sDAO = new StoreInventoryDAOImpl();
			StoreInventory lowStockItem = new StoreInventory();
			lowStockItem = sDAO.getProductStock(store, productid);
			Integer currentQty = lowStockItem.getQuantity();
			Integer newQty = currentQty - removeQty;
			
			//update stock
			sDAO.updateQuantity(store, productid, newQty);
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
