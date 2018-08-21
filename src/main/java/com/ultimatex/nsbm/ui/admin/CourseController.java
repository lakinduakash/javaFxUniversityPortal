/**
 * Sample Skeleton for 'course_managment.fxml' Controller Class
 */

package com.ultimatex.nsbm.ui.admin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class CourseController implements Initializable {

    @FXML // fx:id="textFieldNewSubName"
    private JFXTextField textFieldNewSubName; // Value injected by FXMLLoader

    @FXML // fx:id="textFieldNewSubCode"
    private JFXTextField textFieldNewSubCode; // Value injected by FXMLLoader

    @FXML // fx:id="textFieldNewSubCredit"
    private JFXTextField textFieldNewSubCredit; // Value injected by FXMLLoader

    @FXML // fx:id="textFieldNewSubPrice"
    private JFXTextField textFieldNewSubPrice; // Value injected by FXMLLoader

    @FXML // fx:id="comboBoxNewHeadLec"
    private JFXComboBox<?> comboBoxNewHeadLec; // Value injected by FXMLLoader

    @FXML // fx:id="buttonAddNewSub"
    private JFXButton buttonAddNewSub; // Value injected by FXMLLoader

    @FXML // fx:id="comboBoxEditSubChoose"
    private JFXComboBox<?> comboBoxEditSubChoose; // Value injected by FXMLLoader

    @FXML // fx:id="textFieldEditSubName"
    private JFXTextField textFieldEditSubName; // Value injected by FXMLLoader

    @FXML // fx:id="textFieldEditSubCredit"
    private JFXTextField textFieldEditSubCredit; // Value injected by FXMLLoader

    @FXML // fx:id="textFieldEditSubPrice"
    private JFXTextField textFieldEditSubPrice; // Value injected by FXMLLoader

    @FXML // fx:id="radioNew"
    private HBox radioNew; // Value injected by FXMLLoader

    @FXML // fx:id="comboBoxEditCourse"
    private JFXComboBox<?> comboBoxEditCourse; // Value injected by FXMLLoader

    @FXML // fx:id="comboBoxEditSem"
    private JFXComboBox<?> comboBoxEditSem; // Value injected by FXMLLoader

    @FXML // fx:id="radioDelete"
    private RadioButton radioDelete; // Value injected by FXMLLoader

    @FXML // fx:id="g1"
    private ToggleGroup g1; // Value injected by FXMLLoader

    @FXML // fx:id="comboBoxEditCourseSubject"
    private JFXComboBox<?> comboBoxEditCourseSubject; // Value injected by FXMLLoader

    @FXML
    void onAddNewSelected(MouseEvent event) {

    }

    @FXML
    void onDeleteRadioSelected(ActionEvent event) {

    }

    @FXML
    void onEditCourseSaveButtonClicked(ActionEvent event) {

    }

    @FXML
    void onEditSubAddButtonClicked(MouseEvent event) {

    }

    @FXML
    void onEditSubRemoveButtonClicked(MouseEvent event) {

    }

    @FXML
    void onNewSubAddButtonClicked(ActionEvent event) {

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


    }
}
