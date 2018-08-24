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
    private JFXListView<HBox> listViewResy1s2;

    @FXML
    private JFXListView<HBox> listViewResy2s1;

    @FXML
    private JFXListView<HBox> listViewResy2s2;

    @FXML
    private JFXListView<HBox> listViewResy3s1;

    @FXML
    private JFXListView<HBox> listViewResy3s2;

    @FXML
    private JFXListView<HBox> listViewResy4s1;

    @FXML
    private JFXListView<HBox> listViewResy4s2;


    private ArrayList<ResultViewItemController> resultViewItemControllersy1s1 = new ArrayList<>();
    private ArrayList<ResultViewItemController> resultViewItemControllersy1s2 = new ArrayList<>();
    private ArrayList<ResultViewItemController> resultViewItemControllersy2s1 = new ArrayList<>();
    private ArrayList<ResultViewItemController> resultViewItemControllersy2s2 = new ArrayList<>();
    private ArrayList<ResultViewItemController> resultViewItemControllersy3s1 = new ArrayList<>();
    private ArrayList<ResultViewItemController> resultViewItemControllersy3s2 = new ArrayList<>();
    private ArrayList<ResultViewItemController> resultViewItemControllersy4s1 = new ArrayList<>();
    private ArrayList<ResultViewItemController> resultViewItemControllersy4s2 = new ArrayList<>();

    private Student selectedStudent = GlobalState.getSelectedStudent();
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
    void onSaveButtonClicky1s2(ActionEvent event) {

        if (selectedStudent.getResults() == null) {
            Result r = new Result();
            r.setYear1sem2(getUpdatedResultValue(resultViewItemControllersy1s2));
            new ResultImpl(selectedStudent).insert(r);
        } else {
            Result r = selectedStudent.getResults();
            r.setYear1sem2(getUpdatedResultValue(resultViewItemControllersy1s2));
            new ResultImpl(selectedStudent).insert(r);

        }

    }

    @FXML
    void onSaveButtonClicky2s1(ActionEvent event) {

        if (selectedStudent.getResults() == null) {
            Result r = new Result();
            r.setYear2sem1(getUpdatedResultValue(resultViewItemControllersy2s1));
            new ResultImpl(selectedStudent).insert(r);
        } else {
            Result r = selectedStudent.getResults();
            r.setYear2sem1(getUpdatedResultValue(resultViewItemControllersy2s1));
            new ResultImpl(selectedStudent).insert(r);

        }

    }

    @FXML
    void onSaveButtonClicky2s2(ActionEvent event) {

        if (selectedStudent.getResults() == null) {
            Result r = new Result();
            r.setYear2sem2(getUpdatedResultValue(resultViewItemControllersy2s2));
            new ResultImpl(selectedStudent).insert(r);
        } else {
            Result r = selectedStudent.getResults();
            r.setYear2sem2(getUpdatedResultValue(resultViewItemControllersy2s2));
            new ResultImpl(selectedStudent).insert(r);

        }

    }

    @FXML
    void onSaveButtonClicky3s1(ActionEvent event) {

        if (selectedStudent.getResults() == null) {
            Result r = new Result();
            r.setYear3sem1(getUpdatedResultValue(resultViewItemControllersy3s1));
            new ResultImpl(selectedStudent).insert(r);
        } else {
            Result r = selectedStudent.getResults();
            r.setYear3sem1(getUpdatedResultValue(resultViewItemControllersy3s1));
            new ResultImpl(selectedStudent).insert(r);

        }

    }

    @FXML
    void onSaveButtonClicky3s2(ActionEvent event) {
        if (selectedStudent.getResults() == null) {
            Result r = new Result();
            r.setYear3sem2(getUpdatedResultValue(resultViewItemControllersy3s2));
            new ResultImpl(selectedStudent).insert(r);
        } else {
            Result r = selectedStudent.getResults();
            r.setYear3sem2(getUpdatedResultValue(resultViewItemControllersy3s2));
            new ResultImpl(selectedStudent).insert(r);

        }

    }

    @FXML
    void onSaveButtonClicky4s1(ActionEvent event) {

        if (selectedStudent.getResults() == null) {
            Result r = new Result();
            r.setYear4sem1(getUpdatedResultValue(resultViewItemControllersy4s1));
            new ResultImpl(selectedStudent).insert(r);
        } else {
            Result r = selectedStudent.getResults();
            r.setYear4sem1(getUpdatedResultValue(resultViewItemControllersy4s1));
            new ResultImpl(selectedStudent).insert(r);

        }

    }




    @FXML
    void onSaveButtonClicky4s2(ActionEvent event) {
        if (selectedStudent.getResults() == null) {
            Result r = new Result();
            r.setYear4sem2(getUpdatedResultValue(resultViewItemControllersy4s2));
            new ResultImpl(selectedStudent).insert(r);
        } else {
            Result r = selectedStudent.getResults();
            r.setYear4sem2(getUpdatedResultValue(resultViewItemControllersy4s2));
            new ResultImpl(selectedStudent).insert(r);

        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        if (selectedStudent != null) {
            resultPane.setDisable(false);
            initTab1();
            initTab2();
            initTab3();
            initTab4();
        } else {
            resultPane.setDisable(true);
        }

    }

    private void initTab1() {


        Result r = selectedStudent.getResults();
        if (r != null) {
            ArrayList<SingleResult> ry1s1 = r.getYear1sem1();
            ArrayList<Subject> subjectsy1s1 = selectedCourse.getYear1sem1();
            ArrayList<Subject> subjectsy1s1o = selectedStudent.getSelectedSubjectsy1s1();

            initTab(r, ry1s1, subjectsy1s1, subjectsy1s1o, listViewResy1s1, resultViewItemControllersy1s1, r.getYear1sem2(), selectedCourse.getYear1sem2(), selectedStudent.getSelectedSubjectsy1s2(), listViewResy1s2, resultViewItemControllersy1s2);
        } else {

            ArrayList<Subject> subjectsy1s1 = selectedCourse.getYear1sem1();
            ArrayList<Subject> subjectsy1s1o = selectedStudent.getSelectedSubjectsy1s1();

            initTab(null, null, subjectsy1s1, subjectsy1s1o, listViewResy1s1, resultViewItemControllersy1s1, null, selectedCourse.getYear1sem2(), selectedStudent.getSelectedSubjectsy1s2(), listViewResy1s2, resultViewItemControllersy1s2);
        }


    }

    private void initTab2() {

        Result r = selectedStudent.getResults();
        if (r != null)
            initTab(r, r.getYear2sem1(), selectedCourse.getYear2sem1(), selectedStudent.getSelectedSubjectsy2s1(), listViewResy2s1, resultViewItemControllersy2s1, r.getYear2sem2(), selectedCourse.getYear2sem2(), selectedStudent.getSelectedSubjectsy2s2(), listViewResy2s2, resultViewItemControllersy2s2);
        else
            initTab(null, null, selectedCourse.getYear2sem1(), selectedStudent.getSelectedSubjectsy2s1(), listViewResy2s1, resultViewItemControllersy2s1, null, selectedCourse.getYear2sem2(), selectedStudent.getSelectedSubjectsy2s2(), listViewResy2s2, resultViewItemControllersy2s2);


    }

    private void initTab3() {

        Result r = selectedStudent.getResults();
        if (r != null)
            initTab(r, r.getYear3sem1(), selectedCourse.getYear3sem1(), selectedStudent.getSelectedSubjectsy3s1(), listViewResy3s1, resultViewItemControllersy3s1, r.getYear3sem2(), selectedCourse.getYear3sem2(), selectedStudent.getSelectedSubjectsy3s2(), listViewResy3s2, resultViewItemControllersy3s2);
        else
            initTab(null, null, selectedCourse.getYear3sem1(), selectedStudent.getSelectedSubjectsy3s1(), listViewResy3s1, resultViewItemControllersy3s1, null, selectedCourse.getYear3sem2(), selectedStudent.getSelectedSubjectsy3s2(), listViewResy3s2, resultViewItemControllersy3s2);
    }

    private void initTab4() {

        Result r = selectedStudent.getResults();
        if (r != null)
            initTab(r, r.getYear4sem1(), selectedCourse.getYear4sem1(), selectedStudent.getSelectedSubjectsy4s1(), listViewResy4s1, resultViewItemControllersy4s1, r.getYear4sem2(), selectedCourse.getYear4sem2(), selectedStudent.getSelectedSubjectsy4s2(), listViewResy4s2, resultViewItemControllersy4s2);
        else
            initTab(null, null, selectedCourse.getYear4sem1(), selectedStudent.getSelectedSubjectsy4s1(), listViewResy4s1, resultViewItemControllersy4s1, null, selectedCourse.getYear4sem2(), selectedStudent.getSelectedSubjectsy4s2(), listViewResy4s2, resultViewItemControllersy4s2);

    }

    private void initTab(Result r, ArrayList<SingleResult> year1sem1, ArrayList<Subject> year1sem12, ArrayList<Subject> selectedSubjectsy1s1, JFXListView<HBox> listViewResy1s1, ArrayList<ResultViewItemController> resultViewItemControllersy1s1, ArrayList<SingleResult> year1sem2, ArrayList<Subject> year1sem22, ArrayList<Subject> selectedSubjectsy1s2, JFXListView<HBox> listViewResy1s2, ArrayList<ResultViewItemController> resultViewItemControllersy1s2) {
        if (r != null) {
            addResultsToList(year1sem1, year1sem12,
                    selectedSubjectsy1s1, listViewResy1s1, resultViewItemControllersy1s1);

            addResultsToList(year1sem2, year1sem22,
                    selectedSubjectsy1s2, listViewResy1s2, resultViewItemControllersy1s2);
        } else {
            addResultsToList(null, year1sem12,
                    selectedSubjectsy1s1, listViewResy1s1, resultViewItemControllersy1s1);
            addResultsToList(null, year1sem22,
                    selectedSubjectsy1s1, listViewResy1s2, resultViewItemControllersy1s2);
        }
    }




    private void addResultsToList(ArrayList<SingleResult> cResults, ArrayList<Subject> cSubject, ArrayList<Subject> oSubject,
                                  JFXListView<HBox> listView, ArrayList<ResultViewItemController> controllerList) {
        addToListHelper(cResults, cSubject, listView, controllerList);

        addToListHelper(cResults, oSubject, listView, controllerList);


    }

    private void addToListHelper(ArrayList<SingleResult> cResults, ArrayList<Subject> oSubject, JFXListView<HBox> listView, ArrayList<ResultViewItemController> controllerList) {
        if (oSubject != null)
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
