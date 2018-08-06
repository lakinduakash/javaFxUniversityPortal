package com.ultimatex.nsbm.ui.student;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.ultimatex.nsbm.GlobalState;
import com.ultimatex.nsbm.model.Course;
import com.ultimatex.nsbm.model.Student;
import com.ultimatex.nsbm.model.Subject;
import com.ultimatex.nsbm.model.crud.StudentImpl;
import com.ultimatex.nsbm.ui.ListItemViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SubjectController implements Initializable {

    @FXML
    private AnchorPane subjectPane;

    @FXML
    private Tab tabYear1;

    @FXML
    private AnchorPane anchorPaneYear1;

    @FXML
    private JFXListView<AnchorPane> listViewy1s1c;

    @FXML
    private JFXListView<AnchorPane> listViewy1s1o;

    @FXML
    private JFXButton buttony1s1;

    @FXML
    private JFXListView<AnchorPane> listViewy1s2c;

    @FXML
    private JFXListView<AnchorPane> listViewy1s2o;

    @FXML
    private JFXButton buutony1s2;

    @FXML
    private Tab tabYear2;

    @FXML
    private AnchorPane anchorPaneYear2;

    @FXML
    private JFXListView<AnchorPane> listViewy2s1c;

    @FXML
    private JFXListView<AnchorPane> listViewy2s1o;

    @FXML
    private JFXButton buttony2s1;

    @FXML
    private JFXListView<AnchorPane> listViewy2s2c;

    @FXML
    private JFXListView<AnchorPane> listViewy2s2o;

    @FXML
    private JFXButton buutony2s2;

    @FXML
    private Tab tabYear3;

    @FXML
    private AnchorPane anchorPaneYear3;

    @FXML
    private JFXListView<AnchorPane> listViewy3s1c;

    @FXML
    private JFXListView<AnchorPane> listViewy3s1o;

    @FXML
    private JFXButton buttony3s1;

    @FXML
    private JFXListView<AnchorPane> listViewy3s2c;

    @FXML
    private JFXListView<AnchorPane> listViewy3s2o;

    @FXML
    private JFXButton buutony3s2;

    @FXML
    private Tab tabYear4;

    @FXML
    private AnchorPane anchorPaneYear4;

    @FXML
    private JFXListView<AnchorPane> listViewy4s1c;

    @FXML
    private JFXListView<AnchorPane> listViewy4s1o;

    @FXML
    private JFXButton buttony4s1;

    @FXML
    private JFXListView<AnchorPane> listViewy4s2c;

    @FXML
    private JFXListView<AnchorPane> listViewy4s2o;

    @FXML
    private JFXButton buutony4s2;

    private Course selectedCourse;
    private Student selectedStudent;

    private ArrayList<ListItemViewController> listItemViewControllersy1s1 = new ArrayList<>();
    private ArrayList<ListItemViewController> listItemViewControllersy1s2 = new ArrayList<>();
    private ArrayList<ListItemViewController> listItemViewControllersy2s1 = new ArrayList<>();
    private ArrayList<ListItemViewController> listItemViewControllersy2s2 = new ArrayList<>();
    private ArrayList<ListItemViewController> listItemViewControllersy3s1 = new ArrayList<>();
    private ArrayList<ListItemViewController> listItemViewControllersy3s2 = new ArrayList<>();
    private ArrayList<ListItemViewController> listItemViewControllersy4s1 = new ArrayList<>();
    private ArrayList<ListItemViewController> listItemViewControllersy4s2 = new ArrayList<>();

    public SubjectController() {
        selectedCourse = GlobalState.getSelectedCourse();
        selectedStudent = GlobalState.getSelectedStudent();
    }

    @FXML
    void onClickSaveButtonSubjectY1S1(ActionEvent event) {
        updateStudentSubject(listItemViewControllersy1s1);

    }

    @FXML
    void onClickSaveButtonSubjectY1S2(ActionEvent event) {
        updateStudentSubject(listItemViewControllersy1s2);
    }

    @FXML
    void onClickSaveButtonSubjectY2S1(ActionEvent event) {
        updateStudentSubject(listItemViewControllersy2s1);
    }

    @FXML
    void onClickSaveButtonSubjectY2S2(ActionEvent event) {
        updateStudentSubject(listItemViewControllersy2s2);
    }

    @FXML
    void onClickSaveButtonSubjectY3S1(ActionEvent event) {
        updateStudentSubject(listItemViewControllersy3s1);
    }

    @FXML
    void onClickSaveButtonSubjectY3S2(ActionEvent event) {
        updateStudentSubject(listItemViewControllersy3s2);
    }

    @FXML
    void onClickSaveButtonSubjectY4S1(ActionEvent event) {
        updateStudentSubject(listItemViewControllersy4s1);
    }

    @FXML
    void onClickSaveButtonSubjectY4S2(ActionEvent event) {
        updateStudentSubject(listItemViewControllersy4s2);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        if (selectedStudent != null) {
            initTab1();
            initTab2();
            initTab3();
            initTab4();
        }


    }

    private ListItemViewController initOneItem() {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/listViewItem.fxml"));

        try {
            loader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return loader.getController();
    }

    private void initTab1() {
        ArrayList<Subject> y1s1 = selectedStudent.getSelectedSubjectsy1s1();
        ArrayList<Subject> y1s2 = selectedStudent.getSelectedSubjectsy1s2();

        addOptionalSubjectsToList(y1s1, selectedCourse.getYear1sem1o(), listItemViewControllersy1s1, listViewy1s1o);
        addOptionalSubjectsToList(y1s2, selectedCourse.getYear1sem2o(), listItemViewControllersy1s2, listViewy1s2o);

        addCompulsorySubjectsToList(selectedCourse.getYear1sem1(), listViewy1s1c);
        addCompulsorySubjectsToList(selectedCourse.getYear1sem1(), listViewy1s2c);

    }

    private void initTab2() {
        ArrayList<Subject> y2s1 = selectedStudent.getSelectedSubjectsy2s1();
        ArrayList<Subject> y2s2 = selectedStudent.getSelectedSubjectsy2s2();

        addOptionalSubjectsToList(y2s1, selectedCourse.getYear2sem1o(), listItemViewControllersy2s1, listViewy2s1o);
        addOptionalSubjectsToList(y2s2, selectedCourse.getYear2sem2o(), listItemViewControllersy2s2, listViewy2s2o);

        addCompulsorySubjectsToList(selectedCourse.getYear2sem1(), listViewy2s1c);
        addCompulsorySubjectsToList(selectedCourse.getYear2sem2(), listViewy2s2c);

    }

    private void initTab3() {
        ArrayList<Subject> y3s1 = selectedStudent.getSelectedSubjectsy3s1();
        ArrayList<Subject> y3s2 = selectedStudent.getSelectedSubjectsy3s2();

        addOptionalSubjectsToList(y3s1, selectedCourse.getYear3sem1o(), listItemViewControllersy3s1, listViewy3s1o);
        addOptionalSubjectsToList(y3s2, selectedCourse.getYear3sem2o(), listItemViewControllersy3s2, listViewy3s2o);

        addCompulsorySubjectsToList(selectedCourse.getYear3sem1(), listViewy2s1c);
        addCompulsorySubjectsToList(selectedCourse.getYear3sem2(), listViewy2s2c);
    }

    private void initTab4() {
        ArrayList<Subject> y4s1 = selectedStudent.getSelectedSubjectsy4s1();
        ArrayList<Subject> y4s2 = selectedStudent.getSelectedSubjectsy4s2();

        addOptionalSubjectsToList(y4s1, selectedCourse.getYear4sem1o(), listItemViewControllersy4s1, listViewy4s1o);
        addOptionalSubjectsToList(y4s2, selectedCourse.getYear4sem2o(), listItemViewControllersy4s2, listViewy4s2o);

        addCompulsorySubjectsToList(selectedCourse.getYear4sem1(), listViewy4s1c);
        addCompulsorySubjectsToList(selectedCourse.getYear4sem2(), listViewy4s2c);
    }

    private void addOptionalSubjectsToList(ArrayList<Subject> fromStudent, ArrayList<Subject> sFromCourse, ArrayList<ListItemViewController> ls, JFXListView<AnchorPane> listView) {
        if (fromStudent != null) {
            for (Subject subject : sFromCourse) {
                ListItemViewController l = initOneItem();
                if (fromStudent.contains(subject))
                    l.getCheckBox().setSelected(true);

                l.getCheckBox().setText(subject.getName());
                l.setCustomObject(subject);
                ls.add(l);
                listView.getItems().add(l.getListPane());

            }
        } else {
            for (Subject subject : sFromCourse) {
                ListItemViewController l = initOneItem();
                l.getCheckBox().setText(subject.getName());
                l.setCustomObject(subject);
                ls.add(l);
                listView.getItems().add(l.getListPane());
            }
        }
    }

    private void addCompulsorySubjectsToList(ArrayList<Subject> sFromCourse, JFXListView<AnchorPane> listView) {
        if (sFromCourse != null) {
            for (Subject subject : sFromCourse) {
                ListItemViewController l = initOneItem();
                l.getCheckBox().setText(subject.getName());
                l.getCheckBox().setSelected(true);
                l.setCustomObject(subject);
                l.getCheckBox().setDisable(true);
                listView.getItems().add(l.getListPane());
            }
        }

    }

    private void initTabPermission() {
        //if()
    }

    private void updateStudentSubject(ArrayList<ListItemViewController> listItemViewController) {
        ArrayList<Subject> subjects = new ArrayList<>();
        for (ListItemViewController l : listItemViewController) {
            if (l.getCheckBox().isSelected())
                subjects.add((Subject) (l.getCustomObject()));
        }
        if (subjects.size() > 0) {
            selectedStudent.setSelectedSubjectsy1s1(subjects);
            //TODO make common to all semesters (updated subjects only added to y1s1)
            new StudentImpl().update(selectedStudent);
        }
    }
}


