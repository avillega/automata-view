package co.avillega.ui;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.shared.ui.slider.SliderOrientation;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Created by Andres Villegas on 2017-04-03.
 */
@UIScope
@SpringUI
public class ControlPanel extends VerticalLayout implements View {

    public ControlPanel() {
        this.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

        addHeader();
        addControlSlider();
        addActionButtons();


    }

    private void addHeader() {
        VerticalLayout headerLayout = new VerticalLayout();
        headerLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

        Label header = new Label("Automata");
        header.addStyleName(ValoTheme.LABEL_H1);
        header.addStyleName(ValoTheme.LABEL_NO_MARGIN);

        Label subtitle = new Label("Control de la banda transportadora de la universidad Icesi");
        subtitle.addStyleName(ValoTheme.LABEL_H4);

        headerLayout.addComponents(header, subtitle);
        this.addComponent(headerLayout);
    }

    private void addControlSlider() {
        VerticalLayout controlLayout = new VerticalLayout();
        controlLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

        Label label = new Label("0 m/s");
        label.addStyleName(ValoTheme.LABEL_H3);

        Slider control = new Slider(0, 10, 1);
        control.setCaption("Control");
        control.setWidth("50%");
        control.setOrientation(SliderOrientation.HORIZONTAL);
        control.addValueChangeListener(event -> {
            label.setValue(control.getValue() + " m/s");

        });

        controlLayout.addComponents(label);
        controlLayout.addComponentsAndExpand(control);
        this.addComponent(controlLayout);
    }


    private void addActionButtons() {
        HorizontalLayout actionLayout = new HorizontalLayout();


        Button startBtn = new Button("Start");
        startBtn.setIcon(VaadinIcons.PLAY);
        startBtn.addStyleName(ValoTheme.BUTTON_FRIENDLY);

        Button stopBtn = new Button("Stop");
        stopBtn.setIcon(VaadinIcons.STOP);
        stopBtn.addStyleName(ValoTheme.BUTTON_PRIMARY);

        Button emergencyBtn = new Button("Emergency");
        emergencyBtn.setIcon(VaadinIcons.WARNING);
        emergencyBtn.addStyleName(ValoTheme.BUTTON_DANGER);
        actionLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        actionLayout.setWidth("50%");
        actionLayout.addComponentsAndExpand(startBtn, stopBtn, emergencyBtn);


        this.addComponent(actionLayout);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        System.out.println("Entered Control");
    }
}
