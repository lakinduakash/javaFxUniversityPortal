package com.ultimatex.nsbm.ui;

import com.jfoenix.controls.JFXCheckBox;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ListItemViewController implements Initializable {

    private Object customObject;
    @FXML
    private JFXCheckBox checkBox;

    @FXML
    private AnchorPane listPane;

    private volatile boolean initialized;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initialized = true;
    }

    public JFXCheckBox getCheckBox() {
        while (!initialized) ;
        return checkBox;
    }

    public AnchorPane getListPane() {
        while (!initialized) ;
        return listPane;
    }

    public Object getCustomObject() {
        return customObject;
    }

    public void setCustomObject(Object customObject) {
        this.customObject = customObject;
    }
}
