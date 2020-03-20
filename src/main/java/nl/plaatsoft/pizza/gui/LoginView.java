package nl.plaatsoft.pizza.gui;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import nl.plaatsoft.pizza.component.MySubTitle;
import nl.plaatsoft.pizza.component.MyTitle;
import nl.plaatsoft.pizza.utils.Constants;

public class LoginView extends CustomComponent implements View {

	private static final long serialVersionUID = 1L;

	
    public LoginView(NavigatorUI navigator) {
    	
        HorizontalLayout layout1 = new HorizontalLayout();
        layout1.setSpacing(true);
        layout1.setMargin(false);
        
        layout1.addComponent(new MyTitle(Constants.APP_NAME));
                               
        // -----
        
        Panel panel = new Panel("Login");
        panel.setSizeUndefined();
              
        final FormLayout layout2 = new FormLayout();
        layout2.setMargin(true);
        layout2.setSpacing(true);
              
        final TextField username = new TextField();
        username.setCaption("Username:");
        
        final PasswordField password = new PasswordField();
        password.setCaption("Password:");
       
        Button button = new Button("Login");
        button.setIcon(VaadinIcons.SIGN_IN);
        button.addClickListener(e -> navigator.getNavigator().navigateTo(NavigatorUI.HOME_VIEW));
        
        layout2.addComponent(username);        
        layout2.addComponents(password);
        layout2.addComponents(button);
        
        panel.setContent(layout2);
        
        // -----
       
        VerticalLayout layout = new VerticalLayout();
        layout.setSpacing(false);
        layout.setMargin(true);
       
        layout.addComponent(layout1);
        layout.addComponent(panel);
        layout.addComponent(new MySubTitle(Constants.COPYRIGHT));
        
        setCompositionRoot(layout);
    }
}
