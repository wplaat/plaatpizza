package nl.plaatsoft.pizza.component;

import com.vaadin.ui.Label;
import com.vaadin.ui.themes.ValoTheme;

public class MyTitle extends Label {

	private static final long serialVersionUID = 1L;

	public MyTitle(String title) {
		
		super();
		setValue(title);
		addStyleName(ValoTheme.LABEL_H2);
		setSizeFull();
	}
}
