package web_application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web_application.data_layer.LoyaltyDeal;
import web_application.data_layer.LoyaltyDealDAOImpl;

/**
 * Servlet implementation class LoyaltyDealServlet
 */
@WebServlet("/store/loyalty")
public class LoyaltyDealServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoyaltyDealServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession(false);
			Integer store = (Integer)session.getAttribute("storeid");
			//get new deal attributes from form
			String prodid = request.getParameter("prodid");
			String dealname = request.getParameter("dealname");
			String points = request.getParameter("minpoints");
			
			//get instance of loyalty points DAO implementation
			LoyaltyDealDAOImpl loyaltyDAOImpl = new LoyaltyDealDAOImpl();
			
			if(prodid == "" || prodid == " " || dealname == "" || dealname == " " || points == "" || points == " ") {
				String nullParams = "yes";
				session.setAttribute("nullParams", nullParams);
				response.sendRedirect("/software_architecture_cw/store/loyalty");
			}
			else {
				//update productPrice info
				Integer productID = Integer.parseInt(prodid);
				Integer minPoints = Integer.parseInt(points);
				
				//LoyaltyDealDAOImpl loyaltyDAOImpl = new LoyaltyDealDAOImpl();
				List<LoyaltyDeal> loyaltyDeals = new ArrayList<LoyaltyDeal>();
				loyaltyDeals = LoyaltyDealDAOImpl.getProducts(store);
				Integer highestID = loyaltyDAOImpl.getMaxDealID(loyaltyDeals);
				loyaltyDAOImpl.insertDeal(store, productID, minPoints, dealname, highestID+1);
				response.sendRedirect("/software_architecture_cw/store/loyalty");
			}
			doGet(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession(false);
			Integer store = (Integer)session.getAttribute("storeid");
			session.removeAttribute("currentProduct");
			request.setAttribute("deals", LoyaltyDealDAOImpl.getProducts(store));
			
			request.setAttribute("nullParams", session.getAttribute("nullParams"));;
			request.getRequestDispatcher("/loyaltyDeals.jsp").forward(request, response);
			session.removeAttribute("nullParams");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
