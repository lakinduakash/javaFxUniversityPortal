package com.ultimatex.nsbm;


import com.ultimatex.nsbm.ui.login.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class NsbmMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //load fxml file
        FXMLLoader loader =new FXMLLoader(getClass().getResource("/fxml/login.fxml"));
        loader.load();
        
        //get controller class
        LoginController lc=loader.getController();
        primaryStage.setTitle("Login to NSBM Portal");
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        
        //set scene
        Scene scene = new Scene(loader.getRoot(), lc.loginPane.getPrefWidth(), lc.loginPane.getPrefHeight());

        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        
        //show the stage
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

