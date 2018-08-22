/**
 * Sample Skeleton for 'lecturer_management.fxml' Controller Class
 */

package com.ultimatex.nsbm.ui.admin;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class LecturerManagementController {

    @FXML // fx:id="textFieldID"
    private JFXTextField textFieldID; // Value injected by FXMLLoader

    @FXML // fx:id="textFieldName"
    private JFXTextField textFieldName; // Value injected by FXMLLoader

    @FXML // fx:id="comboBoxSelectNewType"
    private JFXComboBox<?> comboBoxSelectNewType; // Value injected by FXMLLoader

    @FXML // fx:id="comboBoxNewDept"
    private JFXComboBox<?> comboBoxNewDept; // Value injected by FXMLLoader

    @FXML // fx:id="comboBoxSelectLec"
    private JFXComboBox<?> comboBoxSelectLec; // Value injected by FXMLLoader

    @FXML // fx:id="comboBoxSelectType"
    private JFXComboBox<?> comboBoxSelectType; // Value injected by FXMLLoader

    @FXML // fx:id="comboBoxSelectDept"
    private JFXComboBox<?> comboBoxSelectDept; // Value injected by FXMLLoader

    @FXML
    void onAddNewLecturer(ActionEvent event) {

    }

    @FXML
    void onRemoveLec(ActionEvent event) {

    }

    @FXML
    void onSaveEdit(ActionEvent event) {

    }

}
