package demo;

import com.vaadin.Application;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import javax.ejb.EJB;
import javax.ejb.Remove;
import javax.ejb.Stateful;

@Stateful
public class VaadinApp extends Application {
	private static final long serialVersionUID = 1746998512578458398L;
	@EJB
    GreetingServiceBean greetingService;

    @Override
    public void init() {
        VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        Label header = new Label("My Vaadin Application");
        header.setStyleName("h1");
        layout.addComponent(header);

        final TextField nameField = new TextField("What is your name?");
        final Label greetingLbl = new Label();
        layout.addComponent(nameField);
        layout.addComponent(new Button("Say Hello", new Button.ClickListener() {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1071368733462518288L;

			public void buttonClick(ClickEvent event) {
                greetingLbl.setCaption(greetingService.sayHello(nameField.getValue().toString()));
            }
        }));
        layout.addComponent(greetingLbl);

        layout.addComponent(new Button("Close Application", new Button.ClickListener() {
            /**
			 * 
			 */
			private static final long serialVersionUID = 6949147796355233761L;

			public void buttonClick(ClickEvent event) {
                close();
            }
        }));

        Window mainWindow = new Window("My Vaadin Application", layout);
        setMainWindow(mainWindow);
    }

    @Override
    @Remove
    public void close() {
        super.close();
    }
}