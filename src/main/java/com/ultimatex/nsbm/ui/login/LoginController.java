package com.ultimatex.nsbm.ui.login;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDecorator;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LoginController {

    @FXML
    JFXTextField userName;
    @FXML
    JFXPasswordField passwordField;
    @FXML
    public AnchorPane loginPane;
    @FXML
    public JFXButton loginButton;
    @FXML
    public JFXButton cancelButton;

    double windowX;
    double windowY;

    @FXML
    public void onLoginButtonClick(Event event) throws Exception
    {
        ((Stage)((JFXButton)(event.getSource())).getScene().getWindow()).close();
        FXMLLoader fxmlLoader =new FXMLLoader(getClass().getResource("/fxml/main.fxml"));
        fxmlLoader.load();


        Stage stage=new Stage(StageStyle.DECORATED);
        stage.setTitle("Welcome to NSBM portal");
        JFXDecorator decorator=new JFXDecorator(stage,fxmlLoader.getRoot());
        decorator.setCustomMaximize(true);
        Scene scene =new Scene(decorator);
        stage.setScene(scene);

        stage.show();

    }

    @FXML
    public void onCancelButtonClick(Event event)
    {
        System.exit(0);
    }

    @FXML
    public void onDragged(MouseEvent event)
    {
        double x=event.getScreenX();
        double y=event.getScreenY();


        loginPane.getScene().getWindow().setX(x-windowX);
        loginPane.getScene().getWindow().setY(y-windowY);


    }

    @FXML
    public void onPaneClicked(MouseEvent event)
    {

    }

    @FXML
    public void onPanePressed(MouseEvent event)
    {
        windowX=event.getX();
        windowY=event.getY();
    }


}
