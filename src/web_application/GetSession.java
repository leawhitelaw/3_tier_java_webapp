package web_application;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GetSession
 * attempts to restore existing session instead of creating a new one
 * if session was found successfully - the servlet prints out username and password
 * attributes stored in the session, together with a link for the user to log out 
 * Otherwise the servlet displays error message to return to the login page
 */
@WebServlet("/GetSession")
public class GetSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetSession() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		try {
			response.setContentType("text/html");
			PrintWriter writer = response.getWriter();
			writer.println("<html><body>");
			if(session == null) {
				writer.println("<p>Sorry, you are not logged in.</p>");
				Cookie[] cookies = request.getCookies();
				if(cookies != null) {
					for(int i=0; i<cookies.length; i++) {
						Cookie cookie = cookies[i];
						if(cookie.getName().equals("username")) {
							writer.println("<p>However, it seems that " + cookie.getValue() + " was here before.</p>");
						}
					}
				}
				writer.println("<p><a href=\"login.html\">Return</a> to login.");
			}
			else {
				writer.println("<p>Thank you, you are already logged in.");
				writer.println("<p>Here is the data in your session:<p>");
				Enumeration names = session.getAttributeNames();
				while(names.hasMoreElements()) {
					String name = (String) names.nextElement();
					Object value = session.getAttribute(name);
					writer.println("<p>name= " + name + " value= " + value);
				}
				String newURL = response.encodeURL("LogoutServlet");
				writer.println("Click <a href=\"" + newURL + "\"here</a> to log out");
			}	
			writer.println("</body></html>");
			writer.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
