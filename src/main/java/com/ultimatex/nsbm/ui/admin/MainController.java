package com.ultimatex.nsbm.ui.admin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDecorator;
import com.jfoenix.controls.JFXTextField;
import com.ultimatex.nsbm.GlobalState;
import com.ultimatex.nsbm.model.Course;
import com.ultimatex.nsbm.model.Student;
import com.ultimatex.nsbm.model.crud.CourseImpl;
import com.ultimatex.nsbm.model.crud.StudentImpl;
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

    /**************************************************************************
     *
     * Fields n
     *
     **************************************************************************/

    private Datastore datastore;

    @FXML
    private JFXComboBox<Label> courseComboBox;

    @FXML
    private JFXButton registerButton;

    @FXML
    private JFXTextField textFieldIndexNumber;




    @Override
    public void initialize(URL location, ResourceBundle resources) {

        CourseImpl courseCRUD = new CourseImpl();

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

        Course c = new CourseImpl().getCourseByName(l.getText());


        GlobalState.setSelectedCourse(c);
        GlobalState.setFromInsertAction(true);
        GlobalState.setSelectedStudent(null);

        loadMainStudentView("Register new student");




    }

    @FXML
    public void onEditButtonClicked(Event event) {

        String index=textFieldIndexNumber.getText().trim();
        StudentImpl impl=new StudentImpl();
        Student student=impl.getStudentByIndex(index);
        if(student !=null)
        {
            GlobalState.setSelectedStudent(student);
            GlobalState.setFromEditAction(true);
            GlobalState.setFromInsertAction(false);
            GlobalState.setSelectedCourse(student.getCourse());

            loadMainStudentView("Profile "+student.getIndexNumber());
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Invalid Index Number");
            alert.setHeaderText(null);
            alert.setContentText("PIndex number invalid or not found!");
            alert.show();
        }

    }

    @FXML
    public void onSettingsButtonClick(Event event) {

    }

    private void loadMainStudentView(String title)
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/student/main.fxml"));

        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }


        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setTitle(title);
        JFXDecorator decorator = new JFXDecorator(stage, fxmlLoader.getRoot());
        decorator.setCustomMaximize(true);
        Scene scene = new Scene(decorator);
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);

        stage.show();
    }


}
