package web_application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Finance Approval servlet displays the finance approval information.
 * Array with fake details added for prototype but in reality would be linked to the 
 * customer 'PurchaseHistory' database
 */
@WebServlet("/store/finance")
public class FinanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FinanceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// add fake data to show how prototype would work
		List<String> names = new ArrayList<String>();
		names.add("Name: James Walker. Age: 22 Request: £220 via enabling");
		names.add("Name: Calum Whitelaw. Age: 54 Request: £350 via enabling");
		names.add("Name: Serena Arif. Age: 45 Request: £600 via enabling");
		names.add("Name: Matt Vaughan. Age: 27 Request: £220 via enabling");
		names.add("Name: Gemma Russell. Age: 32 Request: £150 via enabling");
		request.setAttribute("names", names);
		request.getRequestDispatcher("/finance.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
