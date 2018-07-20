package com.ultimatex.nsbm.ui.student;

import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTabPane;
import com.ultimatex.nsbm.ui.ResultViewItemController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class ResultsController implements Initializable {
    @FXML
    private JFXTabPane resultPane;

    @FXML
    private JFXListView<HBox> listViewResy1s1;

    @FXML
    private JFXListView<?> listViewResy1s2;

    @FXML
    private JFXListView<?> listViewResy2s1;

    @FXML
    private JFXListView<?> listViewResy2s2;

    @FXML
    private JFXListView<?> listViewResy3s1;

    @FXML
    private JFXListView<?> listViewResy3s2;

    @FXML
    private JFXListView<?> listViewResy4s1;

    @FXML
    private JFXListView<?> listViewResy4s2;

    @FXML
    void onSaveButtonClicky1s1(ActionEvent event) {

    }

    @FXML
    void onSaveButtonClicky1s2(ActionEvent event) {

    }

    @FXML
    void onSaveButtonClicky2s1(ActionEvent event) {

    }

    @FXML
    void onSaveButtonClicky2s2(ActionEvent event) {

    }

    @FXML
    void onSaveButtonClicky3s1(ActionEvent event) {

    }

    @FXML
    void onSaveButtonClicky3s2(ActionEvent event) {

    }

    @FXML
    void onSaveButtonClicky4s1(ActionEvent event) {

    }

    @FXML
    void onSaveButtonClicky4s2(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listViewResy1s1.getItems().add(initOneItem().getResultViewItem());
        listViewResy1s1.getItems().add(initOneItem().getResultViewItem());
        listViewResy1s1.getItems().add(initOneItem().getResultViewItem());
    }

    private ResultViewItemController initOneItem() {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/resultListItem.fxml"));

        try {
            loader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return loader.getController();
    }
}
