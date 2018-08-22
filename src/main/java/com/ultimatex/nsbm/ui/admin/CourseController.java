/**
 * Sample Skeleton for 'course_management.fxml' Controller Class
 */

package com.ultimatex.nsbm.ui.admin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import com.ultimatex.nsbm.model.Subject;
import com.ultimatex.nsbm.model.crud.SubjectImpl;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import org.bson.types.ObjectId;

import java.net.URL;
import java.util.ArrayList;
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
    private JFXComboBox<Label> comboBoxEditSubChoose; // Value injected by FXMLLoader

    @FXML // fx:id="textFieldEditSubName"
    private JFXTextField textFieldEditSubName; // Value injected by FXMLLoader

    @FXML // fx:id="textFieldEditSubCredit"
    private JFXTextField textFieldEditSubCredit; // Value injected by FXMLLoader

    @FXML // fx:id="textFieldEditSubPrice"
    private JFXTextField textFieldEditSubPrice; // Value injected by FXMLLoader

    @FXML // fx:id="comboBoxEditCourse"
    private JFXComboBox<Label> comboBoxEditCourse; // Value injected by FXMLLoader

    @FXML // fx:id="comboBoxEditSem"
    private JFXComboBox<Label> comboBoxEditSem; // Value injected by FXMLLoader

    @FXML // fx:id="radioDelete"
    private JFXRadioButton radioDelete; // Value injected by FXMLLoader

    @FXML // fx:id="g1"
    private ToggleGroup g1; // Value injected by FXMLLoader

    @FXML // fx:id="radioAddNew"
    private JFXRadioButton radioAddNew; // Value injected by FXMLLoader

    @FXML // fx:id="comboBoxEditCourseSubject"
    private JFXComboBox<Label> comboBoxEditCourseSubject; // Value injected by FXMLLoader

    @FXML
    void onAddNewRadioClicked(ActionEvent event) {

    }

    @FXML
    void onDeleteRadioSelected(ActionEvent event) {

    }

    @FXML
    void onEditCourseSaveButtonClicked(ActionEvent event) {

    }

    @FXML
    void onEditSubAddButtonClicked(ActionEvent event) {

        if (comboBoxEditSubChoose.getValue() != null) {

            Subject s = new SubjectImpl().findById((ObjectId) comboBoxEditSubChoose.getValue().getUserData());
            s.setPrice(Integer.parseInt(textFieldEditSubPrice.getText()));
            s.setName(textFieldEditSubName.getText());
            s.setCredit(Integer.parseInt(textFieldEditSubCredit.getText()));

            if (new SubjectImpl().update(s)) {
                showAlert("Success", "Subject updated");
                initEditSubjectComboBox();

            } else
                showAlert("Failed", "Error");


        }

    }

    @FXML
    void onEditSubRemoveButtonClicked(ActionEvent event) {

        if (comboBoxEditSubChoose.getValue() != null) {
            ObjectId id = (ObjectId) comboBoxEditSubChoose.getValue().getUserData();
            System.out.println(id);
            if (new SubjectImpl().delete(id)) {
                comboBoxEditSubChoose.getItems().removeAll();
                initEditSubjectComboBox();
                showAlert("Success", "Subject deleted");

            } else
                showAlert("Failed", "Error");


        }
    }

    @FXML
    void onNewSubAddButtonClicked(ActionEvent event) {

        Subject s = new Subject(textFieldNewSubName.getText().trim(), textFieldNewSubCode.getText().trim(),
                Integer.parseInt(textFieldNewSubPrice.getText().trim()), Integer.parseInt(textFieldNewSubCredit.getText()));
        SubjectImpl si = new SubjectImpl();
        if (si.insert(s)) {
            showAlert("Success", "Subject Saved");
            initEditSubjectComboBox();
        }
        else
            showAlert("Error", "Some Error occurred");
        clearAddNewSubTextFields();



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
        setTextFieldNumericOnly(textFieldEditSubCredit);
        setTextFieldNumericOnly(textFieldEditSubPrice);
        setTextFieldNumericOnly(textFieldNewSubCredit);
        setTextFieldNumericOnly(textFieldNewSubPrice);

        initEditSubjectComboBox();

        comboBoxEditSubChoose.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (comboBoxEditSubChoose.getValue() != null) {
                    Subject s = new SubjectImpl().findById((ObjectId) comboBoxEditSubChoose.getValue().getUserData());
                    textFieldEditSubPrice.setText(Integer.toString(s.getPrice()));
                    textFieldEditSubName.setText(s.getName());
                    textFieldEditSubCredit.setText(Integer.toString(s.getCredit()));
                }
            }

        });
    }

    private void clearAddNewSubTextFields() {
        textFieldNewSubName.clear();
        textFieldNewSubCode.clear();
        textFieldNewSubPrice.clear();
        textFieldNewSubCredit.clear();

        textFieldEditSubCredit.clear();
        textFieldEditSubPrice.clear();
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.show();

    }

    private void setTextFieldNumericOnly(TextField textField) {
        textField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    textField.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
    }

    private void initEditSubjectComboBox() {
        SubjectImpl si = new SubjectImpl();
        ArrayList<Subject> subjects = si.find("", null);

        comboBoxEditSubChoose.getItems().clear();

        ArrayList<Label> al = new ArrayList<>();

        for (Subject s : subjects) {
            Label l = new Label(s.getCode() + "  " + s.getName());
            l.setUserData(s.getId());
            al.add(l);
        }
        comboBoxEditSubChoose.getItems().addAll(al);

    }

}
