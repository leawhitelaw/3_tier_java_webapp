package web_application;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class SessionListener
 * Listener is solely for logging purposes, only catches two types of session related events (life cycle and attribute)
 * no URL mapping for listeners because they are container wide
 * Helps with debugging
 *
 */
@WebListener
public class SessionListener implements HttpSessionAttributeListener, HttpSessionListener {

    /**
     * Default constructor. 
     */
    public SessionListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  { 
    	System.out.println("A new session ID: " + arg0.getSession().getId() + " has been created by " + arg0.getSession().getServletContext().getContextPath());
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
    	System.out.println("Session ID: " + arg0.getSession().getId() + " has been destroyed by " + arg0.getSession().getServletContext().getContextPath());
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent arg0)  { 
    	System.out.println("Attribute: " + arg0.getName() + " has been added with value: " + arg0.getValue() + ".");
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent arg0)  { 
         System.out.println("Attribute: " + arg0.getName() + " has been removed.");
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent arg0)  { 
    	System.out.println("Attribute: " + arg0.getName() + " has been replaced with new value: " + arg0.getValue() + ".");
    }
	
}
