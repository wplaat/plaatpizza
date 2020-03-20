package nl.plaatsoft.pizza.component;

import java.io.File;

import com.vaadin.server.FileResource;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.Image;

public class MyImage {

	public static Image getImage(String filename) {
		
		String basepath = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();
		FileResource resource = new FileResource(new File(basepath + "/WEB-INF/images/"+filename));
		
		return new Image("", resource);
	}
}
