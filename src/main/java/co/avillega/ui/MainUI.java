package co.avillega.ui;


import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.slider.SliderOrientation;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

@SpringUI
public class MainUI extends UI{


    private VerticalLayout root;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        setupLayout();
        addHeader();
        addControlSlider();
        addActionButtons();
    }




    private void setupLayout() {
        root = new VerticalLayout();
        root.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        setContent(root);
    }

    private void addHeader() {
        VerticalLayout headerLayout = new VerticalLayout();
        headerLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

        Label header = new Label("Automata");

        header.addStyleName(ValoTheme.LABEL_H1);
        Label subtitle = new Label("Control de la banda transportadora de la universidad Icesi");
        subtitle.addStyleName(ValoTheme.LABEL_H4);
        headerLayout.addComponents(header, subtitle);
        root.addComponent(headerLayout);
    }

    private void addControlSlider(){
        VerticalLayout controlLayout = new VerticalLayout();
        controlLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        Label label = new Label("0 m/s");
        label.addStyleName(ValoTheme.LABEL_H3);
        Slider control = new Slider(0, 10, 1);
        control.setCaption("Control");
        control.setWidth("50%");
        control.setOrientation(SliderOrientation.HORIZONTAL);
        control.addValueChangeListener(event -> {label.setValue(control.getValue()+" m/s");});
        controlLayout.addComponents(label);
        controlLayout.addComponentsAndExpand(control);
        root.addComponent(controlLayout);


    }

    private void addActionButtons() {

        //Todo add action buttons (Stop, start and emergency)
    }
}
