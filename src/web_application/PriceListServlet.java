package web_application;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web_application.data_layer.*;

/**
 * Servlet implementation class PriceListServlet
 */
@WebServlet("/store/products")
public class PriceListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Integer store;
       

    public PriceListServlet() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {			
			doGet(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession(false);
			store = (Integer)session.getAttribute("storeid");
			session.removeAttribute("currentProduct");
			request.setAttribute("products", ProductPriceDAOImpl.getProducts(store));
			request.getRequestDispatcher("/priceList.jsp").forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
