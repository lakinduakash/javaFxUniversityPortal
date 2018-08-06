package com.ultimatex.nsbm.ui.student;

import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTabPane;
import com.ultimatex.nsbm.GlobalState;
import com.ultimatex.nsbm.model.*;
import com.ultimatex.nsbm.model.crud.ResultImpl;
import com.ultimatex.nsbm.ui.ResultViewItemController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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


    private ArrayList<ResultViewItemController> resultViewItemControllersy1s1 = new ArrayList<>();
    private ArrayList<ResultViewItemController> resultViewItemControllersy1s2 = new ArrayList<>();
    private ArrayList<ResultViewItemController> resultViewItemControllersy2s1 = new ArrayList<>();
    private ArrayList<ResultViewItemController> resultViewItemControllersy2s2 = new ArrayList<>();
    private ArrayList<ResultViewItemController> resultViewItemControllersy3s1 = new ArrayList<>();
    private ArrayList<ResultViewItemController> resultViewItemControllersy3s2 = new ArrayList<>();
    private ArrayList<ResultViewItemController> resultViewItemControllersy4s1 = new ArrayList<>();
    private ArrayList<ResultViewItemController> resultViewItemControllersy4s2 = new ArrayList<>();
    private Student selectedStudent = GlobalState.getSelectedStudent();

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

    private Course selectedCourse = GlobalState.getSelectedCourse();

    @FXML
    void onSaveButtonClicky1s1(ActionEvent event) {
        if (selectedStudent.getResults() == null) {
            Result r = new Result();
            r.setYear1sem1(getUpdatedResultValue(resultViewItemControllersy1s1));
            new ResultImpl(selectedStudent).insert(r);
        } else {
            Result r = selectedStudent.getResults();
            r.setYear1sem1(getUpdatedResultValue(resultViewItemControllersy1s1));
            new ResultImpl(selectedStudent).insert(r);

        }
    }


    @FXML
    void onSaveButtonClicky4s2(ActionEvent event) {


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        initTab1();

    }

    private void initTab1() {

        Result r = selectedStudent.getResults();
        if (r != null) {
            ArrayList<SingleResult> sr = r.getYear1sem1();
            addResultsToList(sr, selectedCourse.getYear1sem1(),
                    selectedStudent.getSelectedSubjectsy1s1(), listViewResy1s1, resultViewItemControllersy1s1);
        } else {
            addResultsToList(null, selectedCourse.getYear1sem1(),
                    selectedStudent.getSelectedSubjectsy1s1(), listViewResy1s1, resultViewItemControllersy1s1);
        }



    }


    private void addResultsToList(ArrayList<SingleResult> cResults, ArrayList<Subject> cSubject, ArrayList<Subject> oSubject,
                                  JFXListView<HBox> listView, ArrayList<ResultViewItemController> controllerList) {
        addToListHelper(cResults, cSubject, listView, controllerList);

        addToListHelper(cResults, oSubject, listView, controllerList);


    }

    private void addToListHelper(ArrayList<SingleResult> cResults, ArrayList<Subject> oSubject, JFXListView<HBox> listView, ArrayList<ResultViewItemController> controllerList) {
        for (Subject s : oSubject) {
            ResultViewItemController rc = initOneItem();
            rc.setLabelSubjectName(s.getName());
            rc.setCustomObject(s);

            if (cResults != null)
                for (SingleResult r : cResults) {
                    if (r.getSubject().equals(s)) {
                        rc.getComboBoxGradeSelector().setValue(r.getGrade());
                    }
                }
            controllerList.add(rc);
            listView.getItems().add(rc.getResultViewItem());

        }
    }


    private ArrayList<SingleResult> getUpdatedResultValue(ArrayList<ResultViewItemController> controllerArrayList) {

        ArrayList<SingleResult> list = new ArrayList<>();

        for (ResultViewItemController c : controllerArrayList) {
            SingleResult singleResult = new SingleResult();
            Subject s = (Subject) (c.getCustomObject());
            singleResult.setSubject(s);
            singleResult.setGrade(c.getComboBoxGradeSelector().getValue());

            list.add(singleResult);

        }

        return list;
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
