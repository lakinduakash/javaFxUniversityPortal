package com.ultimatex.nsbm.ui.student;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ProfileController implements Initializable {

    @FXML
    private AnchorPane profilePane;

    @FXML
    private JFXTextField textFieldFullName;

    @FXML
    private JFXTextField textFieldNickName;

    @FXML
    private JFXTextField textFieldDob;

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

    @FXML
    void onSaveButtonClick(ActionEvent event) {

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


}
