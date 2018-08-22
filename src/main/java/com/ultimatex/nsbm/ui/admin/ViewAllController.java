package com.ultimatex.nsbm.ui.admin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDecorator;
import com.jfoenix.controls.JFXListView;
import com.ultimatex.nsbm.GlobalState;
import com.ultimatex.nsbm.model.Course;
import com.ultimatex.nsbm.model.Student;
import com.ultimatex.nsbm.model.crud.StudentImpl;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ViewAllController implements Initializable {

    @FXML
    private JFXListView<HBox> listViewUN;

    @FXML
    private JFXListView<HBox> listViewPS;

    private ArrayList<Student> allStudentList;

    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     * @param location  The location used to resolve relative paths for the root object, or
     *                  <tt>null</tt> if the location is not known.
     * @param resources The resources used to localize the root object, or <tt>null</tt> if
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        StudentImpl si = new StudentImpl();
        allStudentList = si.find("id", null);

        initTabs();


    }

    private void addToUnTab(Student s) {
        addToLists(s, listViewUN);
    }

    private void addToMaTab(Student s) {
        addToLists(s, listViewPS);
    }

    private void addToLists(Student s, JFXListView<HBox> listViewPS) {
        Label l = new Label(s.getIndexNumber() + "       " + s.getFullName());
        l.setMinWidth(500);
        JFXButton b = new JFXButton("Open");
        b.setOnAction(event -> {
            openStudent(s.getIndexNumber());
        });

        listViewPS.getItems().add(createListCell(l, b));
    }

    private void initTabs() {
        for (Student s : allStudentList) {
            if (s.getCourse().getType() == Course.TYPE_UN)
                addToUnTab(s);
            else
                addToMaTab(s);
        }
    }

    private HBox createListCell(Label l, JFXButton b) {
        HBox h = new HBox();
        h.getChildren().add(l);
        h.getChildren().add(b);
        return h;
    }

    private void loadMainStudentView(String title) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/student/main.fxml"));

        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }


        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setTitle(title);
        JFXDecorator decorator = new JFXDecorator(stage, fxmlLoader.getRoot());
        decorator.setCustomMaximize(true);
        Scene scene = new Scene(decorator);
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);

        stage.show();
    }

    private void openStudent(String index) {
        StudentImpl impl = new StudentImpl();
        Student student = impl.getStudentByIndex(index);
        if (student != null) {
            GlobalState.setSelectedStudent(student);
            GlobalState.setFromEditAction(true);
            GlobalState.setFromInsertAction(false);
            GlobalState.setSelectedCourse(student.getCourse());

            loadMainStudentView("Profile " + student.getIndexNumber());
        }
    }


}
