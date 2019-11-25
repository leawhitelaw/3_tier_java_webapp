package web_application;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponseWrapper;

//import org.apache.catalina.filters.AddDefaultCharsetFilter.ResponseWrapper;

/**
 * Servlet Filter implementation class MyFilter
 * '/*' means that it this filter will apply to all servlets 
 * The filter does not change any content of incoming requests - simply logs what has happened. You can see it's output in the eclipse console.
 * The Filter attempts to change the content of an outgoing response, only if it seems to be an HTML page. (Currently it applies a copyright 
 * statement to the end of the page but you can do something cooler like replace swear words with ***)
 */
@WebFilter("/*")
public class MyFilter implements Filter {

    /**
     * Default constructor. 
     */
//    public MyFilter() {
//        // TODO Auto-generated constructor stub
//    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("Processed incoming request for " + ((HttpServletRequest)request).getServletPath());
		PrintWriter out = response.getWriter();
		ResponseWrapper wrapper = new ResponseWrapper((HttpServletResponse)response);
		
		try {
			chain.doFilter(request, wrapper);
			if(wrapper.getContentType().contains("text/html")) {
				out.write(wrapper.toString().replace("</body></html>", "<p>&copy; 2013 Edinburgh Napier University??</body></html>"));
				System.out.println("Processed outgoing response.");
			}
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		
		// pass the request along the filter chain
		
	}
	

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

class ResponseWrapper extends HttpServletResponseWrapper {
	private StringWriter output;
	public ResponseWrapper(HttpServletResponse response) {
		super(response);
		output = new StringWriter();
	}
	
	@Override
	public PrintWriter getWriter() {
		return new PrintWriter(output);
	}
	
	@Override
	public String toString() {
		return output.toString();
	}
}
