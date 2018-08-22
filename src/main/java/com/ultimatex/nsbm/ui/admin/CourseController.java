/**
 * Sample Skeleton for 'course_management.fxml' Controller Class
 */

package com.ultimatex.nsbm.ui.admin;

import com.jfoenix.controls.*;
import com.ultimatex.nsbm.model.Course;
import com.ultimatex.nsbm.model.Subject;
import com.ultimatex.nsbm.model.crud.CourseImpl;
import com.ultimatex.nsbm.model.crud.SubjectImpl;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import org.bson.types.ObjectId;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CourseController implements Initializable {

    @FXML // fx:id="textFieldNewSubName"
    private JFXTextField textFieldNewSubName; // Value injected by FXMLLoader

    @FXML // fx:id="textFieldNewSubCode"
    private JFXTextField textFieldNewSubCode; // Value injected by FXMLLoader

    @FXML // fx:id="textFieldNewSubCredit"
    private JFXTextField textFieldNewSubCredit; // Value injected by FXMLLoader

    @FXML // fx:id="textFieldNewSubPrice"
    private JFXTextField textFieldNewSubPrice; // Value injected by FXMLLoader

    @FXML // fx:id="comboBoxNewHeadLec"
    private JFXComboBox<?> comboBoxNewHeadLec; // Value injected by FXMLLoader

    @FXML // fx:id="buttonAddNewSub"
    private JFXButton buttonAddNewSub; // Value injected by FXMLLoader

    @FXML // fx:id="comboBoxEditSubChoose"
    private JFXComboBox<Label> comboBoxEditSubChoose; // Value injected by FXMLLoader

    @FXML // fx:id="textFieldEditSubName"
    private JFXTextField textFieldEditSubName; // Value injected by FXMLLoader

    @FXML // fx:id="textFieldEditSubCredit"
    private JFXTextField textFieldEditSubCredit; // Value injected by FXMLLoader

    @FXML // fx:id="textFieldEditSubPrice"
    private JFXTextField textFieldEditSubPrice; // Value injected by FXMLLoader

    @FXML // fx:id="comboBoxEditCourse"
    private JFXComboBox<Label> comboBoxEditCourse; // Value injected by FXMLLoader

    @FXML // fx:id="comboBoxEditSem"
    private JFXComboBox<Label> comboBoxEditSem; // Value injected by FXMLLoader

    @FXML // fx:id="comboBoxEditCourseSubject"
    private JFXComboBox<Label> comboBoxEditCourseSubject; // Value injected by FXMLLoader

    @FXML
    private JFXCheckBox checkBoxEditCourse;


    @FXML
    void onEditCourseSaveButtonClicked(ActionEvent event) {
        if(comboBoxEditCourseSubject.getValue()!=null && comboBoxEditCourse.getValue()!=null && comboBoxEditSem.getValue()!=null) {
            CourseImpl ci=new CourseImpl();

            if (checkBoxEditCourse.isSelected()) {
                Subject s=(Subject)comboBoxEditCourseSubject.getValue().getUserData();
                ArrayList<Subject> as= CourseImpl.getSubjectList((Course)comboBoxEditCourse.getValue().getUserData(),(String)comboBoxEditSem.getValue().getUserData());
                as.add(s);

                ci.addOptionalSubject((Course)comboBoxEditCourse.getValue().getUserData(), as,true,(String)comboBoxEditSem.getValue().getUserData());
                ci.addCompulsorySubject((Course)comboBoxEditCourse.getValue().getUserData(), as,true,(String)comboBoxEditSem.getValue().getUserData());
                showAlert("Success","Subject added to course");

            } else {
                ArrayList<Label> subL = new ArrayList<>(comboBoxEditCourseSubject.getItems());
                ArrayList<Subject> s=new ArrayList<>();

                ObjectId id=((Subject)comboBoxEditCourseSubject.getValue().getUserData()).getId();

                for(Label l:subL)
                {
                    if(!((Subject)l.getUserData()).getId().equals(id))
                        s.add(((Subject)l.getUserData()));
                }

                ci.addOptionalSubject((Course)comboBoxEditCourse.getValue().getUserData(), s,true,(String)comboBoxEditSem.getValue().getUserData());
                ci.addCompulsorySubject((Course)comboBoxEditCourse.getValue().getUserData(), s,true,(String)comboBoxEditSem.getValue().getUserData());
                showAlert("Success","Subject removed from course");

            }

            initSelectCourseComboBox();
            initComboBoxEditSem();
        }
        else
        {
            showAlert("Error","Select values");
        }

    }

    @FXML
    void onEditSubAddButtonClicked(ActionEvent event) {

        if (comboBoxEditSubChoose.getValue() != null) {

            Subject s = new SubjectImpl().findById((ObjectId) comboBoxEditSubChoose.getValue().getUserData());
            s.setPrice(Integer.parseInt(textFieldEditSubPrice.getText()));
            s.setName(textFieldEditSubName.getText());
            s.setCredit(Integer.parseInt(textFieldEditSubCredit.getText()));

            if (new SubjectImpl().update(s)) {
                showAlert("Success", "Subject updated");
                initEditSubjectComboBox();

            } else
                showAlert("Failed", "Error");


        }

    }

    @FXML
    void onEditSubRemoveButtonClicked(ActionEvent event) {

        if (comboBoxEditSubChoose.getValue() != null) {
            ObjectId id = (ObjectId) comboBoxEditSubChoose.getValue().getUserData();
            System.out.println(id);
            if (new SubjectImpl().delete(id)) {
                comboBoxEditSubChoose.getItems().removeAll();
                initEditSubjectComboBox();
                showAlert("Success", "Subject deleted");

            } else
                showAlert("Failed", "Error");


        }
    }

    @FXML
    void onNewSubAddButtonClicked(ActionEvent event) {

        Subject s = new Subject(textFieldNewSubName.getText().trim(), textFieldNewSubCode.getText().trim(),
                Integer.parseInt(textFieldNewSubPrice.getText().trim()), Integer.parseInt(textFieldNewSubCredit.getText()));
        SubjectImpl si = new SubjectImpl();
        if (si.insert(s)) {
            showAlert("Success", "Subject Saved");
            initEditSubjectComboBox();
        }
        else
            showAlert("Error", "Some Error occurred");
        clearAddNewSubTextFields();



    }

    @FXML
    public void onEditCourseCheckBoxChecked(ActionEvent event)
    {

    }

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
        setTextFieldNumericOnly(textFieldEditSubCredit);
        setTextFieldNumericOnly(textFieldEditSubPrice);
        setTextFieldNumericOnly(textFieldNewSubCredit);
        setTextFieldNumericOnly(textFieldNewSubPrice);

        initEditSubjectComboBox();
        initSelectCourseComboBox();
        initComboBoxEditSem();

        comboBoxEditSubChoose.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (comboBoxEditSubChoose.getValue() != null) {
                    Subject s = new SubjectImpl().findById((ObjectId) comboBoxEditSubChoose.getValue().getUserData());
                    textFieldEditSubPrice.setText(Integer.toString(s.getPrice()));
                    textFieldEditSubName.setText(s.getName());
                    textFieldEditSubCredit.setText(Integer.toString(s.getCredit()));
                }
            }

        });

        comboBoxEditSem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(comboBoxEditSem.getValue()!=null && comboBoxEditCourse.getValue()!=null)
                {
                    iniEditCourseSubjectComboBox((Course)comboBoxEditCourse.getValue().getUserData(),(String)comboBoxEditSem.getValue().getUserData(),checkBoxEditCourse.isSelected());
                }
            }
        });




    }

    private void clearAddNewSubTextFields() {
        textFieldNewSubName.clear();
        textFieldNewSubCode.clear();
        textFieldNewSubPrice.clear();
        textFieldNewSubCredit.clear();

        textFieldEditSubCredit.clear();
        textFieldEditSubPrice.clear();
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.show();

    }

    private void setTextFieldNumericOnly(TextField textField) {
        textField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    textField.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
    }

    private void initEditSubjectComboBox() {
        SubjectImpl si = new SubjectImpl();
        ArrayList<Subject> subjects = si.find("", null);

        comboBoxEditSubChoose.getItems().clear();

        ArrayList<Label> al = new ArrayList<>();

        for (Subject s : subjects) {
            Label l = new Label(s.getCode() + "  " + s.getName());
            l.setUserData(s.getId());
            al.add(l);
        }
        comboBoxEditSubChoose.getItems().addAll(al);

    }

    private void initSelectCourseComboBox()
    {
        comboBoxEditCourse.getItems().clear();
        ArrayList<Course> ac=new CourseImpl().getAllCourse();

        for(Course c:ac)
        {
            Label l=new Label(c.getName());
            l.setUserData(c);
            comboBoxEditCourse.getItems().add(l);
        }
    }

    private void initComboBoxEditSem()
    {
        comboBoxEditSem.getItems().clear();
        for(String s:CourseImpl.getSemesterCodes())
        {
            Label l=new Label(s);
            l.setUserData(s);
            comboBoxEditSem.getItems().add(l);
        }
    }

    private void iniEditCourseSubjectComboBox(Course c,String sem,boolean add)
    {
        comboBoxEditCourseSubject.getItems().clear();
        if(add)
        {
            SubjectImpl si = new SubjectImpl();
            ArrayList<Subject> subjects = si.find("", null);

            ArrayList<Label> al = new ArrayList<>();

            for (Subject s : subjects) {
                Label l = new Label(s.getCode() + "  " + s.getName());
                l.setUserData(s);
                al.add(l);
            }
            comboBoxEditCourseSubject.getItems().addAll(al);
        }
        else
        {
            for (Subject s:CourseImpl.getSubjectList(c,sem))
            {
                Label l=new Label(s.getCode()+" "+s.getName());
                l.setUserData(s);
                comboBoxEditCourseSubject.getItems().add(l);
            }
        }
    }



}
