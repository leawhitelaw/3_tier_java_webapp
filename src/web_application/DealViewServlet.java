package web_application;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web_application.data_layer.LoyaltyDeal;
import web_application.data_layer.LoyaltyDealDAOImpl;
import web_application.data_layer.StoreInventory;
import web_application.data_layer.StoreInventoryDAOImpl;

/**
 * Servlet implementation class DealViewServlet
 */
@WebServlet("/store/loyalty/deal")
public class DealViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoyaltyDealDAOImpl loyaltyDAOImpl = new LoyaltyDealDAOImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DealViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//get session info and parameters
			HttpSession session = request.getSession(false);
			Integer store = (Integer) session.getAttribute("storeid");
			String prodid = request.getParameter("pid");
			String dealid = request.getParameter("did");
			
			
			
			if(prodid != null && prodid.length()>0 && dealid != null && dealid.length()>0) {
				//Get product using product ID
				Integer productid = Integer.parseInt(prodid);
				Integer dealID = Integer.parseInt(dealid);
				LoyaltyDeal loyaltyDeal = new LoyaltyDeal();
				loyaltyDeal = loyaltyDAOImpl.getDeal(productid, store, dealID);
				request.setAttribute("deal", loyaltyDeal);
				System.out.println(loyaltyDeal.getDealName());
				System.out.println(loyaltyDeal.getDealID());
				request.setAttribute("nullParams", session.getAttribute("nullParams"));
				request.setAttribute("orderedQty", session.getAttribute("orderedQty"));
				request.getRequestDispatcher("/dealView.jsp").forward(request, response);
				session.removeAttribute("nullParams");
				session.removeAttribute("orderedQty");
				
			}
			else {
				response.sendRedirect("/software_architecture_cw/store/loyalty");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			//get session info
			HttpSession session = request.getSession(false);
			Integer store = (Integer) session.getAttribute("storeid");
			LoyaltyDeal curDeal = (LoyaltyDeal) session.getAttribute("currentdeal");
			Integer productid = curDeal.getProductID();
			Integer DealId = curDeal.getDealID();
			
		
			//delete deal
			loyaltyDAOImpl.deleteDeal(productid, store, DealId);
			response.sendRedirect("/software_architecture_cw/store/loyalty");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
