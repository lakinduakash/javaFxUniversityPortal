package com.ultimatex.nsbm.ui.student;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.ultimatex.nsbm.GlobalState;
import com.ultimatex.nsbm.model.Address;
import com.ultimatex.nsbm.model.Course;
import com.ultimatex.nsbm.model.Student;
import com.ultimatex.nsbm.model.crud.StudentImpl;
import com.ultimatex.nsbm.util.GenerateIndex;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

public class ProfileController implements Initializable {

    @FXML
    private AnchorPane profilePane;

    @FXML
    private JFXTextField textFieldFullName;
    private String fullName;

    @FXML
    private JFXTextField textFieldNickName;
    private String nickName;

    @FXML
    private JFXDatePicker datePickerDOB;
    private Date date;

    @FXML
    private JFXTextField textFieldAge;

    @FXML
    private JFXTextField textFieldStreet;

    @FXML
    private JFXTextField textFieldCity;

    @FXML
    private JFXTextField textFieldPostal;

    @FXML
    private JFXTextField textFieldReg;

    @FXML
    private JFXTextField textFieldIndex;

    @FXML
    private JFXTextField textFieldCourse;

    @FXML
    private JFXTextField textFieldNIC;

    @FXML
    private JFXTextField textFieldMobile;

    @FXML
    private JFXTextField textFieldHome;

    @FXML
    private JFXTextField textFieldEmail;

    @FXML
    private JFXButton buttonSave;


    private GenerateIndex generateIndex = new GenerateIndex();

    private boolean fromInsert;
    private Course selectedCourse;
    private Student selectedStudent;
    private boolean studentRegistered;

    private String sIndex;

    public ProfileController() {
        fromInsert = GlobalState.isFromInsertAction();
        selectedCourse = GlobalState.getSelectedCourse();
        selectedStudent = GlobalState.getSelectedStudent();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {


        if (fromInsert) {
            initFromInsert();
        } else {
            initFromUpdate();
        }


    }

    private void initFromInsert() {
        if (GlobalState.getSelectedCourse() != null) {
            textFieldCourse.setText(GlobalState.getSelectedCourse().getName());
            sIndex = GlobalState.getSelectedCourse().getCode() + generateIndex.genNewIndex();
            textFieldIndex.setText(sIndex);
        }

        datePickerDOB.setValue(LocalDate.now());

        datePickerDOB.setOnAction(event -> {
            textFieldAge.setText(Integer.toString(getAgeFromDob(datePickerDOB.getValue())));
        });
    }

    private void initFromUpdate() {

    }

    @FXML
    void onSaveButtonClick(ActionEvent event) {

        if (!validateFields()) {
            return;
        }

        if (studentRegistered) {
            showAlert("Already registered", "Student is already registered");
            return;
        }
        if (GlobalState.isFromInsertAction()) {
            if (insertStudent()) {
                showAlert("Success", "New student is registered");
                studentRegistered = true;
                freesFields();
            } else
                showAlert("Error", "some error occurred");
        }

    }

    private boolean insertStudent() {
        Student student = new Student();
        student.setCourse(selectedCourse);
        student.setDob(java.sql.Date.valueOf(datePickerDOB.getValue()));
        student.setAddress(new Address(textFieldStreet.getText().trim(), textFieldCity.getText().trim(), textFieldPostal.getText().trim()));
        student.setIndexNumber(sIndex);
        student.setAge(Integer.parseInt(textFieldAge.getText().trim()));
        student.setNic(textFieldNIC.getText().trim());
        student.setNickName(textFieldNickName.getText().trim());
        student.setNic(textFieldNIC.getText().trim());
        student.setHomeNumber(textFieldHome.getText().trim());
        student.setMobileNumber(textFieldMobile.getText().trim());
        student.setEmail(textFieldEmail.getText().trim());

        generateIndex.saveIndex();

        StudentImpl studentImpl = new StudentImpl();
        GlobalState.setSelectedStudent(student);
        return studentImpl.insertNewStudent(student);

    }

    private int getAgeFromDob(LocalDate date) {
        Date dob = java.sql.Date.valueOf(date);

        long diffInDays = ((new Date().getTime() - dob.getTime())
                / (1000 * 60 * 60 * 24));
        return (int) (diffInDays / 365);

    }

    private boolean validateFields() {
        if ("".equals(textFieldFullName.getText())) {
            showAlert("Error", "Please enter name");
            return false;
        } else if ("".equals(textFieldAge.getText()) || "0".equals(textFieldAge.getText())) {
            showAlert("Error", "Please select DOB");
            return false;
        } else if ("".equals(textFieldStreet.getText().trim()) || "".equals(textFieldCity.getText().trim())) {
            showAlert("Error", "Please enter street address and city");
            return false;
        } else if ("".equals(textFieldNIC.getText().trim())) {
            showAlert("Error", "Please enter NIC or Passport");
            return false;
        } else if (textFieldHome.getText().trim().length() < 10 && textFieldMobile.getText().trim().length() < 10) {
            showAlert("Error", "Please enter valid phone number either Mobile or Home ");
            return false;
        } else if ("".equals(textFieldEmail.getText()) || textFieldAge.getText().contains("@")) {
            showAlert("Error", "Please enter valid email");
            return false;
        }


        return true;
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.show();

    }

    private void freesFields() {
        for (Node n : profilePane.getChildren())//parent
        {
            if (n.getClass() == VBox.class) {
                for (Node hBoxChild : ((VBox) n).getChildren())//vbox
                {
                    if (hBoxChild.getClass() == HBox.class) {
                        for (Node textField : ((HBox) hBoxChild).getChildren())//hbox
                            if (textField.getClass() == JFXTextField.class)
                                ((JFXTextField) textField).setEditable(false);
                    }
                }
            }
        }

        buttonSave.setDisable(true);
        datePickerDOB.setDisable(true);
    }


}
