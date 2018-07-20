package com.ultimatex.nsbm.ui;

import com.jfoenix.controls.JFXComboBox;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static com.ultimatex.nsbm.model.SingleResult.*;

public class ResultViewItemController implements Initializable {

    @FXML
    private HBox resultViewItem;

    @FXML
    private Label LabelSubjectName;

    @FXML
    private JFXComboBox<String> comboBoxGradeSelector;

    private Object customObject;

    private volatile boolean initialized;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ArrayList<String> gradeList =new ArrayList<>();
        gradeList.add(A_PLUS);
        gradeList.add(A_);
        gradeList.add(A_MINUS);
        gradeList.add(B_PLUS);
        gradeList.add(B_);
        gradeList.add(B_MINUS);
        gradeList.add(C_PLUS);
        gradeList.add(C_);
        gradeList.add(C_MINUS);
        comboBoxGradeSelector.getItems().addAll(gradeList);

        initialized =true;
    }

    public HBox getResultViewItem() {
        while (!initialized);
        return resultViewItem;
    }

    public void setResultViewItem(HBox resultViewItem) {
        while (!initialized);
        this.resultViewItem = resultViewItem;
    }

    public Label getLabelSubjectName() {
        while (!initialized);
        return LabelSubjectName;
    }

    public void setLabelSubjectName(Label labelSubjectName) {
        while (!initialized);
        LabelSubjectName = labelSubjectName;
    }

    public JFXComboBox<String> getComboBoxGradeSelector() {
        while (!initialized);
        return comboBoxGradeSelector;
    }

    public void setComboBoxGradeSelector(JFXComboBox<String> comboBoxGradeSelector) {
        while (!initialized);
        this.comboBoxGradeSelector = comboBoxGradeSelector;
    }

    public Object getCustomObject() {
        return customObject;
    }

    public void setCustomObject(Object customObject) {
        this.customObject = customObject;
    }
}
