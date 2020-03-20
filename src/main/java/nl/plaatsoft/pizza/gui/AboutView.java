package nl.plaatsoft.pizza.gui;

import com.vaadin.navigator.View;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

import nl.plaatsoft.pizza.component.MyBanner;
import nl.plaatsoft.pizza.component.MyFooter;
import nl.plaatsoft.pizza.component.MyTitle;

public class AboutView extends CustomComponent implements View {

	private static final long serialVersionUID = 1L;

	public AboutView(NavigatorUI navigator) {
		
	     Panel panel = new Panel("");
	     panel.setSizeFull();
	     	     
	     VerticalLayout layout2 = new VerticalLayout();
	     layout2.setSpacing(true);
	     layout2.setMargin(true);
	     	     
	     layout2.addComponent(new MyTitle("About"));
	     layout2.addComponent(new Label("bla bla bla"));

	     panel.setContent(layout2);
	     
	     //---
	     
	     VerticalLayout layout = new VerticalLayout();
	     layout.setSpacing(false);
	     layout.setMargin(true);
	     
	     MyBanner banner = new MyBanner(navigator.getNavigator());
	     
	     layout.addComponent(banner.getLayout());
         layout.addComponent(panel);
	     layout.addComponent(MyFooter.getFooter());
	        
	     setCompositionRoot(layout);
	}
}
