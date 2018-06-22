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

    @FXML
    private JFXTextField textFieldNickName;

    @FXML
    private JFXDatePicker datePickerDOB;

    @FXML
    private JFXTextField textFieldAge;

    @FXML
    private JFXTextField textFieldStreet;

    @FXML
    private JFXTextField textFieldCity;

    @FXML
    private JFXTextField textFieldPostal;

    @FXML
    private JFXTextField textFieldAddmissionDate;

    @FXML
    private JFXTextField textFieldIntake;

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
    private JFXTextField textFieldC1;

    @FXML
    private JFXTextField textFieldC2;

    @FXML
    private JFXTextField textFieldC3;

    @FXML
    private JFXButton buttonSave;


    private GenerateIndex generateIndex = new GenerateIndex();


    private boolean fromInsert;
    private Course selectedCourse;
    private Student selectedStudent;
    private boolean studentRegistered;
    private Date nowDate = new Date();

    private String sIndex;

    /**************************************************************************
     *
     * Constructors
     *
     **************************************************************************/
    public ProfileController() {
        nowDate = GlobalState.getSimulatedDate();
        fromInsert = GlobalState.isFromInsertAction();
        selectedCourse = GlobalState.getSelectedCourse();
        selectedStudent = GlobalState.getSelectedStudent();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        datePickerDOB.setOnAction(event -> {
            textFieldAge.setText(Integer.toString(getAgeFromDob(datePickerDOB.getValue())));
        });

        initExtraFieldNames();
        if (fromInsert) {
            initFromInsert();
        } else {
            initFromUpdate();
        }


    }

    private void initExtraFieldNames() {
        if (selectedCourse.getType() == Course.TYPE_MA) {
            textFieldC1.setPromptText("Undergraduate University");
            textFieldC2.setPromptText("Degree name");
            textFieldC3.setPromptText("Previous GPA");
        } else {
            textFieldC1.setPromptText("AL year");
            textFieldC2.setPromptText("Z score");
            textFieldC3.setPromptText("AL Results");
            textFieldC3.setText("SUB1:Grade, SUB2:Grade, SUB3:Grade");
        }
    }

    /**
     * initialise the state if comes from adding new student.
     */
    private void initFromInsert() {
        if (GlobalState.getSelectedCourse() != null) {
            textFieldCourse.setText(GlobalState.getSelectedCourse().getName());
            sIndex = GlobalState.getSelectedCourse().getCode() + generateIndex.genNewIndex();
            textFieldIndex.setText(sIndex);
        }

        datePickerDOB.setValue(LocalDate.now());
        textFieldAddmissionDate.setText(nowDate.toString());
        textFieldIntake.setText(getIntake());

    }

    private void initFromUpdate() {
        buttonSave.setText("Save edit");

        initTextFields();

    }


    /**
     * Handle button when saving details of student
     *
     * @param event
     * @return void
     */

    @FXML
    public void onSaveButtonClick(ActionEvent event) {

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
        } else if (GlobalState.isFromEditAction()) {

        }

    }

    /**
     * insert student to database
     * @return boolean value whether student is successfully inserted
     */

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
        student.setFullName(textFieldFullName.getText().trim());
        student.setAdmissionDate(nowDate);
        student.setIntake(getIntake());

        generateIndex.saveIndex();

        if (selectedCourse.getType() == Course.TYPE_MA) {
            student.setUniversity(textFieldC1.getText().trim());
            student.setDegree(textFieldC2.getText().trim());
            student.setPrevGpv(Double.parseDouble(textFieldC3.getText().trim()));
        } else {
            student.setALYear(Integer.parseInt(textFieldC1.getText().trim()));
            student.setALResults(textFieldC2.getText().trim());
            student.setzScore(Double.parseDouble(textFieldC3.getText().trim()));
        }

        StudentImpl studentImpl = new StudentImpl();
        GlobalState.setSelectedStudent(student);
        return studentImpl.insert(student);

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
        } else {
            if (selectedCourse.getType() == Course.TYPE_MA) {
                if (textFieldC1.getText().trim().length() < 1) {
                    showAlert("Error", "Please enter valid University name");
                    return false;
                } else if (textFieldC2.getText().trim().length() < 1) {
                    showAlert("Error", "Please enter valid degree name");
                    return false;
                } else {
                    try {
                        Double.parseDouble(textFieldC3.getText().trim());
                    } catch (Exception e) {
                        showAlert("Error", "Please enter valid gpa");
                        return false;
                    }
                }
            } else {
                try {
                    int y = Integer.parseInt(textFieldC1.getText().trim());
                    if (y < 2008) {
                        showAlert("Error", "Please enter valid AL year");
                        return false;
                    }
                    Double.parseDouble(textFieldC3.getText().trim());
                    if (textFieldC2.getText().trim().length() < 12) {
                        showAlert("Error", "Please enter valid result");
                        return false;
                    }
                } catch (Exception e) {
                    showAlert("Error", "Please enter valid Z core and AL year");
                    return false;
                }


            }
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
        datePickerDOB.setEditable(false);
    }


    private void initTextFields() {
        textFieldFullName.setText(selectedStudent.getFullName());
        textFieldNickName.setText(selectedStudent.getNickName());
        datePickerDOB.setValue(new java.sql.Date(selectedStudent.getDob().getTime()).toLocalDate());
        textFieldEmail.setText(selectedStudent.getEmail());
        textFieldAge.setText(Integer.toString(selectedStudent.getAge()));
        textFieldStreet.setText(selectedStudent.getAddress().getStreet());
        textFieldCity.setText(selectedStudent.getAddress().getCity());
        textFieldPostal.setText(selectedStudent.getAddress().getZipCode());
        textFieldNIC.setText(selectedStudent.getNic());
        textFieldIndex.setText(selectedStudent.getIndexNumber());
        textFieldMobile.setText(selectedStudent.getMobileNumber());
        textFieldHome.setText(selectedStudent.getHomeNumber());
        textFieldCourse.setText(selectedStudent.getCourse().getName());
        textFieldAddmissionDate.setText(selectedStudent.getAdmissionDate().toString());
        textFieldAddmissionDate.setEditable(false);
        textFieldIntake.setText(selectedStudent.getIntake());
        textFieldIntake.setEditable(false);

        if (selectedCourse.getType() == Course.TYPE_MA) {
            textFieldC1.setText(selectedStudent.getUniversity());
            textFieldC2.setText(selectedStudent.getDegree());
            textFieldC3.setText("" + selectedStudent.getPrevGpv());
        } else {
            textFieldC1.setText("" + selectedStudent.getALYear());
            textFieldC2.setText(selectedStudent.getALResults());
            textFieldC3.setText("" + selectedStudent.getzScore());
        }
    }

    private String getIntake() {

        if (nowDate.getMonth() < 2 && nowDate.getMonth() >= 7) {
            if (nowDate.getMonth() >= 1)
                return Student.INTAKE_FEB + " " + (nowDate.getYear() + 1900);
            else if (nowDate.getMonth() >= 7)
                return Student.INTAKE_FEB + " " + (nowDate.getYear() + 1 + 1900);
        } else {
            return Student.INTAKE_JULY + " " + (nowDate.getYear() + 1900);
        }
        return "";

    }


}
