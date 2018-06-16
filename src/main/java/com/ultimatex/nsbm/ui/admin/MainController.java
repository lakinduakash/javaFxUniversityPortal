package com.ultimatex.nsbm.ui.admin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDecorator;
import com.jfoenix.controls.JFXTextField;
import com.ultimatex.nsbm.GlobalState;
import com.ultimatex.nsbm.model.Course;
import com.ultimatex.nsbm.model.crud.CourseImp;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.mongodb.morphia.Datastore;

import java.io.IOException;
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

        CourseImp courseCRUD = new CourseImp();

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

        Label l = courseComboBox.getValue();
        if (l == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Please select a course");
            alert.setHeaderText(null);
            alert.setContentText("Please select a course to continue");
            alert.show();
            return;
        }

        Course c = CourseImp.getCourseByName(l.getText());


        GlobalState.setSelectedCourse(c);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/student/main.fxml"));

        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }


        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("Register new student");
        JFXDecorator decorator = new JFXDecorator(stage, fxmlLoader.getRoot());
        decorator.setCustomMaximize(true);
        Scene scene = new Scene(decorator);
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);

        stage.show();



    }

    @FXML
    public void onEditButtonClicked(Event event) {

    }

    @FXML
    public void onSettingsButtonClick(Event event) {

    }


}