package com.ultimatex.nsbm;


import com.ultimatex.nsbm.ui.LoginController;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
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


        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ENTER)
                    lc.onLoginButtonClick(event);
            }
        });

        primaryStage.setResizable(false);
        primaryStage.setScene(scene);

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

}


