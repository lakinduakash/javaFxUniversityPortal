package com.ultimatex.nsbm.ui.student;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTabPane;
import com.ultimatex.nsbm.GlobalState;
import com.ultimatex.nsbm.model.Student;
import com.ultimatex.nsbm.model.Subject;
import com.ultimatex.nsbm.model.crud.CourseImpl;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class PaymentController implements Initializable {

    @FXML
    private JFXTabPane paymentPane;

    @FXML
    private Label labelY1S1Total;

    @FXML
    private JFXCheckBox checkBoxY1s1;

    @FXML
    private Label labelY1s1PaidStatus;

    @FXML
    private Label labelY1S2Total;

    @FXML
    private JFXCheckBox checkBoxY1s2;

    @FXML
    private Label labelY1s2PaidStatus;

    @FXML
    private Label labelY2S1Total;

    @FXML
    private JFXCheckBox checkBoxY2s1;

    @FXML
    private Label labelY2s1PaidStatus;

    @FXML
    private Label labelY2S2Total;

    @FXML
    private JFXCheckBox checkBoxY2s2;

    @FXML
    private Label labelY2s2PaidStatus;

    @FXML
    private Label labelY3S1Total;

    @FXML
    private JFXCheckBox checkBoxY3s1;

    @FXML
    private Label labelY3s1PaidStatus;

    @FXML
    private Label labelY3S2Total;

    @FXML
    private JFXCheckBox checkBoxY3s2;

    @FXML
    private Label labelY3s2PaidStatus;

    @FXML
    private Label labelY4S1Total;

    @FXML
    private JFXCheckBox checkBoxY4s1;

    @FXML
    private Label labelY4s1PaidStatus;

    @FXML
    private Label labelY4S2Total;

    @FXML
    private JFXCheckBox checkBoxY4s2;

    @FXML
    private Label labelY4s2PaidStatus;

    Student selectedStudent=GlobalState.getSelectedStudent();

    public PaymentController()
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
        initTotalPayments(CourseImpl.Y1S1);
        initTotalPayments(CourseImpl.Y1S2);
        initTotalPayments(CourseImpl.Y2S1);
        initTotalPayments(CourseImpl.Y2S2);
//        initTotalPayments(CourseImpl.Y3S1);
//        initTotalPayments(CourseImpl.Y3S2);
//        initTotalPayments(CourseImpl.Y4S1);
//        initTotalPayments(CourseImpl.Y4S2);

        labelY1s1PaidStatus.setText("Paid");
    }

    private void initTotalPayments(String sem)
    {
        switch (sem)
        {
            case CourseImpl.Y1S1:
                int total = 0;
                if (selectedStudent.getSelectedSubjectsy1s1() != null && selectedStudent.getCourse().getYear1sem1() != null) {

                    for (Subject s : selectedStudent.getCourse().getYear1sem1()) {
                        total += s.getPrice();
                    }
                    for (Subject s : selectedStudent.getSelectedSubjectsy1s1()) {
                        total += s.getPrice();
                    }

                    labelY1S1Total.setText(Integer.toString(total) + ".00");
                }
                break;
            case CourseImpl.Y1S2:
                total=0;
                if (selectedStudent.getSelectedSubjectsy1s2() != null && selectedStudent.getCourse().getYear1sem2() != null) {
                    for (Subject s : selectedStudent.getCourse().getYear1sem2()) {
                        total += s.getPrice();
                    }
                    for (Subject s : selectedStudent.getSelectedSubjectsy1s2()) {
                        total += s.getPrice();
                    }

                    labelY1S2Total.setText(Integer.toString(total) + ".00");
                }
                break;
            case CourseImpl.Y2S1:
                total=0;
                if (selectedStudent.getSelectedSubjectsy2s1() != null && selectedStudent.getCourse().getYear2sem1() != null) {
                    for (Subject s : selectedStudent.getCourse().getYear2sem1()) {
                        total += s.getPrice();
                    }
                    for (Subject s : selectedStudent.getSelectedSubjectsy2s1()) {
                        total += s.getPrice();
                    }

                    labelY2S1Total.setText(Integer.toString(total) + ".00");
                }
                break;
            case CourseImpl.Y2S2:
                total=0;
                if (selectedStudent.getSelectedSubjectsy2s2() != null && selectedStudent.getCourse().getYear2sem2() != null) {
                    for (Subject s : selectedStudent.getCourse().getYear2sem2()) {
                        total += s.getPrice();
                    }
                    for (Subject s : selectedStudent.getSelectedSubjectsy2s2()) {
                        total += s.getPrice();
                    }

                    labelY2S2Total.setText(Integer.toString(total) + ".00");
                }
                break;
            case CourseImpl.Y3S1:
                total=0;
                if (selectedStudent.getSelectedSubjectsy3s1() != null && selectedStudent.getCourse().getYear3sem1() != null) {
                    for (Subject s : selectedStudent.getCourse().getYear3sem1()) {
                        total += s.getPrice();
                    }
                    for (Subject s : selectedStudent.getSelectedSubjectsy3s1()) {
                        total += s.getPrice();
                    }

                    labelY3S1Total.setText(Integer.toString(total) + ".00");
                }
                break;
            case CourseImpl.Y3S2:
                total=0;
                if (selectedStudent.getSelectedSubjectsy3s2() != null && selectedStudent.getCourse().getYear3sem2() != null) {
                    for (Subject s : selectedStudent.getCourse().getYear3sem2()) {
                        total += s.getPrice();
                    }
                    for (Subject s : selectedStudent.getSelectedSubjectsy3s2()) {
                        total += s.getPrice();
                    }

                    labelY3S2Total.setText(Integer.toString(total) + ".00");
                }
                break;
            case CourseImpl.Y4S1:
                total=0;
                if (selectedStudent.getSelectedSubjectsy4s1() != null && selectedStudent.getCourse().getYear4sem1() != null) {
                    for (Subject s : selectedStudent.getCourse().getYear4sem1()) {
                        total += s.getPrice();
                    }
                    for (Subject s : selectedStudent.getSelectedSubjectsy4s1()) {
                        total += s.getPrice();
                    }

                    labelY4S1Total.setText(Integer.toString(total) + ".00");
                }
                break;
            case CourseImpl.Y4S2:
                total=0;
                if (selectedStudent.getSelectedSubjectsy4s2() != null && selectedStudent.getCourse().getYear4sem2() != null) {
                    for (Subject s : selectedStudent.getCourse().getYear4sem2()) {
                        total += s.getPrice();
                    }
                    for (Subject s : selectedStudent.getSelectedSubjectsy4s2()) {
                        total += s.getPrice();
                    }

                    labelY4S2Total.setText(Integer.toString(total) + ".00");
                }
                break;
        }
    }

}
