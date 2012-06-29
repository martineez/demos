package demo;

import com.vaadin.Application;
import com.vaadin.terminal.gwt.server.AbstractApplicationServlet;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public class VaadinAppServlet extends AbstractApplicationServlet {
	private static final long serialVersionUID = 9053326565519250877L;

	@Override
    protected Class<? extends Application> getApplicationClass() throws ClassNotFoundException {
        return VaadinApp.class;
    }

    @Override
    protected Application getNewApplication(HttpServletRequest request) throws ServletException {
        try {
            InitialContext ic = new InitialContext();
            return (Application) ic.lookup("java:module/VaadinApp");
        } catch (NamingException e) {
            throw new ServletException("Could not access application", e);
        }
    }
}