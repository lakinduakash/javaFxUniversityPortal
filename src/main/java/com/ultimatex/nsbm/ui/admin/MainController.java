package com.ultimatex.nsbm.ui.admin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.ultimatex.nsbm.model.Course;
import com.ultimatex.nsbm.model.crud.CourseCRUD;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.mongodb.morphia.Datastore;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    private Datastore datastore;

    @FXML
    private JFXComboBox<Label> courseComboBox;

    @FXML
    private JFXButton registerButton;

    @FXML
    private JFXTextField textFieldIndexNumber;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        CourseCRUD courseCRUD = new CourseCRUD();

        ArrayList<Label> labels = new ArrayList<>();

        for (Course c : courseCRUD.getAllCourse()) {

            labels.add(new Label(c.getName()));
        }

        courseComboBox.getItems().addAll(labels);

    }

    @FXML
    public void onSignOutButtonClicked(Event event) {

    }

    @FXML
    public void onRegisterButtonClicked(Event event) {

    }

    @FXML
    public void onEditButtonClicked(Event event) {

    }

    @FXML
    public void onSettingsButtonClick(Event event) {

    }


}