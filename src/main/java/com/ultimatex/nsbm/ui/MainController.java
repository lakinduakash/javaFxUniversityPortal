package com.ultimatex.nsbm.ui;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerSlideCloseTransition;
import com.ultimatex.nsbm.util.MainContainerState;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainController implements Initializable, SideNavController.OnMainItemClickListener {

    @FXML
    private JFXHamburger hamburger;
    @FXML
    private JFXDrawer drawer;

    @FXML
    private AnchorPane mainContainer;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initDrawer();
    }

    public AnchorPane getMainContainer() {
        return mainContainer;
    }


    @FXML
    public void onHamburgerClick(MouseEvent event) {

    }

    private void initDrawer() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/sidenav.fxml"));
            VBox toolbar = loader.load();
            drawer.setSidePane(toolbar);
            SideNavController controller = loader.getController();
            controller.setListener(this);
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        HamburgerSlideCloseTransition task = new HamburgerSlideCloseTransition(hamburger);
        task.setRate(-1);
        hamburger.addEventHandler(MouseEvent.MOUSE_CLICKED, (Event event) -> {
            drawer.toggle();
        });
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

    public void changeContainer(int stateId) {
        if (stateId == MainContainerState.PAYMENT) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/payments.fxml"));
            AnchorPane anchorPane = null;

            try {
                anchorPane = fxmlLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }


            mainContainer.getChildren().addAll(anchorPane);
        }
    }


    @Override
    public void onStateChanged(int state) {
        changeContainer(state);
    }
}
