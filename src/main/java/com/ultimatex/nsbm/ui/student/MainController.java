package com.ultimatex.nsbm.ui.student;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerSlideCloseTransition;
import com.ultimatex.nsbm.util.MainContainerState;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainController implements Initializable, SideNavController.OnSideNavItemClickListener {

    private static final String PROFILE_CONTAINER = "/fxml/student/profile.fxml";
    private static final String SUBJECTS_CONTAINER = "/fxml/student/subjects.fxml";
    private static final String SCHEDULE_CONTAINER = "/fxml/student/schedule.fxml";
    private static final String RESULTS_CONTAINER = "/fxml/student/results.fxml";
    private static final String PAYMENTS_CONTAINER = "/fxml/student/payments.fxml";
    private static final String SETTINGS_CONTAINER = "/fxml/student/settings.fxml";



    @FXML
    private JFXHamburger hamburger;
    @FXML
    private JFXDrawer drawer;

    @FXML
    private AnchorPane mainContainer;

    private int currentState;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        initDrawer();
        changeContainer(MainContainerState.PROFILE);
    }

    public AnchorPane getMainContainer() {
        return mainContainer;
    }


    @FXML
    public void onHamburgerClick(MouseEvent event) {

    }

    private void initDrawer() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/student/sidenav.fxml"));
            VBox sideNav = loader.load();
            drawer.setSidePane(sideNav);
            SideNavController controller = loader.getController();
            controller.setListener(this);
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }

        HamburgerSlideCloseTransition task = new HamburgerSlideCloseTransition(hamburger);
        task.setRate(-1);
        hamburger.addEventHandler(MouseEvent.MOUSE_CLICKED, (Event event) -> drawer.toggle());
        drawer.setOnDrawerOpening((event) -> {
            task.setRate(task.getRate() * -1);
            task.getRate();
            task.play();
            drawer.toFront();
        });
        drawer.setOnDrawerClosed((event) -> {
            drawer.toBack();
            task.setRate(task.getRate() * -1);
            task.play();
        });
    }

    private void changeContainer(int stateId) {

        ObservableList<Node> child = mainContainer.getChildren();
        currentState = stateId;

        if (stateId == MainContainerState.PROFILE) {
            if (canStateAdded("profilePane")) {
                if (child.size() > 0)
                    child.remove(0);
                loadContainer(PROFILE_CONTAINER);
            }
        } else if (stateId == MainContainerState.SUBJECT) {
            if (canStateAdded("subjectPane")) {
                if (child.size() > 0)
                    child.remove(0);
                loadContainer(SUBJECTS_CONTAINER);
            }
        } else if (stateId == MainContainerState.SCHEDULE) {
            if (canStateAdded("schedulePane")) {
                if (child.size() > 0)
                    child.remove(0);
                loadContainer(SCHEDULE_CONTAINER);
            }
        } else if (stateId == MainContainerState.RESULT) {
            if (canStateAdded("resultPane")) {
                if (child.size() > 0)
                    child.remove(0);
                loadContainer(RESULTS_CONTAINER);
            }
        } else if (stateId == MainContainerState.PAYMENT) {

            if (canStateAdded("paymentPane")) {
                if (child.size() > 0)
                    child.remove(0);
                loadContainer(PAYMENTS_CONTAINER);
            }
        } else if (stateId == MainContainerState.SETTINGS) {
            if (canStateAdded("settingPane")) {
                if (child.size() > 0)
                    child.remove(0);
                loadContainer(SETTINGS_CONTAINER);
            }
        }
    }


    private void loadContainer(String fxmlLocation) {

        Task<Node> task = new Task<Node>() {
            @Override
            protected Node call() throws Exception {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlLocation));
                Node pane = null;

                try {
                    pane = fxmlLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return pane;
            }
        };

        task.setOnSucceeded((e) -> {
            Node pane = task.getValue();
            mainContainer.getChildren().addAll(pane);
            AnchorPane.setBottomAnchor(pane, (double) 0);
            AnchorPane.setRightAnchor(pane, (double) 0);
            AnchorPane.setLeftAnchor(pane, (double) 0);
            AnchorPane.setTopAnchor(pane, (double) 0);
        });


        Thread thread = new Thread(task);
        thread.start();


    }

    private boolean canStateAdded(String paneId) {
        ObservableList<Node> children = mainContainer.getChildren();

        if ((children.size() > 0 && children.get(0).getId().equals(paneId))) {
            return false;
        } else if (children.size() == 0) {
            return true;
        }
        return true;
    }


    @Override
    public void onStateChanged(int state) {
        changeContainer(state);
    }


}