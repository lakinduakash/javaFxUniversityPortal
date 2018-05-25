package com.ultimatex.nsbm.ui.student;

import com.ultimatex.nsbm.util.MainContainerState;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class SideNavController implements Initializable {


    @FXML
    private VBox sideNav;

    private OnSideNavItemClickListener listener;
    private MainController mainController;
    private int State = MainContainerState.PROFILE;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void onProfileClick(ActionEvent event) {
        listener.onStateChanged(MainContainerState.PROFILE);
    }

    @FXML
    private void onPaymentClick(ActionEvent event) {
        listener.onStateChanged(MainContainerState.PAYMENT);
    }

    @FXML
    private void onScheduleClick(ActionEvent event) {
        listener.onStateChanged(MainContainerState.SCHEDULE);
    }

    @FXML
    private void onSubjectsClick(ActionEvent event) {
        listener.onStateChanged(MainContainerState.SUBJECT);
    }

    @FXML
    private void onSettingsClick(ActionEvent event) {
        listener.onStateChanged(MainContainerState.SETTINGS);
    }

    @FXML
    private void onResultsClick(ActionEvent event) {
        listener.onStateChanged(MainContainerState.RESULT);
    }

    public MainController getMainController() {
        return mainController;
    }


    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void setListener(OnSideNavItemClickListener listener) {
        this.listener = listener;
    }


    public interface OnSideNavItemClickListener {
        void onStateChanged(int state);

        //void onNaveItemClickListener();
    }


}

