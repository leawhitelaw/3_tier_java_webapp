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
 * Servlet implementation class StockDisplayServlet
 */
@WebServlet("/store/stock/item")
public class StockDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public StockDisplayServlet() {
        super();

    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//get session info and parameters
			HttpSession session = request.getSession(false);
			Integer store = (Integer) session.getAttribute("storeid");
			String id = request.getParameter("id");
			StoreInventoryDAOImpl storeDAOImpl = new StoreInventoryDAOImpl();
			
			if(id != null && id.length()>0) {
				//Get product using product ID
				Integer productid = Integer.parseInt(id);
				StoreInventory storeItem = new StoreInventory();
				storeItem = storeDAOImpl.getProductStock(store, productid);
				request.setAttribute("item", storeItem);
				System.out.println(storeItem.getProductName());
				System.out.println(storeItem.getProductID());
				request.setAttribute("nullParams", session.getAttribute("nullParams"));
				request.setAttribute("orderedQty", session.getAttribute("orderedQty"));
				request.getRequestDispatcher("/StockDisplay.jsp").forward(request, response);
				session.removeAttribute("nullParams");
				session.removeAttribute("orderedQty");
				
			}else {
				response.sendRedirect("/software_architecture_cw/store/stock");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//get session info
			HttpSession session = request.getSession(false);
			Integer store = (Integer) session.getAttribute("storeid");
			StoreInventory curStoreItem = (StoreInventory) session.getAttribute("currentItem");
			Integer productid = curStoreItem.getProductID();
			
			//create new product price implementation object
			StoreInventoryDAOImpl storeDAOImpl = new StoreInventoryDAOImpl();
			
			//get productPrice info from JSP 
			String newqty = request.getParameter("orderstock");
			
			//check that no fields are null
			if(newqty == null || newqty == "" || newqty == " " || Integer.parseInt(newqty) == 0) {
				String nullParams = "yes";
				session.setAttribute("nullParams", nullParams);
				response.sendRedirect("/software_architecture_cw/store/stock/item?id=" + productid);
			}
			else {
				//update productPrice info
				Integer quantity = Integer.parseInt(newqty);
				Integer curQuantity = curStoreItem.getQuantity();
				Integer updatedQuantity = quantity + curQuantity;
				storeDAOImpl.updateQuantity(store, productid, updatedQuantity);
				session.setAttribute("orderedQty", quantity);
				
				//redirect to same page
				response.sendRedirect("/software_architecture_cw/store/stock/item?id=" + productid);
			}
			
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
	}

}
