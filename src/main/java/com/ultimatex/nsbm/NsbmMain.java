package com.ultimatex.nsbm;


import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDecorator;
import com.jfoenix.controls.JFXTabPane;
import com.ultimatex.nsbm.ui.login.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.Border;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class NsbmMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader =new FXMLLoader(getClass().getResource("/fxml/login.fxml"));
        loader.load();

        LoginController lc=loader.getController();
        primaryStage.setTitle("Login to NSBM portal");
        primaryStage.initStyle(StageStyle.TRANSPARENT);

        Scene scene = new Scene(loader.getRoot(), lc.loginPane.getPrefWidth(), lc.loginPane.getPrefHeight());

        primaryStage.setResizable(false);
        primaryStage.setScene(scene);


        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

