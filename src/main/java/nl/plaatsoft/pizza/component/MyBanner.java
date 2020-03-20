package nl.plaatsoft.pizza.component;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.Navigator;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.MenuItem;

import nl.plaatsoft.pizza.gui.NavigatorUI;
import nl.plaatsoft.pizza.utils.Constants;

public class MyBanner {
	
	private Navigator navigator;
	
	public MyBanner(Navigator navigator) {
		this.navigator = navigator;		
	}
		
	public GridLayout getLayout() {
			
		GridLayout layout = new GridLayout(2,1);
		layout.setSizeFull();
						
		MenuBar.Command homeCommand = new MenuBar.Command() {
			
			private static final long serialVersionUID = 1L;

			public void menuSelected(MenuItem selectedItem) {
				navigator.navigateTo(NavigatorUI.HOME_VIEW);
			}			
		};
		
		MenuBar.Command mapCommand = new MenuBar.Command() {
			
			private static final long serialVersionUID = 1L;

			public void menuSelected(MenuItem selectedItem) {
				navigator.navigateTo(NavigatorUI.MAP_VIEW);
			}			
		};
		
		MenuBar.Command helpCommand = new MenuBar.Command() {
			
			private static final long serialVersionUID = 1L;

			public void menuSelected(MenuItem selectedItem) {
				navigator.navigateTo(NavigatorUI.HELP_VIEW);
			}			
		};
		
		MenuBar.Command aboutCommand = new MenuBar.Command() {
			
			private static final long serialVersionUID = 1L;

			public void menuSelected(MenuItem selectedItem) {
				navigator.navigateTo(NavigatorUI.ABOUT_VIEW);
			}			
		};
		
		MenuBar menu = new MenuBar();
		menu.addItem("Home", VaadinIcons.HOME, homeCommand);
		menu.addItem("Map", VaadinIcons.SITEMAP, mapCommand);
		menu.addItem("Help", VaadinIcons.INFO, helpCommand);
		menu.addItem("About", VaadinIcons.ALARM, aboutCommand);
				
		HorizontalLayout layout2 = new HorizontalLayout();
		layout2.addComponent(menu);
		
		HorizontalLayout layout3 = new HorizontalLayout();
		layout3.addComponent(new MySubTitle(Constants.USERNAME));
		
		layout.addComponent(layout2);
		layout.setComponentAlignment(layout2, Alignment.TOP_LEFT);
		
		layout.addComponent(layout3);
		layout.setComponentAlignment(layout3, Alignment.TOP_RIGHT);
	
		return layout;		
	}
}
