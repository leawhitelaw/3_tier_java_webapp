package web_application;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import web_application.data_layer.*;

/**
 * Servlet implementation class PriceListServlet
 */
@WebServlet("/priceList")
public class PriceListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
//    public PriceListServlet() {
//        super();
        // TODO Auto-generated constructor stub
//    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("products", ProductPriceDAOImpl.getProductPrices());
		System.out.println(ProductPriceDAOImpl.getProductPrices());
		request.getRequestDispatcher("priceList.jsp").forward(request, response);
	}

}
