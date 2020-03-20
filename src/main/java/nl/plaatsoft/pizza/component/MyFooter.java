package nl.plaatsoft.pizza.component;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;

import nl.plaatsoft.pizza.utils.Constants;

public class MyFooter {
	
	public static GridLayout getFooter() {
		
		GridLayout layout = new GridLayout(2,1);
		layout.setSizeFull();
		
		HorizontalLayout layout2 = new HorizontalLayout();
		layout2.addComponent(new MySubTitle(Constants.APP_VERSION));
		
		HorizontalLayout layout3 = new HorizontalLayout();
		layout3.addComponent(new MySubTitle(Constants.COPYRIGHT));
		
		layout.addComponent(layout2);
		layout.setComponentAlignment(layout2, Alignment.TOP_LEFT);
		
		layout.addComponent(layout3);
		layout.setComponentAlignment(layout3, Alignment.TOP_RIGHT);
	
		return layout;		
	}
}
