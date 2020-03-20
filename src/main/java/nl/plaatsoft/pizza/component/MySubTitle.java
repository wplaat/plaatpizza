package nl.plaatsoft.pizza.component;

import com.vaadin.ui.Label;
import com.vaadin.ui.themes.ValoTheme;

public class MySubTitle extends Label {

	private static final long serialVersionUID = 1L;

	public MySubTitle(String title) {
		
		super();
		setValue(title);
		addStyleName(ValoTheme.LABEL_SMALL);
		setSizeFull();
	}
}
