package com.ultimatex.nsbm.ui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDecorator;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.ultimatex.nsbm.util.Session;
import com.ultimatex.nsbm.util.UserNotFoundException;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

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

    @FXML
    Label incorrectLoginText;

    private double windowX;
    private double windowY;

    @FXML
    public void onLoginButtonClick(Event event)
    {
        String email = userName.getText();
        String password = passwordField.getText();

        if (!"".equals(email) || !"".equals(password)) {
            try {
                Session.getInstance(email, password);

                if (Session.getSession() != null)
                    loadMain(event);
            } catch (UserNotFoundException e) {
                incorrectLoginText.setVisible(true);
            } finally {
                incorrectLoginText.setVisible(true);
            }

        } else {
            incorrectLoginText.setVisible(true);
        }

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

    @FXML
    public void onSignupLabelClicked(MouseEvent event) {
        loadSignUp(event);
    }

    private void loadSignUp(MouseEvent event) {
        ((Stage) ((Label) (event.getSource())).getScene().getWindow()).close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/student/signup.fxml"));

        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }


        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("Sign Up for new User");
        JFXDecorator decorator = new JFXDecorator(stage, fxmlLoader.getRoot());
        decorator.setCustomMaximize(true);
        Scene scene = new Scene(decorator);
        stage.setScene(scene);

        stage.show();
    }

    private void loadMain(Event event) {
        ((Stage) ((JFXButton) (event.getSource())).getScene().getWindow()).close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/student/main.fxml"));
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }


        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("Welcome to NSBM portal");
        JFXDecorator decorator = new JFXDecorator(stage, fxmlLoader.getRoot());
        decorator.setCustomMaximize(true);
        Scene scene = new Scene(decorator);
        stage.setScene(scene);

        stage.show();
    }


}
