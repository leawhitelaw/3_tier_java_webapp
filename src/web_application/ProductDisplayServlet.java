package web_application;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web_application.data_layer.ProductPrice;
import web_application.data_layer.ProductPriceDAOImpl;

/**
 * Servlet for an individual product, gets product ID from URL params
 */
@WebServlet("/store/products/product")
public class ProductDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDisplayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//get session info and parameters
			HttpSession session = request.getSession(false);
			Integer store = (Integer) session.getAttribute("storeid");
			String id = request.getParameter("id");
			ProductPriceDAOImpl ppDAOImpl = new ProductPriceDAOImpl();
			
			if(id != null && id.length()>0) {
				Integer productid = Integer.parseInt(id);
				System.out.println("PRODUCT ID:::: " + productid);
				//Get product using product ID
				ProductPrice pp = new ProductPrice();
				pp = ppDAOImpl.getProductPrice(productid, store);
				request.setAttribute("product", pp);
				request.setAttribute("nullParams", session.getAttribute("nullParams"));
				request.setAttribute("orderedQty", session.getAttribute("orderedQty"));
				request.getRequestDispatcher("/productDisplay.jsp").forward(request, response);
				session.removeAttribute("nullParams");
				session.removeAttribute("updatedPrice");
			}else {
				response.sendRedirect("/software_architecture_cw/store/products");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//get session info
			HttpSession session = request.getSession(false);
			ProductPrice pp = (ProductPrice) session.getAttribute("currentProduct");
			Integer productid = pp.getProductID();
			
			//create new product price implementation object
			ProductPriceDAOImpl ppDAOImpl = new ProductPriceDAOImpl();
			
			//get productPrice info from JSP 
			String price = request.getParameter("newprice");
			String deal = request.getParameter("deal");
			
			//check that no fields are null
			if(price == "" || price == " " || deal == "" || deal == " " || price == null || deal == null) {
				String nullParams = "yes";
				session.setAttribute("nullParams", nullParams);
				response.sendRedirect("/software_architecture_cw/store/products/product?id=" + productid);
			}
			else {
				//update productPrice info
				Integer newprice = Integer.parseInt(price);
				ppDAOImpl.updateProductPrice(pp, newprice, deal);
				session.setAttribute("updatedPrice", newprice);
				//redirect to same page
				response.sendRedirect("/software_architecture_cw/store/products/product?id=" + productid);
			}
			
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
	}

}
