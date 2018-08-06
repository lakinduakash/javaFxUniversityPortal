package com.ultimatex.nsbm.ui.student;

import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTabPane;
import com.ultimatex.nsbm.GlobalState;
import com.ultimatex.nsbm.model.Course;
import com.ultimatex.nsbm.model.SingleResult;
import com.ultimatex.nsbm.model.Student;
import com.ultimatex.nsbm.model.Subject;
import com.ultimatex.nsbm.ui.ResultViewItemController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ArrayList;
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

    Student selectedStudent = GlobalState.getSelectedStudent();
    Course selectedCourse = GlobalState.getSelectedCourse();

    @FXML
    void onSaveButtonClicky4s2(ActionEvent event) {


    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listViewResy1s1.getItems().add(initOneItem().getResultViewItem());
        listViewResy1s1.getItems().add(initOneItem().getResultViewItem());
        listViewResy1s1.getItems().add(initOneItem().getResultViewItem());
    }

    void initTab1() {

    }


    private void addResultsToList(ArrayList<SingleResult> cResults, ArrayList<Subject> cSubject, JFXListView<HBox> listView) {
        for (Subject s : cSubject) {
            ResultViewItemController rc = initOneItem();
            rc.setLabelSubjectName(new Label(s.getName()));
            rc.setCustomObject(s);

            for (SingleResult r : cResults) {
                if (r.getSubject().equals(s)) {
                    rc.getComboBoxGradeSelector().setValue(r.getGrade());
                }
            }
            listView.getItems().add(rc.getResultViewItem());
        }
    }


    private ArrayList<SingleResult> getUpdateResultValue(JFXListView<HBox> item) {
        for (HBox h : item.getItems()) {
        }

        return null;
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
