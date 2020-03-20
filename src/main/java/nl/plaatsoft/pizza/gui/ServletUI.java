package nl.plaatsoft.pizza.gui;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinServlet;

@WebServlet(urlPatterns = "/*", name = "ServletUI", asyncSupported = true)
@VaadinServletConfiguration(ui = NavigatorUI.class, productionMode = false)
public class ServletUI extends VaadinServlet {

	 private static final long serialVersionUID = 1L;
}
