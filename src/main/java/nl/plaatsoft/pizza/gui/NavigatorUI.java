package nl.plaatsoft.pizza.gui;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

import nl.plaatsoft.pizza.utils.Factory;

@Title("PlaatPizza")
@Theme("mytheme")
public class NavigatorUI extends UI {

	private static final long serialVersionUID = 1L;

	private Navigator navigator;
	
	public static final String HOME_VIEW = "home";	
	public static final String MAP_VIEW = "map";
	public static final String ABOUT_VIEW = "about";
	public static final String HELP_VIEW = "help";
	
	@Override
	protected void init(VaadinRequest request) {

		navigator = new Navigator(this, this);
		
		if (Factory.isLoginFlag()) {
			navigator.addView("", new LoginView(this) );
		} else {
			navigator.addView("", new HomeView(this) );
		}
		navigator.addView(HOME_VIEW, new HomeView(this) );
		navigator.addView(MAP_VIEW, new MapView(this) );
		navigator.addView(HELP_VIEW, new HelpView(this) );
		navigator.addView(ABOUT_VIEW, new AboutView(this) );	
	}
	
	public Navigator getNavigator() {
		return navigator;
	}

	public void setNavigator(Navigator navigator) {
		this.navigator = navigator;
	}

}
