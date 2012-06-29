package demo;

import com.vaadin.Application;
import com.vaadin.terminal.gwt.server.AbstractApplicationServlet;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

@WebServlet(urlPatterns = "/*") // no need servlet definition in web.xml
public class VaadinAppCDIServlet extends AbstractApplicationServlet {
	private static final long serialVersionUID = -4388639993223135764L;
	@Inject
    VaadinApp application;

    @Override
    protected Class<? extends Application> getApplicationClass() throws ClassNotFoundException {
        return VaadinApp.class;
    }

    @Override
    protected Application getNewApplication(HttpServletRequest request) throws ServletException {
        return application;
    }    
}