/**
 * Sample Skeleton for 'lecturer_management.fxml' Controller Class
 */

package com.ultimatex.nsbm.ui.admin;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.ultimatex.nsbm.model.Course;
import com.ultimatex.nsbm.model.Lecture;
import com.ultimatex.nsbm.model.crud.CourseImpl;
import com.ultimatex.nsbm.model.crud.LecturerImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LecturerManagementController implements Initializable {

    @FXML // fx:id="textFieldID"
    private JFXTextField textFieldID; // Value injected by FXMLLoader

    @FXML // fx:id="textFieldName"
    private JFXTextField textFieldName; // Value injected by FXMLLoader

    @FXML // fx:id="comboBoxSelectNewType"
    private JFXComboBox<Label> comboBoxSelectNewType; // Value injected by FXMLLoader

    @FXML // fx:id="comboBoxNewDept"
    private JFXComboBox<Label> comboBoxNewDept; // Value injected by FXMLLoader

    @FXML // fx:id="comboBoxSelectLec"
    private JFXComboBox<Label> comboBoxSelectLec; // Value injected by FXMLLoader

    @FXML // fx:id="comboBoxSelectType"
    private JFXComboBox<Label> comboBoxSelectType; // Value injected by FXMLLoader

    @FXML // fx:id="comboBoxSelectDept"
    private JFXComboBox<Label> comboBoxSelectDept; // Value injected by FXMLLoader

    @FXML
    void onAddNewLecturer(ActionEvent event) {

        Lecture lecture=new Lecture();
        lecture.setEmpId(textFieldID.getText().trim());
        lecture.setName(textFieldName.getText().trim());
        lecture.setType(comboBoxSelectNewType.getValue().getText());
        lecture.setDept(comboBoxNewDept.getValue().getText());

        if(new LecturerImpl().insert(lecture))
        {
            Alert a=new Alert(Alert.AlertType.INFORMATION);
            a.setHeaderText("Success");
            a.setContentText("Lecturer Added");
            a.show();
        }
        else
        {
            Alert a=new Alert(Alert.AlertType.INFORMATION);
            a.setHeaderText("Failed");
            a.setContentText("Error");
            a.show();
        }



    }

    @FXML
    void onRemoveLec(ActionEvent event) {

    }

    @FXML
    void onSaveEdit(ActionEvent event) {

    }

    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     * @param location  The location used to resolve relative paths for the root object, or
     *                  <tt>null</tt> if the location is not known.
     * @param resources The resources used to localize the root object, or <tt>null</tt> if
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboBoxSelectNewType.getItems().add(new Label(Lecture.TYPE_INS));
        comboBoxSelectNewType.getItems().add(new Label(Lecture.TYPE_LEC));

        initSelectCourseComboBox();
        initEditLecComboBox();


    }

    private void initSelectCourseComboBox()
    {
        comboBoxNewDept.getItems().clear();
        ArrayList<Course> ac=new CourseImpl().getAllCourse();

        for(Course c:ac)
        {
            javafx.scene.control.Label l=new javafx.scene.control.Label(c.getName());
            l.setUserData(c);
            comboBoxNewDept.getItems().add(l);
        }
    }

    private void initEditLecComboBox() {
        comboBoxSelectLec.getItems().clear();
        ArrayList<Lecture> ac = new LecturerImpl().find("", null);

        for (Lecture c : ac) {
            javafx.scene.control.Label l = new javafx.scene.control.Label(c.getName());
            l.setUserData(c);
            comboBoxSelectLec.getItems().add(l);
        }
    }
}
